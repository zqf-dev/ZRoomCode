package com.zqf.zroomcode.utils

import android.util.Log
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.lang.reflect.Type

/**
 * Author: zqf
 * Date: 2022/05/17
 */
class HmConverter : ItHmConverter(message = "message", success = "OK") {
    companion object {
        private val gson = GsonBuilder().serializeNulls().create()
    }

    override fun <R> String.parseBody(succeed: Type): R? {
        return try {
//            val data = JSONObject(this).getString("data")
//            val vType = JSONTokener(data).nextValue()
//            if (vType is JSONObject) {
//                gson.fromJson(data, succeed)
//            } else {
//                val array = JSONObject(data).getString("channels")
//                gson.fromJson(array, succeed)
//            }
            val data = JSONObject(this).getString("data")
            gson.fromJson(JSONObject(data).getString("channels"), succeed)
        } catch (e: Exception) {
            Log.e("TAG", "异常解析-- ")
            gson.fromJson(this, succeed)
        }
    }
}