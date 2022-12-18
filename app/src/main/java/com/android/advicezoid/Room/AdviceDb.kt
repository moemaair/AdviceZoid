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

    companion object{  //obtain a reference to the Dao instance

        @Volatile
        private var INSTANCE: AdviceDao? = null

        fun getDaoInstance(context: Context): AdviceDao{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context).dao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context):
                AdviceDb = Room.databaseBuilder(
                context.applicationContext,
                AdviceDb::class.java,
                "advice_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}