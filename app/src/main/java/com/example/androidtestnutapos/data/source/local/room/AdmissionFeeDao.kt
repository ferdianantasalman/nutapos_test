package com.example.androidtestnutapos.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidtestnutapos.data.source.local.entities.AdmissionFeeEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface AdmissionFeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAdmissionFee(admissionFee: AdmissionFeeEntity)

    @Update
    suspend fun updateAdmissionFee(admissionFee: AdmissionFeeEntity)

    @Delete
    suspend fun deleteAdmissionFee(admissionFee: AdmissionFeeEntity)

    @Query("SELECT * from admission_fee ORDER BY id ASC")
    fun getAllAdmissionFee(): Flow<List<AdmissionFeeEntity>>

    @Query("SELECT * FROM admission_fee WHERE date BETWEEN :startDate AND :endDate")
    fun getAdmissionFeeByDateRange(startDate: Long, endDate: Long): Flow<List<AdmissionFeeEntity>>

    @Query("SELECT SUM(total) FROM admission_fee WHERE date = :date")
    fun getTotalByDate(date: Long): Flow<Int>
}