package com.nemoramune.aboutmvvm

import kotlin.random.Random

class PokemonRepository {
    suspend fun getRandomImageUrl(): Result<String> = runCatching {
        val randomId = Random.nextInt(1, 151)
        ApiClient.pokemonApi.getPokemonData(randomId).sprites.frontDefault
    }
}