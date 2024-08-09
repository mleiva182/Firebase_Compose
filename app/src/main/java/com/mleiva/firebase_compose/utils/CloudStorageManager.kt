package com.mleiva.firebase_compose.utils

import android.content.Context
import android.net.Uri
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose.utils
 * Creted by: Marcelo Leiva on 09-08-2024 at 15:58
 ***/
class CloudStorageManager(context: Context) {
    private val storage = Firebase.storage
    private val storageRef = storage.reference
    private val authManager = AuthManager(context)
    private val userId = authManager.getCurrentUser()?.uid

    fun getStorageReference(): StorageReference {
        return storageRef.child("photos").child(userId ?: "")
    }

    suspend fun uploadFile(fileName: String, filePath: Uri) {
        val fileRef = getStorageReference().child(fileName)
        val uploadTask = fileRef.putFile(filePath)
        uploadTask.await()
    }

    suspend fun getUserImages(): List<String> {
        val imageUrls = mutableListOf<String>()
        val listResult: ListResult = getStorageReference().listAll().await()
        for (item in listResult.items) {
            val url = item.downloadUrl.await().toString()
            imageUrls.add(url)
        }
        return imageUrls
    }
}