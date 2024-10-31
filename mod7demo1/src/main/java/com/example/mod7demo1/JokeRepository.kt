package com.example.mod7demo1

import com.example.mod7demo1.bo.Joke
import com.example.mod7demo1.ui.theme.JokeService

class JokeRepository(private val jokeService: JokeService) {

    suspend fun getJoke(): Joke {
        return jokeService.getRandomJoke()
    }
}