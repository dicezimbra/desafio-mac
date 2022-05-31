package br.com.testproject.repositories.character

import br.com.testproject.api.movies.CharacterQuoteRequest
import br.com.testproject.api.movies.QuoteRequest

class Quote(
    var docs: List<QuoteItem>,
    var total: Int,
    var limit: Int,
    var page: Int,
    var pages: Int,
    var offset: Int
)

class QuoteItem(
    var _id: String,
    var dialog: String ,
    var movie: String,
    var character: String,
    var id: String
)

fun CharacterQuoteRequest.map(): Quote {
    return Quote(
        docs = this.docs.map { it.map() },
    total = this.total,
    limit = this.limit,
    page = this.page,
    pages = this.pages,
    offset = this.offset,
    )
}

private fun QuoteRequest.map(): QuoteItem {
    return QuoteItem(
        _id = this._id,
        dialog = this.dialog,
        movie = this.movie,
        character = this.character,
        id = this.id,
    )
}
