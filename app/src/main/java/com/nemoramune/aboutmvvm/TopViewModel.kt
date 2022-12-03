package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel: ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    fun fetch() {
        mutableImageUrlLiveData.value = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
    }
}