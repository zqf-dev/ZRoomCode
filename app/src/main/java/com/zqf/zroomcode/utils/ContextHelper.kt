package com.zqf.zroomcode.utils

import android.app.Application

/**
 * Author: zqf
 * Date: 2022/05/26
 */
object ContextHelper {

    fun getApp(): Application? {
        var app: Application?
        try {
            app = Class.forName("android.app.AppGlobals").getMethod("getInitialApplication")
                .invoke(null) as Application
        } catch (e: Exception) {
            app = Class.forName("android.app.ActivityThread").getMethod("currentApplication")
                .invoke(null) as Application
        }
        return app
    }
}