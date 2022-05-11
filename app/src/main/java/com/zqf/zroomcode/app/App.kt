package com.zqf.zroomcode.app

import android.app.Application

/**
 * Author: zqf
 * Date: 2022/05/11
 */
class App : Application() {
    companion object {
        lateinit var app: App

        init {
            fun getApp(): App {
                return app
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}