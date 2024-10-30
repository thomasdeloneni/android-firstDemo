package com.example.mod6demo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.mod6demo2.CoffeeVariety

class CoffeeVarietyViewModel(private val repository: CoffeeRepository): ViewModel() {

    private val _coffeeVarieties = MutableStateFlow<List<CoffeeVariety>>(emptyList())
    val coffeeVarieties = _coffeeVarieties.asStateFlow()


    init {
        val c = CoffeeVariety(name = "Java", origin = "Indonesia", type = CoffeeType.ARABICA)
        val c2 = CoffeeVariety(name = "Bourbon pointu", origin = "Ile de la Réunion", type = CoffeeType.ARABICA)

        repository.insert(c)
        repository.insert(c2)
        _coffeeVarieties.value = repository.findAll()
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val coffeeVarietyDbHelper = CoffeeVarietyDbHelper(application.applicationContext)

                return CoffeeVarietyViewModel(
                    CoffeeRepository(CoffeeVarietyDAO(coffeeVarietyDbHelper.writableDatabase, coffeeVarietyDbHelper.readableDatabase))
                ) as T
            }
        }
    }
}