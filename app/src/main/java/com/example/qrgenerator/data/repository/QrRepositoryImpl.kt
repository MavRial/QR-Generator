package com.example.qrgenerator.data.repository

import com.example.qrgenerator.data.mapper.toDomain
import com.example.qrgenerator.data.model.QrDto
import com.example.qrgenerator.domain.model.QrDomain
import com.example.qrgenerator.domain.repository.QrRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class QrRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : QrRepository {

    private val fixedQrId = "default_qr"

    override suspend fun getQrById(id: String): QrDomain {
        return suspendCoroutine { continuation ->
            firestore.collection("qrs").document(id).get()
                .addOnSuccessListener { doc ->
                    if (doc != null && doc.exists()) {
                        val dto = doc.toObject(QrDto::class.java)
                        continuation.resume(dto?.toDomain() ?: QrDomain(id, "https://example.com"))
                    } else {
                        continuation.resume(QrDomain(id, "https://example.com"))
                    }
                }
                .addOnFailureListener { continuation.resumeWithException(it) }
        }
    }

    override suspend fun updateRedirectUrl(id: String, redirectUrl: String): QrDomain {
        val qr = QrDto(id = id, redirectUrl = redirectUrl)
        firestore.collection("qrs").document(id).set(qr).await()
        return qr.toDomain()
    }
}