package com.example.qrgenerator.domain.usecase

import com.example.qrgenerator.domain.model.QrDomain
import com.example.qrgenerator.domain.repository.QrRepository

class GetQrByIdUseCase(
    private val repository: QrRepository
) {
    suspend operator fun invoke(id: String): QrDomain{
        return repository.getQrById(id)
    }
}