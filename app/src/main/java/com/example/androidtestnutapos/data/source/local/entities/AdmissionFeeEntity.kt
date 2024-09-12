package com.example.androidtestnutapos.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "admission_fee")
data class AdmissionFeeEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "from")
    val from: String?,

    @ColumnInfo(name = "to")
    val to: String?,

    @ColumnInfo(name = "total")
    val total: Int?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "type")
    val type: String?,

    @ColumnInfo(name = "image")
    val image: String?,

    @ColumnInfo(name = "date")
    val date: Long?
)
