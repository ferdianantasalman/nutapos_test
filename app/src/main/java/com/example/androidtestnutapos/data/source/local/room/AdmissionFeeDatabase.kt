package com.example.androidtestnutapos.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtestnutapos.data.source.local.entities.AdmissionFeeEntity


@Database(entities = [AdmissionFeeEntity::class], version = 1, exportSchema = false)
abstract class AdmissionFeeDatabase : RoomDatabase() {
    abstract fun admissionFeeDao(): AdmissionFeeDao
}