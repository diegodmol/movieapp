package com.movieapp.domain.usecase

import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.Movie
import com.movieapp.domain.model.MovieCategory
import com.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

/**
 * Use Case: busca filmes por categoria.
 * Cada Use Case representa UMA ação de negócio (Single Responsibility).
 */
class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(category: MovieCategory, page: Int = 1): DataResult<List<Movie>> {
        return repository.getMovies(category, page)
    }
}
