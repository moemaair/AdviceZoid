package com.android.advicezoid.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.model.Advices
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdviceViewModel: ViewModel() {
    val TAG = "MainActivity"

    val mutableState = mutableStateOf(Advices())

    fun gettingData(){
        runBlocking {
            withContext(Dispatchers.IO) {
                launch {
                    runBlocking {
                        val users = AdviceApi.getInstance().getAdvice()
                        users.enqueue(object : Callback<Advices> {
                            override fun onResponse(call: Call<Advices>, response: Response<Advices>) {
                                val userData = response.body()
                                if (userData != null) {
                                    mutableState.value = userData
                                    Log.d(TAG,mutableState.value.slip?.advice.toString())
                                }
                            }

                            override fun onFailure(call: Call<Advices>, t: Throwable) {
                                Log.e(TAG, t.message.toString())
                            }

                        })
                    }
                }
            }
        }
    }
}