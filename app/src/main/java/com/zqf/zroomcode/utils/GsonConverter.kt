package com.zqf.zroomcode.utils

import com.drake.net.convert.JSONConvert
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.lang.reflect.Type

/**
 * Author: zqf
 * Date: 2022/05/17
 */
class GsonConverter : JSONConvert(code = "errorCode", message = "errorMsg") {
    companion object {
        private val gson = GsonBuilder().serializeNulls().create()
    }

    override fun <R> String.parseBody(succeed: Type): R? {
        return try {
            gson.fromJson(JSONObject(this).getString("data"), succeed)
        } catch (e: Exception) {
            gson.fromJson(this, succeed)
        }
    }
}