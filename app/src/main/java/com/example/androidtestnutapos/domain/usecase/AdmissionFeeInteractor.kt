package com.example.androidtestnutapos.domain.usecase

import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.domain.repository.AdmissionFeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdmissionFeeInteractor @Inject constructor(private val admissionFeeRepository: AdmissionFeeRepository) : AdmissionFeeUseCase {
    override suspend fun insertAdmissionFee(admissionFee: AdmissionFee) {
    }

    override suspend fun updateAdmissionFee(admissionFee: AdmissionFee) {
    }

    override suspend fun deleteAdmissionFee(admissionFee: AdmissionFee) {
    }

    override fun getAllAdmissionFee(): Flow<List<AdmissionFee>> =
        admissionFeeRepository.getAllAdmissionFee()

    override fun getAdmissionFeeByDateRange(
        startDate: Long,
        endDate: Long
    ): Flow<List<AdmissionFee>> = admissionFeeRepository.getAdmissionFeeByDateRange(startDate, endDate)

    override fun getTotalByDate(date: Long): Flow<Int> =
        admissionFeeRepository.getTotalByDate(date)
}