package com.example.mod7demo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod7demo1.bo.Joke
import com.example.mod7demo1.ui.theme.JokeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel(private val jokeRepository: JokeRepository) : ViewModel() {


    private val _joke = MutableStateFlow<Joke?>(null)
    val joke = _joke.asStateFlow()

    init {
        getRandomJoke()
    }

    fun getRandomJoke(){
        viewModelScope.launch(Dispatchers.IO
        ) {
            _joke.value = jokeRepository.getJoke()
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])

                return JokeViewModel(
                    JokeRepository(
                        JokeService.jokeApi.retrofitService
                    )
                ) as T
            }
        }
    }
}