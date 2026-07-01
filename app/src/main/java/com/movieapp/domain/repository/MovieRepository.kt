package com.movieapp.domain.repository

import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.Movie
import com.movieapp.domain.model.MovieCategory
import com.movieapp.domain.model.MovieDetail

/**
 * Contrato definido na camada de domínio. A implementação concreta
 * fica na camada de dados (data/repository), respeitando a inversão de dependência.
 */
interface MovieRepository {

    suspend fun getMovies(category: MovieCategory, page: Int = 1): DataResult<List<Movie>>

    suspend fun searchMovies(query: String, page: Int = 1): DataResult<List<Movie>>

    suspend fun getMovieDetail(movieId: Int): DataResult<MovieDetail>
}
