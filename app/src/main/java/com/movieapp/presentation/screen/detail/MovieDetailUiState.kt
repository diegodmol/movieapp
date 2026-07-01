package com.movieapp.presentation.screen.detail

import com.movieapp.domain.model.MovieDetail

data class MovieDetailUiState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
