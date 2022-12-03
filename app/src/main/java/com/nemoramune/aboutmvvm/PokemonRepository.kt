package com.nemoramune.aboutmvvm

import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getRandomImageUrl() = pokemonApi.getPokemonData(1).sprites.frontDefault
}