package com.nemoramune.aboutmvvm

import javax.inject.Inject

class FoodRepository @Inject constructor() {
    fun getRandomImageUrl() = "https://foodish-api.herokuapp.com/images/pizza/pizza50.jpg"
}