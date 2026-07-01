package com.movieapp.data.repository

import com.movieapp.BuildConfig
import com.movieapp.data.remote.api.TmdbApiService
import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.Movie
import com.movieapp.domain.model.MovieCategory
import com.movieapp.domain.model.MovieDetail
import com.movieapp.domain.repository.MovieRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: TmdbApiService
) : MovieRepository {

    private val imageBaseUrl = BuildConfig.TMDB_IMAGE_BASE_URL

    override suspend fun getMovies(category: MovieCategory, page: Int): DataResult<List<Movie>> {
        return safeApiCall {
            val response = when (category) {
                MovieCategory.POPULAR -> apiService.getPopularMovies(page)
                MovieCategory.TOP_RATED -> apiService.getTopRatedMovies(page)
                MovieCategory.NOW_PLAYING -> apiService.getNowPlayingMovies(page)
                MovieCategory.UPCOMING -> apiService.getUpcomingMovies(page)
            }
            response.results.map { it.toDomain(imageBaseUrl) }
        }
    }

    override suspend fun searchMovies(query: String, page: Int): DataResult<List<Movie>> {
        return safeApiCall {
            apiService.searchMovies(query, page).results.map { it.toDomain(imageBaseUrl) }
        }
    }

    override suspend fun getMovieDetail(movieId: Int): DataResult<MovieDetail> {
        return safeApiCall {
            val detail = apiService.getMovieDetail(movieId)
            val credits = runCatching { apiService.getMovieCredits(movieId) }.getOrNull()
            detail.toDomain(imageBaseUrl, credits)
        }
    }

    /**
     * Centraliza tratamento de erros de rede/HTTP, convertendo exceptions
     * em um DataResult tipado para a UI consumir de forma segura.
     */
    private suspend inline fun <T> safeApiCall(crossinline action: suspend () -> T): DataResult<T> {
        return try {
            DataResult.Success(action())
        } catch (e: IOException) {
            DataResult.Error("Falha de conexão. Verifique sua internet.", e)
        } catch (e: HttpException) {
            DataResult.Error("Erro do servidor (${e.code()}). Tente novamente.", e)
        } catch (e: Exception) {
            DataResult.Error(e.message ?: "Erro inesperado.", e)
        }
    }
}
