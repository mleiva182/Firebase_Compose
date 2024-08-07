package com.mleiva.firebase_compose.ui.navigation

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.navigation
 * Creted by: Marcelo Leiva on 07-08-2024 at 10:16
 ***/
sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Home : Routes("Home")
    object SignUp : Routes("SignUp Screen")
    object ForgotPassword : Routes("ForgotPassword Screen")
}