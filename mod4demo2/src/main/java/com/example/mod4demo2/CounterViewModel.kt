package com.example.mod4demo2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {

    private val _counter: MutableStateFlow<Int> = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    var nbPlus: Int = 0
    var nbMinus: Int = 0

    fun minus(){
        _counter.value = _counter.value.minus(1)
    }

    fun add() {
        _counter.value = _counter.value.inc()
    }
}