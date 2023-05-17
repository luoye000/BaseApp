package com.luoye.ktbase.utils

import android.content.Context
import android.widget.Toast

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: 更好的Toast
 *
 */
open class ToastUtils {

    companion object{

        private var myToast: Toast? = null

        private fun makeText(context: Context, msg: String, duration: Int) {
            myToast?.cancel()
            myToast = Toast.makeText(context, msg, duration)
            myToast?.show()
        }

        fun makeShort(context: Context, msg: String) {
            makeText(context, msg, Toast.LENGTH_SHORT)
        }

        fun makeLong(context: Context, msg: String) {
            makeText(context, msg, Toast.LENGTH_LONG)
        }
    }
}