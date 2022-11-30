package com.luoye.ktbase.utils

import android.util.Log

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user: 日志工具
 *
 */
open class LogUtils {
    
    companion object{
        private var isDebug = true

        fun setDebug(debug: Boolean) { isDebug = debug }

        fun i(tag: String, msg: String) { if (isDebug) Log.i(tag, msg) }

        fun v(tag: String, msg: String) { if (isDebug) Log.v(tag, msg) }

        fun e(tag: String, msg: String) { if (isDebug) Log.e(tag, msg) }

        fun w(tag: String, msg: String) { if (isDebug) Log.w(tag, msg) }

        fun d(tag: String, msg: String) { if (isDebug) Log.d(tag, msg) }

        fun i(msg: String) {
            if (isDebug) Log.i("---", msg)
        }

        fun v(msg: String) {
            if (isDebug) Log.v("---", msg)
        }

        fun e(msg: String) {
            if (isDebug) Log.e("---", msg)
        }

        fun w(msg: String) {
            if (isDebug) Log.w("---", msg)
        }

        fun d(msg: String) {
            if (isDebug) Log.d("---", msg)
        }
    }
}