package com.movieapp.presentation.screen.home

import com.movieapp.domain.model.Movie
import com.movieapp.domain.model.MovieCategory

/**
 * Estado imutável da tela Home — única fonte de verdade para a UI (UDF).
 */
data class HomeUiState(
    val selectedCategory: MovieCategory = MovieCategory.POPULAR,
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
    val searchResults: List<Movie> = emptyList(),
    val isSearching: Boolean = false
)
