package com.nemoramune.aboutmvvm

import com.squareup.moshi.Json

data class PokemonResponse(val sprites: PokemonSprites)

data class PokemonSprites(
    @Json(name = "front_default")
    val frontDefault: String
)