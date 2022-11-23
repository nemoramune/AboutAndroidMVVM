package com.nemoramune.aboutmvvm

import retrofit2.http.GET

interface FoodishApi {
    @GET("api")
    suspend fun getRandomFood(): FoodImageResponse
}