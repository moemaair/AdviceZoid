package com.android.advicezoid.viewmodel

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.advicezoid.model.AdviceApi
import com.android.advicezoid.model.Advices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AdviceViewModel : ViewModel() {
    val TAG = "MainActivity"
    val mutableState = mutableStateOf(Advices())

    fun gettingData() {
        runBlocking {
            withContext(Dispatchers.IO) {
                launch {
                    runBlocking {
                        val users = AdviceApi.getInstance().getAdvice()
                        users.enqueue(object : Callback<Advices> {
                            override fun onResponse(
                                call: Call<Advices>,
                                response: Response<Advices>
                            ) {
                                var userData = response.body()
                                if (userData != null) {
                                    mutableState.value = userData
                                    Log.d(TAG, mutableState.value.slip?.advice.toString())
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

    // used to copy quote to clipboard
        fun Context.copyToClipboard(text: CharSequence) {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", text)
            clipboard.setPrimaryClip(clip)
            println(clipboard.setPrimaryClip(clip))
        }


    // used to share quote to other application
    fun Context.shareToOthers(quote: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, quote)
        startActivity(Intent.createChooser(intent, "Share via"))
    }












}