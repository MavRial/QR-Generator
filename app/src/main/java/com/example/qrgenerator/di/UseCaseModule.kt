package com.example.qrgenerator.di

import com.example.qrgenerator.domain.repository.QrRepository
import com.example.qrgenerator.domain.usecase.GetQrByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule{

    @Provides
    fun provideGetQrByIdUseCase(repository: QrRepository): GetQrByIdUseCase{
        return GetQrByIdUseCase(repository)
    }
}