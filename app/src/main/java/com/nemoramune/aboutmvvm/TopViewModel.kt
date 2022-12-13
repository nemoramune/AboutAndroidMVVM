package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class TopViewModel: ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val mutableErrorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = mutableErrorFlow.asSharedFlow()

    private val pokemonRepository = PokemonRepository()

    fun fetch() {
        viewModelScope.launch {
             pokemonRepository.getRandomImageUrl()
                 .onSuccess { mutableImageUrlLiveData.value = it }
                 .onFailure { error ->  mutableErrorFlow.emit(error) }
        }
    }
}