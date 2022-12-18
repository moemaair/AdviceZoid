package com.android.advicezoid.Room

import android.app.Application
import android.content.Context

class AdviceApplication: Application(){
    init { app = this }
    companion object {
        private lateinit var app: AdviceApplication
        fun getAppContext(): Context =
            app.applicationContext
    }}