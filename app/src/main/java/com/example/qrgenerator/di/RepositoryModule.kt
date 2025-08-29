package com.example.qrgenerator.di

import com.example.qrgenerator.data.repository.QrRepositoryImpl
import com.example.qrgenerator.domain.repository.QrRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideQrRepository(): QrRepository = QrRepositoryImpl()
}