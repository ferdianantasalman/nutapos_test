package com.example.androidtestnutapos.domain.repository

import com.example.androidtestnutapos.domain.model.AdmissionFee
import kotlinx.coroutines.flow.Flow

interface AdmissionFeeRepository {

    suspend fun insertAdmissionFee(admissionFee: AdmissionFee)

    suspend fun updateAdmissionFee(admissionFee: AdmissionFee)

    suspend fun deleteAdmissionFee(admissionFee: AdmissionFee)

    fun getAllAdmissionFee(): Flow<List<AdmissionFee>>

    fun getAdmissionFeeByDateRange(startDate: Long, endDate: Long): Flow<List<AdmissionFee>>

    fun getTotalByDate(date: Long): Flow<Int>
}