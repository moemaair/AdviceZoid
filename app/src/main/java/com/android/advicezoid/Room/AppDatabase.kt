import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.advicezoid.Room.AdviceDao
import com.android.advicezoid.model.Slip

@Database(entities = [Slip::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun adviceDao(): AdviceDao
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val intance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = intance
                return intance
            }
        }
    }

}