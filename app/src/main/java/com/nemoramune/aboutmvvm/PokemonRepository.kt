package com.nemoramune.aboutmvvm

import javax.inject.Inject

class PokemonRepository @Inject constructor() {
    private val pokemonApi: PokemonApi = ApiModule.pokemonApi
    fun getRandomImageUrl() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
}