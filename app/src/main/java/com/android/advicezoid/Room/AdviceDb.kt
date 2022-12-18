package com.android.advicezoid.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.advicezoid.model.Slip

@Database(
    entities = [Slip::class],
    version = 1,
    exportSchema = false)

abstract class AdviceDb: RoomDatabase(){
    abstract val dao: AdviceDao

    companion object{
        private fun buildDatabase(context: Context):
                AdviceDb = Room.databaseBuilder(
                context.applicationContext,
                AdviceDb::class.java,
                "advice_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}