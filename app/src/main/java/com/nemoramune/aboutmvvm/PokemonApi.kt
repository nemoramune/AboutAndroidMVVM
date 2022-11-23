package com.nemoramune.aboutmvvm

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{id}")
    suspend fun getPokemonData(@Path("id") id: Int): PokemonResponse
}