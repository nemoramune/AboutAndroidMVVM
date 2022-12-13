package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TopViewModel: ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val pokemonRepository = PokemonRepository()

    fun fetch() {
        viewModelScope.launch {
             pokemonRepository.getRandomImageUrl()
                 .onSuccess { mutableImageUrlLiveData.value = it }
        }
    }
}