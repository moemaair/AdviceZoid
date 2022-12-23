package com.android.advicezoid.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.advicezoid.model.Slip

@Database(entities = [Slip::class], version = 1, exportSchema = false)
abstract class AdviceDb : RoomDatabase(){
    abstract fun dao(): AdviceDao
}