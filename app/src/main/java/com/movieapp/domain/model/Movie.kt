package com.movieapp.domain.model

/**
 * Modelo de domínio para um filme na listagem.
 * Independente de qualquer detalhe de API/rede (DTO) ou de banco.
 */
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String?,
    val backdropUrl: String?,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val genreIds: List<Int>
)

/**
 * Modelo de domínio para os detalhes completos de um filme.
 */
data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String?,
    val backdropUrl: String?,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val runtimeMinutes: Int?,
    val status: String,
    val tagline: String?,
    val budget: Long,
    val revenue: Long,
    val homepage: String?,
    val genres: List<Genre>,
    val productionCompanies: List<String>,
    val cast: List<CastMember>
)

data class Genre(
    val id: Int,
    val name: String
)

data class CastMember(
    val id: Int,
    val name: String,
    val character: String,
    val profileUrl: String?
)

/**
 * Categorias de listagem disponíveis na Home.
 */
enum class MovieCategory(val displayName: String) {
    POPULAR("Populares"),
    TOP_RATED("Mais Bem Avaliados"),
    NOW_PLAYING("Em Cartaz"),
    UPCOMING("Em Breve")
}
