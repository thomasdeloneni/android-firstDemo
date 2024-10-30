package com.example.mod6demo1

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ColorSettingViewModel(private val colorPreferenceRepository: ColorPreferenceRepository) : ViewModel() {

    private val _colorPref = MutableStateFlow<Color>(Color.White)
    var colorPref = _colorPref.asStateFlow()

    init {
        getBgColor()
    }

    fun getBgColor() {
        viewModelScope.launch(Dispatchers.IO) {
            colorPreferenceRepository.getColor().collect{
                _colorPref.value = it
            }
        }
    }

    fun setBgColor(color: Color) {
        viewModelScope.launch(Dispatchers.IO) {
            colorPreferenceRepository.setColor(color)
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
                return ColorSettingViewModel(
                    ColorPreferenceRepository(application.applicationContext)
                ) as T
            }
        }
    }
}