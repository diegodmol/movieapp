package com.movieapp.domain.usecase

import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.Movie
import com.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String, page: Int = 1): DataResult<List<Movie>> {
        if (query.isBlank()) return DataResult.Success(emptyList())
        return repository.searchMovies(query.trim(), page)
    }
}
