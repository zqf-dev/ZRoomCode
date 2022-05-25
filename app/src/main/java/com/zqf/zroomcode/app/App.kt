package com.zqf.zroomcode.app

import android.app.Application
import com.drake.net.NetConfig
import com.drake.net.interceptor.LogRecordInterceptor

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
        initNet()
    }

    private fun initNet() {
        val baseUrl = "http://www.baidu.com"
        NetConfig.initialize(baseUrl, this) {
            addInterceptor(LogRecordInterceptor(true))
        }
    }
}