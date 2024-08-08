package com.mleiva.firebase_compose.data.model

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.data.model
 * Creted by: Marcelo Leiva on 08-08-2024 at 14:43
 ***/
data class Contact(
    val key: String? = null,
    val name: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val uid: String = ""
)