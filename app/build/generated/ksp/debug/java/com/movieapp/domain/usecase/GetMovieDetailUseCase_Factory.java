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
public final class GetMovieDetailUseCase_Factory implements Factory<GetMovieDetailUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public GetMovieDetailUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetMovieDetailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetMovieDetailUseCase_Factory create(Provider<MovieRepository> repositoryProvider) {
    return new GetMovieDetailUseCase_Factory(repositoryProvider);
  }

  public static GetMovieDetailUseCase newInstance(MovieRepository repository) {
    return new GetMovieDetailUseCase(repository);
  }
}
