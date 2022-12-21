package com.android.advicezoid.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.model.Advices
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AdviceViewModel : ViewModel() {
    val TAG = "MainActivity"
    val data = mutableStateOf(Advices())
    //private val appDb : AppDatabase =
    fun gettingData() { // Model capturing calling API
        runBlocking {
            withContext(Dispatchers.IO) {
                launch {
                        val users = AdviceApi.getInstance().getAdvice()
                        users.enqueue(object : Callback<Advices> {
                            override fun onResponse(
                                call: Call<Advices>,
                                response: Response<Advices>
                            ) {
                                val userData = response.body()
                                if (userData != null) {
                                    data.value = userData
                                }
                            }

                            override fun onFailure(call: Call<Advices>, t: Throwable) {
                                TODO("Not yet implemented")
                            }


                        })
                    }
            }
        }
    }


//    @OptIn(DelicateCoroutinesApi::class)
//     fun writeData(data: MutableState<Advices>){
//        GlobalScope.launch(Dispatchers.IO) {
//            //appDb.adviceDao().insert(data)
//        }
//    }

}

