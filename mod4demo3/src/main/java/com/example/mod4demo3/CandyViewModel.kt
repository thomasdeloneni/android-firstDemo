package com.example.mod4demo3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CandyViewModel(candyRepository: CandyRepository) : ViewModel() {

    private val _candies = MutableStateFlow<List<String>>(emptyList())

    //val candies : StateFlow<List<String>> = _candies
    val candies = _candies.asStateFlow()

    init {
        _candies.value = candyRepository.getAllCandies()
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return CandyViewModel(
                    CandyRepository()
                ) as T
            }
        }
    }

}