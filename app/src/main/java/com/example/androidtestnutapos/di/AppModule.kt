package com.example.androidtestnutapos.di

import com.example.androidtestnutapos.domain.usecase.AdmissionFeeInteractor
import com.example.androidtestnutapos.domain.usecase.AdmissionFeeUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(admissionFeeInteractor: AdmissionFeeInteractor): AdmissionFeeUseCase
}