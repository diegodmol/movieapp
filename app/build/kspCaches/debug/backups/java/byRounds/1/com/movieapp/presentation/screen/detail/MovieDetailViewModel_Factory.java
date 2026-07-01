package com.movieapp.presentation.screen.detail;

import androidx.lifecycle.SavedStateHandle;
import com.movieapp.domain.usecase.GetMovieDetailUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class MovieDetailViewModel_Factory implements Factory<MovieDetailViewModel> {
  private final Provider<GetMovieDetailUseCase> getMovieDetailUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public MovieDetailViewModel_Factory(Provider<GetMovieDetailUseCase> getMovieDetailUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getMovieDetailUseCaseProvider = getMovieDetailUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public MovieDetailViewModel get() {
    return newInstance(getMovieDetailUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static MovieDetailViewModel_Factory create(
      Provider<GetMovieDetailUseCase> getMovieDetailUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new MovieDetailViewModel_Factory(getMovieDetailUseCaseProvider, savedStateHandleProvider);
  }

  public static MovieDetailViewModel newInstance(GetMovieDetailUseCase getMovieDetailUseCase,
      SavedStateHandle savedStateHandle) {
    return new MovieDetailViewModel(getMovieDetailUseCase, savedStateHandle);
  }
}
