package com.android.advicezoid.di


import android.content.Context
import androidx.room.Room
import com.android.advicezoid.Room.AdviceDao
import com.android.advicezoid.Room.AdviceDb
import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.repository.AdviceRepository
import com.android.advicezoid.repository.AdviceRepositoryImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideBookDb(
        @ApplicationContext
        context : Context) = Room.databaseBuilder(
        context,
        AdviceDb::class.java,
        "table_name"
    ).build()


    @Provides
    @Singleton
    fun provideAdviceDao(
        adviceDb: AdviceDb
    ) = adviceDb.dao()

    @Provides
    @Singleton
    fun provideAdviceRepository(
        adviceDao: AdviceDao
    ): AdviceRepository = AdviceRepositoryImpl(
        adviceDao = adviceDao
    )

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): AdviceApi {
        return Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(AdviceApi::class.java)
    }

}