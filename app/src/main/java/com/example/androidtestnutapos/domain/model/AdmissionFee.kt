package com.example.androidtestnutapos.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdmissionFee(
    val id: Int? = null,

    val from: String?,

    val to: String?,

    val total: Int?,

    val description: String?,

    val type: String?,

    val image: String?,

    val date: Long?
) : Parcelable
