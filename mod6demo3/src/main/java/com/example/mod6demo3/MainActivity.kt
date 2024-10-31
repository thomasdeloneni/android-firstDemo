package com.example.mod6demo3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6demo3.ui.theme.FirstDemoTheme
import com.example.mod6demo3.vm.TreeViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    TreeList()
                }
            }
        }
    }
}

@Composable
fun TreeList(
    treeViewModel: TreeViewModel = viewModel(factory = TreeViewModel.Factory)) {
    val trees by treeViewModel.trees.collectAsState()

    LazyColumn(){
        items(trees) {
            Text(text = "${it.name} - ${it.lifeExpectancy} years")
        }
    }
    }


