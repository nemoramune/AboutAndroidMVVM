package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
): ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val mutableErrorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = mutableErrorFlow.asSharedFlow()

    fun fetch() {
        viewModelScope.launch {
             pokemonRepository.getRandomImageUrl()
                 .onSuccess { mutableImageUrlLiveData.value = it }
                 .onFailure { error ->  mutableErrorFlow.emit(error) }
        }
    }
}