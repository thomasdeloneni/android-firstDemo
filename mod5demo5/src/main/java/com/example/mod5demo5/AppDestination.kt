package com.example.mod5demo5

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination{
    val route : String
}

object HomeDestination : Destination{
    override val route: String
        get() = "Home"

    val argName = "loginValue"

    val args = listOf(
        navArgument(argName){
            type = NavType.StringType
        }
    )
    val routeWithArgs = "$route/{$argName}"
}

object SignInDestination : Destination{
    override val route: String
        get() = "SignIn"
}