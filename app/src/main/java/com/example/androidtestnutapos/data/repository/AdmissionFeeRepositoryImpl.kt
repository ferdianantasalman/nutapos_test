package com.example.androidtestnutapos.data.repository

import com.example.androidtestnutapos.data.source.local.LocalDataSource
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.domain.repository.AdmissionFeeRepository
import com.example.androidtestnutapos.utils.AppExecutors
import com.example.androidtestnutapos.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AdmissionFeeRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : AdmissionFeeRepository{

    override suspend fun insertAdmissionFee(admissionFee: AdmissionFee) {
        val admissionFeeEntity = DataMapper.mapAdmissionFeeDomainToEntity(admissionFee)
        localDataSource.insertAdmissionFee(admissionFeeEntity)
    }

    override suspend fun updateAdmissionFee(admissionFee: AdmissionFee) {
        val admissionFeeEntity = DataMapper.mapAdmissionFeeDomainToEntity(admissionFee)
        localDataSource.updateAdmissionFee(admissionFeeEntity)
    }

    override suspend fun deleteAdmissionFee(admissionFee: AdmissionFee) {
        val admissionFeeEntity = DataMapper.mapAdmissionFeeDomainToEntity(admissionFee)
        localDataSource.deleteAdmissionFee(admissionFeeEntity)
    }

    override fun getAllAdmissionFee(): Flow<List<AdmissionFee>> {
        return localDataSource.getAllAdmissionFee().map {
            DataMapper.mapAdmissionFeeEntitiesToDomain(it)
        }
    }

    override fun getAdmissionFeeByDateRange(
        startDate: Long,
        endDate: Long
    ): Flow<List<AdmissionFee>> {
        return localDataSource.getAdmissionFeeByDateRange(startDate, endDate).map {
            DataMapper.mapAdmissionFeeEntitiesToDomain(it)
        }
    }

    override fun getTotalByDate(date: Long): Flow<Int> {
        return localDataSource.getTotalByDate(date)
    }
}