package com.android.advicezoid.Room


import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.advicezoid.model.Advices
import com.android.advicezoid.model.Slip

@Dao
interface AdviceDao {
    @Query("Select * FROM advices_table")  // selecting all inserted data in our table
    suspend fun getAll():List<Advices>

    @Insert(onConflict = OnConflictStrategy.IGNORE) // inserting data in our table
    suspend fun insert(advice: MutableState<Advices>)

    @Delete
    suspend fun delete(advice: Advices) // deleting certain data

    @Query("DELETE FROM advices_table") // deleting every single data in our table
    suspend fun deleteAll()
}