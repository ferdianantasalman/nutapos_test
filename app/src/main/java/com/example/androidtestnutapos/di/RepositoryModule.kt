package com.example.androidtestnutapos.di

import com.example.androidtestnutapos.data.repository.AdmissionFeeRepositoryImpl
import com.example.androidtestnutapos.domain.repository.AdmissionFeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(admissionFeeRepositoryImpl: AdmissionFeeRepositoryImpl): AdmissionFeeRepository
}