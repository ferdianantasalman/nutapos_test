package com.example.androidtestnutapos.data.source.local

import com.example.androidtestnutapos.data.source.local.entities.AdmissionFeeEntity
import com.example.androidtestnutapos.data.source.local.room.AdmissionFeeDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val admissionFeeDao: AdmissionFeeDao){

    suspend fun insertAdmissionFee(admissionFee: AdmissionFeeEntity) = admissionFeeDao.insertAdmissionFee(admissionFee)

    suspend fun updateAdmissionFee(admissionFee: AdmissionFeeEntity) = admissionFeeDao.updateAdmissionFee(admissionFee)

    suspend fun deleteAdmissionFee(admissionFee: AdmissionFeeEntity) = admissionFeeDao.deleteAdmissionFee(admissionFee)

    fun getAllAdmissionFee(): Flow<List<AdmissionFeeEntity>> = admissionFeeDao.getAllAdmissionFee()

    fun getAdmissionFeeByDateRange(startDate: Long, endDate: Long): Flow<List<AdmissionFeeEntity>> = admissionFeeDao.getAdmissionFeeByDateRange(startDate,endDate)

    fun getTotalByDate(date: Long): Flow<Int> = admissionFeeDao.getTotalByDate(date)
}