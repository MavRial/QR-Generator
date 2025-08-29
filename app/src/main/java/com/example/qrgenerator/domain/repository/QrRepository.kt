package com.example.qrgenerator.domain.repository

import com.example.qrgenerator.domain.model.QrDomain

interface QrRepository {
    suspend fun getQrById(id: String): QrDomain
    suspend fun updateRedirectUrl(id: String, redirectUrl: String): QrDomain
}