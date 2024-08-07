package com.mleiva.firebase_compose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mleiva.firebase_compose.ui.theme.Firebase_ComposeTheme

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.screens
 * Creted by: Marcelo Leiva on 07-08-2024 at 10:19
 ***/
@Composable
fun Screen(content: @Composable () -> Unit) {
    Firebase_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}