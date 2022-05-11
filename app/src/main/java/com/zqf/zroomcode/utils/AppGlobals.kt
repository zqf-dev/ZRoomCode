package com.zqf.zroomcode.utils

import android.annotation.SuppressLint
import android.app.Application
import java.lang.reflect.Method


/**
 * Author: zqf
 * Date: 2022/05/11
 */
class AppGlobals {

    companion object {
        private var sApplication: Application? = null

        @SuppressLint("PrivateApi")
        fun getsApplication(): Application? {
            if (sApplication == null) {
                //去反射得到
                try {
                    val aClass = Class.forName("android.app.ActivityThread")
                    //获取里面的currentApplication
                    @SuppressLint("DiscouragedPrivateApi") val currentApplication: Method =
                        aClass.getDeclaredMethod("currentApplication")
                    sApplication = currentApplication.invoke(null, null as Any?) as Application?
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return sApplication
        }
    }
}