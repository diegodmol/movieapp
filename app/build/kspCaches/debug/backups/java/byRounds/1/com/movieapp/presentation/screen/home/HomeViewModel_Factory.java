package com.movieapp.presentation.screen.home;

import com.movieapp.domain.usecase.GetMoviesUseCase;
import com.movieapp.domain.usecase.SearchMoviesUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetMoviesUseCase> getMoviesUseCaseProvider;

  private final Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetMoviesUseCase> getMoviesUseCaseProvider,
      Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider) {
    this.getMoviesUseCaseProvider = getMoviesUseCaseProvider;
    this.searchMoviesUseCaseProvider = searchMoviesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getMoviesUseCaseProvider.get(), searchMoviesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GetMoviesUseCase> getMoviesUseCaseProvider,
      Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider) {
    return new HomeViewModel_Factory(getMoviesUseCaseProvider, searchMoviesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetMoviesUseCase getMoviesUseCase,
      SearchMoviesUseCase searchMoviesUseCase) {
    return new HomeViewModel(getMoviesUseCase, searchMoviesUseCase);
  }
}
