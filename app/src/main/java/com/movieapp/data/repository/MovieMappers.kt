package com.movieapp.data.repository

import com.movieapp.data.remote.dto.CastDto
import com.movieapp.data.remote.dto.CreditsResponseDto
import com.movieapp.data.remote.dto.GenreDto
import com.movieapp.data.remote.dto.MovieDetailDto
import com.movieapp.data.remote.dto.MovieDto
import com.movieapp.domain.model.CastMember
import com.movieapp.domain.model.Genre
import com.movieapp.domain.model.Movie
import com.movieapp.domain.model.MovieDetail

private const val POSTER_SIZE = "w500"
private const val BACKDROP_SIZE = "w780"
private const val PROFILE_SIZE = "w185"

fun MovieDto.toDomain(imageBaseUrl: String): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { "$imageBaseUrl$POSTER_SIZE$it" },
        backdropUrl = backdropPath?.let { "$imageBaseUrl$BACKDROP_SIZE$it" },
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genreIds = genreIds
    )
}

fun GenreDto.toDomain(): Genre = Genre(id = id, name = name)

fun CastDto.toDomain(imageBaseUrl: String): CastMember {
    return CastMember(
        id = id,
        name = name,
        character = character,
        profileUrl = profilePath?.let { "$imageBaseUrl$PROFILE_SIZE$it" }
    )
}

fun MovieDetailDto.toDomain(
    imageBaseUrl: String,
    credits: CreditsResponseDto?
): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { "$imageBaseUrl$POSTER_SIZE$it" },
        backdropUrl = backdropPath?.let { "$imageBaseUrl$BACKDROP_SIZE$it" },
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        runtimeMinutes = runtime,
        status = status,
        tagline = tagline?.takeIf { it.isNotBlank() },
        budget = budget,
        revenue = revenue,
        homepage = homepage?.takeIf { it.isNotBlank() },
        genres = genres.map { it.toDomain() },
        productionCompanies = productionCompanies.map { it.name },
        cast = credits?.cast
            ?.sortedBy { it.order }
            ?.take(10)
            ?.map { it.toDomain(imageBaseUrl) }
            ?: emptyList()
    )
}
