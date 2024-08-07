package com.mleiva.firebase_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.mleiva.firebase_compose.ui.navigation.Navigation
import com.mleiva.firebase_compose.ui.theme.Firebase_ComposeTheme

class MainActivity : ComponentActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analytics = Firebase.analytics

        setContent {
            Firebase_ComposeTheme {
                Navigation(this)
            }
        }
    }
}