package com.nemoramune.aboutmvvm

import javax.inject.Inject
import kotlin.random.Random

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getRandomImageUrl(): String {
        val randomId = Random.nextInt(1, 151)
        return pokemonApi.getPokemonData(randomId).sprites.frontDefault
    }
}