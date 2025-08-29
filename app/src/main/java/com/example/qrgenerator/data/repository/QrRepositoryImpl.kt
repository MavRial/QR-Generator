package com.example.qrgenerator.data.repository

import com.example.qrgenerator.domain.model.QrDomain
import com.example.qrgenerator.domain.repository.QrRepository

class QrRepositoryImpl : QrRepository {
    override suspend fun getQrById(id: String): QrDomain {
        return QrDomain(id, "https://fakerrl.com/$id")
    }
}