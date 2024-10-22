package com.example.mod3demo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun RowAndColumnExample(){
    Column {
        Text("Example pour Row et column")
        Row {
            Text("Element 1")
            Text("Element 2")
            Text("Element 3")
        }
        Column {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
    }
}

@Composable
fun BoxExample() {

    Box(contentAlignment = Alignment.BottomEnd) {

        Image(painter = painterResource(id=R.drawable.compose_man) , contentDescription = "Compose Man")

        Icon(
            imageVector = Icons.Default.Face,
            contentDescription=null,
            tint = Color.Yellow
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BoxExample()
}