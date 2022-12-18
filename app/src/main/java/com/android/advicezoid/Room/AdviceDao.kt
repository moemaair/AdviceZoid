package com.android.advicezoid.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.advicezoid.model.Advices

@Dao
interface AdviceDao {
    @Query("Select * FROM advices_table")
    suspend fun getAll():List<Advices>

    @Insert
    suspend fun insert():List<Advices>

    @Update
    suspend fun update():List<Advices>

    @Delete
    suspend fun delete():List<Advices>
}