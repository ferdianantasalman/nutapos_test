package com.example.androidtestnutapos.utils

import com.example.androidtestnutapos.data.source.local.entities.AdmissionFeeEntity
import com.example.androidtestnutapos.domain.model.AdmissionFee

object DataMapper {

    fun mapAdmissionFeeEntitiesToDomain(input: List<AdmissionFeeEntity>): List<AdmissionFee> {
        return input.map {
            AdmissionFee(
                it.id,
                it.from,
                it.to,
                it.total,
                it.description,
                it.type,
                it.image,
                it.date,
            )
        }
    }

    fun mapAdmissionFeeDomainToEntity(input: AdmissionFee): AdmissionFeeEntity {
        return AdmissionFeeEntity(
            input.id,
            input.from,
            input.to,
            input.total,
            input.description,
            input.type,
            input.image,
            input.date,
        )
    }
}