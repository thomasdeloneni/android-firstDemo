package com.example.mod3demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListExample()
        }
    }
}

@Composable
fun ListExample(modifier: Modifier = Modifier) {

    val articles = List(400) { "Articles $it" }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),) {
        items(articles) {article : String ->
            ArticleItem(article = article)
        }
    }
}

@Composable
fun ArticleItem(article : String) {
    Surface(border = BorderStroke(2.dp, Color.Magenta),
        shape = CircleShape,
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.inversePrimary) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
        ) {
            Text(text = article)
            Checkbox(checked = false, onCheckedChange = { })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ListExample()
}