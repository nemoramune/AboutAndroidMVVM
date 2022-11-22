package com.nemoramune.aboutmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel: ViewModel() {
    private val mutableImageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = mutableImageUrlLiveData

    private val foodRepository = FoodRepository()

    fun fetch() {
        mutableImageUrlLiveData.value = foodRepository.getRandomImageUrl()
    }
}