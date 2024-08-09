package com.mleiva.firebase_compose.data.model

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.data.model
 * Creted by: Marcelo Leiva on 09-08-2024 at 10:41
 ***/
data class Note(
    var id: String? = null,
    var userId: String = "",
    val title: String = "",
    val content: String = ""
)