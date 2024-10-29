package com.example.mod5demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymod5demo5.ui.theme.FirstDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemoTheme() {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost(navHostController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navHostController,
        //composant à afficher en premier
        startDestination = SignInDestination.route
    ) {
        composable(route = SignInDestination.route) {
            SignInPage(onClickToHome = {
                navHostController.navigate("${HomeDestination.route}/$it");
            })
        }
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = HomeDestination.args
        ) { navBackStackEntry ->

            val login = navBackStackEntry.arguments?.getString(HomeDestination.argName)
            if (login != null) {
                HomePage(loginValue = login)
            }
        }
    }
}

@Composable
fun HomePage(loginValue: String) {
    Scaffold() {

        Column(modifier = Modifier.padding(it)) {
            Text("Hello $loginValue !")
        }
    }
}

@Composable
fun SignInPage(onClickToHome: (String) -> Unit) {

    var loginValue by remember {
        mutableStateOf("")
    }

    Scaffold() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {

            TextField(
                value = loginValue,
                label = { Text("Login") },
                onValueChange = {
                    loginValue = it
                })

            OutlinedButton(onClick = { onClickToHome(loginValue) }) {
                Text(text = "Se connecter")
            }
        }

    }
}

@Composable
@Preview
fun Preview() {
    // SignInPage()
}







