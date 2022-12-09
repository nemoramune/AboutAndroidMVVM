package com.nemoramune.aboutmvvm

import kotlin.random.Random

class PokemonRepository {
    suspend fun getRandomImageUrl(): String {
        val randomId = Random.nextInt(1, 151)
        return ApiClient.pokemonApi.getPokemonData(randomId).sprites.frontDefault
    }
}