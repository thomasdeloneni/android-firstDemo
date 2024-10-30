package com.example.mod6demo1

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ColorPreferenceRepository(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "color_preferences")

    private val KEY_BG_COLOR = intPreferencesKey("KEY_BG_COLOR")

    suspend fun setColor(color: Color) {
        context.dataStore.edit { pref ->
            pref[KEY_BG_COLOR] = color.toArgb()
        }
    }

    fun getColor() : Flow<Color> {
       return context.dataStore.data.map {pref ->
           Color(pref[KEY_BG_COLOR] ?: Color.White.toArgb())
       }
    }
}