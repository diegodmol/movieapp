package com.movieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

// ─── Movie List Response ───────────────────────────────────────────────────

data class MovieListResponseDto(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String
)

// ─── Movie Detail Response ─────────────────────────────────────────────────

data class MovieDetailDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("budget") val budget: Long,
    @SerializedName("revenue") val revenue: Long,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genres") val genres: List<GenreDto>,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyDto>,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguageDto>
)

data class GenreDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class ProductionCompanyDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String
)

data class SpokenLanguageDto(
    @SerializedName("iso_639_1") val iso: String,
    @SerializedName("name") val name: String,
    @SerializedName("english_name") val englishName: String
)

// ─── Credits Response ──────────────────────────────────────────────────────

data class CreditsResponseDto(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastDto>,
    @SerializedName("crew") val crew: List<CrewDto>
)

data class CastDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("character") val character: String,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("order") val order: Int
)

data class CrewDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("job") val job: String,
    @SerializedName("department") val department: String,
    @SerializedName("profile_path") val profilePath: String?
)
