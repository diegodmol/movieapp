package com.movieapp.domain.usecase

import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.MovieDetail
import com.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): DataResult<MovieDetail> {
        return repository.getMovieDetail(movieId)
    }
}
