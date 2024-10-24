package com.example.mod4tp1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Random

class DiceViewModel : ViewModel() {


    private val _totalLaunch = MutableStateFlow(0)
    var totalLaunch: StateFlow<Int> = _totalLaunch
    var totalLaunchLeft = 0
    var totalLaunchRight = 0
    var totalLeft = 0
    var totalRight = 0

    var diceImageId = R.drawable.d1

    fun reset() {
        _totalLaunch.value = 0
        totalLaunchLeft = 0
        totalLaunchRight = 0
        totalLeft = 0
        totalRight = 0
    }

    fun rollDice(): Int {
        val currentRoll = (1..6).random()
        _totalLaunch.value = _totalLaunch.value.inc()

       diceImageId = when(currentRoll) {
            1 -> R.drawable.d1
            2 -> R.drawable.d2
            3 -> R.drawable.d3
            4 -> R.drawable.d4
            5 -> R.drawable.d5
            else -> R.drawable.d6
        }
        return currentRoll

    }

    fun rollLeft(){
        totalLeft += rollDice()
        totalLaunchLeft++
    }

    fun rollRight(){
        totalRight += rollDice()
        totalLaunchRight++
    }
}