package com.nemoramune.aboutmvvm

import javax.inject.Inject
import kotlin.random.Random

class PokemonRepository @Inject constructor() {
    suspend fun getRandomImageUrl(): Result<String> = runCatching {
        val randomId = Random.nextInt(1, 151)
        ApiClient.pokemonApi.getPokemonData(randomId).sprites.frontDefault
    }
}