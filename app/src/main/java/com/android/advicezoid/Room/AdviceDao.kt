package com.android.advicezoid.Room



import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.android.advicezoid.model.Slip
import com.android.advicezoid.repository.Slips
import androidx.room.OnConflictStrategy.IGNORE
import kotlinx.coroutines.flow.Flow

@Dao
interface AdviceDao {
    @Query("Select * FROM advices_table ORDER BY id ASC  ")  // selecting all inserted data in our table
     fun getAll(): Flow<Slips>

    @Insert(onConflict = IGNORE)// inserting data in our table
     fun insert(advice: Slip)

    @Delete
     fun delete(advice: Slip) // deleting certain data

    @Query("DELETE FROM advices_table") // deleting every single data in our table
     fun deleteAll()
}