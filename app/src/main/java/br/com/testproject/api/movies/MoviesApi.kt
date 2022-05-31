package br.com.testproject.api.movies

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie")
    suspend fun getMovie(): MovieRequest

    @GET("character")
    suspend fun getCharacters(@Query("limit") limit: Int, @Query("page") page: Int, @Query("sort") sort: String = "name:asc"): CharacterRequest

    @GET("character/{id}/quote")
    suspend fun getCharacterQuote(@Path("id") id: String): CharacterQuoteRequest


}