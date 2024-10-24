package com.example.mod4demo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod4demo1.ui.theme.FirstDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemoTheme {
                Form()
            }
        }
    }
}


@Composable
fun Form() {
    var firstName = ""
    var lastName by remember { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") } //conserve le champ grâce au rememberSaveable qui garde les config
    Column {
        TextField(value = firstName, onValueChange = {
            firstName = it
        }, label = { Text(text = "Prénom") })
        TextField(value = lastName, onValueChange = {
            lastName = it
        }, label = { Text(text = "Nom") })
        TextField(
            value = age,
            onValueChange = {
            age = it
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Age") })
    }
}

@Composable
@Preview
fun Preview() {
    Form()
}

