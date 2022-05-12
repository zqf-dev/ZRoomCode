package com.zqf.zroomcode.utils

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.Toast
import com.zqf.zroomcode.app.App


/**
 * Author: zqf
 * Date: 2022/05/12
 */
class ToastUtil {

    companion object {
        private var mToast: Toast? = null //全局唯一的Toast

        /**
         * 传入文字
         */
        @SuppressLint("ShowToast")
        fun show(text: String?) {
            if (mToast == null) {
                mToast = Toast.makeText(App.app.applicationContext, text, Toast.LENGTH_SHORT)
            } else {
                //如果当前Toast没有消失， 直接显示内容，不需要重新设置
                mToast!!.setText(text)
            }
            mToast!!.setGravity(Gravity.CENTER, 0, 0)
            mToast!!.show()
        }
    }
}