package com.example.qrgenerator.data.mapper

import com.example.qrgenerator.data.model.QrDto
import com.example.qrgenerator.domain.model.QrDomain

fun QrDto.toDomain(): QrDomain {
    return QrDomain(id = this.id, redirectUrl = this.redirectUrl)
}