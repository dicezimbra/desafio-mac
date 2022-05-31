package br.com.testproject.repositories.movie

import br.com.testproject.api.movies.MovieItemRequest
import br.com.testproject.api.movies.MovieRequest

class Movie(
    var docs: List<MovieItem>,
    var total: Double,
    var limit: Double,
    var offset: Double,
    var page: Double,
    var pages: Double
)

class MovieItem(
    var id: String,
    var name: String,
    var runtimeInMinutes: String,
    var budgetInMillions: String,
    var boxOfficeRevenueInMillions: String,
    var academyAwardNominations: String,
    var academyAwardWins: String,
    var rottenTomatoesScore: String
)

fun MovieRequest.map(): Movie {
    return Movie(
        docs = this.docs.map { it.map() },
        total = this.total,
        limit = this.limit,
        offset = this.offset,
        page = this.page,
        pages = this.pages
    )
}

fun MovieItemRequest.map(): MovieItem {
    return MovieItem(
        id = this.id,
        name = this.name,
        runtimeInMinutes = this.runtimeInMinutes?.toString() ?: "",
        budgetInMillions = this.budgetInMillions?.toString() ?: "",
        boxOfficeRevenueInMillions = this.boxOfficeRevenueInMillions?.toString() ?: "",
        academyAwardNominations = this.academyAwardNominations?.toString() ?: "",
        academyAwardWins = this.academyAwardWins?.toString() ?: "",
        rottenTomatoesScore = this.rottenTomatoesScore?.toString() ?: ""
    )
}