package br.com.testproject.repositories.movie

import br.com.testproject.api.movies.MoviesApi

class MoviesRepository(private val movieApi: MoviesApi) {

    suspend fun getMovies(): Movie {
        return movieApi.getMovie().map()
    }
}


