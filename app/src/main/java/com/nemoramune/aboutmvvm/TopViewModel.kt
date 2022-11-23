package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(private val foodRepository: FoodRepository): ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val mutableErrorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = mutableErrorFlow.asSharedFlow()

    fun fetch() {
        viewModelScope.launch {
            foodRepository.getRandomImageUrl()
                .onSuccess { imageURl -> mutableImageUrlLiveData.value = imageURl }
                .onFailure { error ->  mutableErrorFlow.emit(error) }
        }
    }
}