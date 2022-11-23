package com.nemoramune.aboutmvvm

import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodishApi: FoodishApi
) {
    suspend fun getRandomImageUrl() = kotlin.runCatching {
        foodishApi.getRandomFood().image
    }
}