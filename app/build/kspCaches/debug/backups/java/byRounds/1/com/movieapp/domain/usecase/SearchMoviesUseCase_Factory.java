package com.movieapp.domain.usecase;

import com.movieapp.domain.repository.MovieRepository;
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
public final class SearchMoviesUseCase_Factory implements Factory<SearchMoviesUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public SearchMoviesUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchMoviesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchMoviesUseCase_Factory create(Provider<MovieRepository> repositoryProvider) {
    return new SearchMoviesUseCase_Factory(repositoryProvider);
  }

  public static SearchMoviesUseCase newInstance(MovieRepository repository) {
    return new SearchMoviesUseCase(repository);
  }
}
