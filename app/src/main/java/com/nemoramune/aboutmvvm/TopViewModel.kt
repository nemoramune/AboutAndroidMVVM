package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class TopViewModel: ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val pokemonRepository = PokemonRepository()

    fun fetch() {
        mutableImageUrlLiveData.value = pokemonRepository.getRandomImageUrl()
    }
}