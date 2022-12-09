package com.nemoramune.aboutmvvm

class PokemonRepository {
    suspend fun getRandomImageUrl(): String {
        return ApiClient.pokemonApi.getPokemonData(1).sprites.frontDefault
    }
}