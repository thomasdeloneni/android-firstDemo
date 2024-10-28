package com.example.mod5demo3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mod5demo3.ui.theme.FirstDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Call()

                    }
                }
            }
        }
    }
}

@Composable
fun Call() {

    val context = LocalContext.current

    val requestPermissionCall = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Intent(Intent.ACTION_CALL, Uri.parse("tel:1234567890")).also {
                context.startActivity(it)
            }
        }else{
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890")).also {
                context.startActivity(it)
            }
        }
    }

    Button(onClick = {
        requestPermissionCall.launch(android.Manifest.permission.CALL_PHONE)
    }) {
        Text("CALL")
    }

}