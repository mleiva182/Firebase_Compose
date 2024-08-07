package com.mleiva.firebase_compose.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.auth.FirebaseUser
import com.mleiva.firebase_compose.ui.screens.ForgotPassword.ForgotPasswordScreen
import com.mleiva.firebase_compose.ui.screens.Screen
import com.mleiva.firebase_compose.ui.screens.SignUp.SignUpScreen
import com.mleiva.firebase_compose.ui.screens.home.HomeScreen
import com.mleiva.firebase_compose.ui.screens.login.LoginScreen
import com.mleiva.firebase_compose.utils.AnalyticsManager
import com.mleiva.firebase_compose.utils.AuthManager

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.navigation
 * Creted by: Marcelo Leiva on 07-08-2024 at 10:15
 ***/
@Composable
fun Navigation(
    context: Context,
    navController: NavHostController = rememberNavController()
) {
    var analytics: AnalyticsManager = AnalyticsManager(context)
    val authManager: AuthManager = AuthManager()

    val user: FirebaseUser? = authManager.getCurrentUser()

    Screen {
        NavHost(
            navController = navController,
            startDestination = if(user==null) Routes.Login.route else Routes.Home.route
        ) {
            composable(Routes.Login.route) {
                LoginScreen(
                    analytics,
                    authManager,
                    navigation = navController
                )
            }
            composable(Routes.Home.route) {
                HomeScreen(
                    analytics,
                    authManager,
                    navigation = navController
                )
            }
            composable(Routes.SignUp.route) {
                SignUpScreen(
                    authManager = authManager,
                    analytics = analytics,
                    navigation = navController
                )
            }
            composable(Routes.ForgotPassword.route) {
                ForgotPasswordScreen(
                    authmanager = authManager,
                    analytics = analytics,
                    navigation = navController
                )
            }
        }
    }
}