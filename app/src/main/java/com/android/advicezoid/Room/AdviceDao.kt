package com.android.advicezoid.Room


import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.advicezoid.model.Advices
import com.android.advicezoid.model.Slip
import com.android.advicezoid.repository.Slips
import androidx.room.OnConflictStrategy.IGNORE

@Dao
interface AdviceDao {
    @Query("Select * FROM advices_table")  // selecting all inserted data in our table
     fun getAll():kotlinx.coroutines.flow.Flow<Slips>

    @Insert(onConflict = IGNORE)// inserting data in our table
     fun insert(advice: Slip)

    @Delete
     fun delete(advice: Slip) // deleting certain data

    @Query("DELETE FROM advices_table") // deleting every single data in our table
     fun deleteAll()
}