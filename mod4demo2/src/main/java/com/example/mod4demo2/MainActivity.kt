package com.example.mod4demo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod4demo2.ui.theme.FirstDemoTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding) ) {
                        Counter()
                    }
                }
            }
        }
    }
}

@Composable
fun Counter(viewModel: CounterViewModel = viewModel()) {

    val counter by viewModel.counter.collectAsState()

    val nbPlus = viewModel.nbPlus
    val nbMinus = viewModel.nbMinus
    Row{
        IconButton(onClick = {
            viewModel.minus()
        }) {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)

        }
        Text(text = counter.toString())
        IconButton(onClick = {
            viewModel.add()
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
@Preview
fun Preview() {
    Counter()
}