package com.example.androidtestnutapos.di

import android.content.Context
import androidx.room.Room
import com.example.androidtestnutapos.data.source.local.room.AdmissionFeeDao
import com.example.androidtestnutapos.data.source.local.room.AdmissionFeeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AdmissionFeeDatabase = Room.databaseBuilder(
        context,
        AdmissionFeeDatabase::class.java, "Admission.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAdmissionFeeDao(database: AdmissionFeeDatabase): AdmissionFeeDao = database.admissionFeeDao()
}