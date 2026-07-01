package com.movieapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.domain.model.DataResult
import com.movieapp.domain.model.MovieCategory
import com.movieapp.domain.usecase.GetMoviesUseCase
import com.movieapp.domain.usecase.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null

    init {
        loadMovies(MovieCategory.POPULAR)
    }

    fun onCategorySelected(category: MovieCategory) {
        if (category == _uiState.value.selectedCategory) return
        loadMovies(category)
    }

    fun onRetryClick() {
        loadMovies(_uiState.value.selectedCategory)
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        searchJob?.cancel()

        if (query.isBlank()) {
            _uiState.update { it.copy(searchResults = emptyList(), isSearching = false) }
            return
        }

        searchJob = viewModelScope.launch {
            delay(SEARCH_DEBOUNCE_MS) // Debounce para evitar chamadas excessivas à API
            _uiState.update { it.copy(isSearching = true) }
            when (val result = searchMoviesUseCase(query)) {
                is DataResult.Success -> _uiState.update {
                    it.copy(searchResults = result.data, isSearching = false)
                }
                is DataResult.Error -> _uiState.update {
                    it.copy(isSearching = false, errorMessage = result.message)
                }
            }
        }
    }

    fun onSearchActiveChanged(active: Boolean) {
        _uiState.update { it.copy(isSearchActive = active) }
        if (!active) {
            searchJob?.cancel()
            _uiState.update { it.copy(searchQuery = "", searchResults = emptyList()) }
        }
    }

    private fun loadMovies(category: MovieCategory) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(selectedCategory = category, isLoading = true, errorMessage = null)
            }
            when (val result = getMoviesUseCase(category)) {
                is DataResult.Success -> _uiState.update {
                    it.copy(movies = result.data, isLoading = false)
                }
                is DataResult.Error -> _uiState.update {
                    it.copy(isLoading = false, errorMessage = result.message)
                }
            }
        }
    }

    private companion object {
        const val SEARCH_DEBOUNCE_MS = 400L
    }
}
