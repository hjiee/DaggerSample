package com.hyden.daggersample.base

import android.app.Application

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        private val application = BaseApplication()
        fun getInstance(): BaseApplication {
            return application
        }

    }
}