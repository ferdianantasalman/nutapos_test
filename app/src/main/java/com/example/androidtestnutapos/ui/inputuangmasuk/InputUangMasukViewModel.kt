package com.example.androidtestnutapos.ui.inputuangmasuk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.domain.usecase.AdmissionFeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InputUangMasukViewModel @Inject constructor(private val admissionFeeUseCase: AdmissionFeeUseCase) : ViewModel() {

    fun insertAdmissionFee(admissionFee: AdmissionFee) {
        viewModelScope.launch {
            admissionFeeUseCase.insertAdmissionFee(admissionFee)
        }
    }

    fun updateAdmissionFee(admissionFee: AdmissionFee) {
        viewModelScope.launch {
            admissionFeeUseCase.updateAdmissionFee(admissionFee)
        }
    }
}