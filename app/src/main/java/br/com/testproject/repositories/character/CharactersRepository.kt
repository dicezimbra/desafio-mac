package br.com.testproject.repositories.character

import br.com.testproject.api.movies.MoviesApi

class CharactersRepository (private val movieApi: MoviesApi) {

    suspend fun getCharacters(page: Int, quantity: Int): Character {
        return movieApi.getCharacters(quantity, page).map()
    }

    suspend fun getCharactersQuote(id: String): Quote {
        //return movieApi.getCharacterQuote("5cd99d4bde30eff6ebccfe9e").map()
        return movieApi.getCharacterQuote(id).map()
    }
}

