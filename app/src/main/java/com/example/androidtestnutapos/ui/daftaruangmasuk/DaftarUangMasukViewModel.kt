package com.example.androidtestnutapos.ui.daftaruangmasuk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.domain.usecase.AdmissionFeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DaftarUangMasukViewModel @Inject constructor(private val admissionFeeUseCase: AdmissionFeeUseCase) : ViewModel(){

    fun deleteAdmissionFee(admissionFee: AdmissionFee) {
        viewModelScope.launch {
            admissionFeeUseCase.deleteAdmissionFee(admissionFee)
        }
    }

    fun getAdmissionFeeByDateRange(startDate: Long, endDate: Long): LiveData<List<AdmissionFee>> =
        admissionFeeUseCase.getAdmissionFeeByDateRange(startDate, endDate).asLiveData()

    fun getAllAdmissionFee(): LiveData<List<AdmissionFee>> =
        admissionFeeUseCase.getAllAdmissionFee().asLiveData()

    fun getTotalByDate(date: Long): LiveData<Int> =
        admissionFeeUseCase.getTotalByDate(date).asLiveData()

}