package com.android.advicezoid.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.model.Advices
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AdviceViewModel( ) : ViewModel() {
    val TAG = "MainActivity"
    val data = mutableStateOf(Advices())

    //private val appDb : AppDatabase =
    fun gettingData(context: Context): Unit { // Model capturing calling API
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
                                Toast.makeText(context, "Check on your Internet connection...", Toast.LENGTH_SHORT).show()
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

