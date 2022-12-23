package com.android.advicezoid.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.model.Advices
import com.android.advicezoid.model.Slip
import com.android.advicezoid.repository.AdviceRepository
import com.android.advicezoid.repository.AdviceRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val repo: AdviceRepository
) : ViewModel() {
    val TAG = "MainActivity"
    val data = mutableStateOf(Advices())
    var isFavorite by mutableStateOf(false)

    var advice by mutableStateOf(Slip(0,""))
        private set

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

    val advices = repo.getAdvicesFromRoom()

    fun addAdvice(advice: Slip) = viewModelScope.launch (Dispatchers.IO){
        repo.addAdviceToRoom(advice)
    }




}

