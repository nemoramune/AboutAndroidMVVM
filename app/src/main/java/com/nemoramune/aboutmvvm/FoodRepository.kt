package com.nemoramune.aboutmvvm

import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodishApi: FoodishApi
) {
    fun getRandomImageUrl() = "https://foodish-api.herokuapp.com/images/pizza/pizza50.jpg"
}