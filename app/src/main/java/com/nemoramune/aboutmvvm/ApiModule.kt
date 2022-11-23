package com.nemoramune.aboutmvvm

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiModule {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://foodish-api.herokuapp.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val foodishApi = retrofit.create(FoodishApi::class.java)
}