package com.android.advicezoid.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AdviceApi {
    @GET("advice")
    fun getAdvice(): Call<Advices>

    companion object {
        var retrofitService: AdviceApi? = null
        fun getInstance(): AdviceApi {  // a function which is the initialization of Apiservice.kt to let Retrofit do their job initialize service from trinya.heruko.com .
            if(retrofitService == null){
                val client = OkHttpClient
                    .Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.adviceslip.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(AdviceApi::class.java)
            }
            return retrofitService!!
        }
    }
}