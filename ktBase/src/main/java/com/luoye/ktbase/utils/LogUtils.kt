package com.luoye.ktbase.utils
import android.util.Log
import com.luoye.ktbase.BuildConfig


/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: 日志工具
 *
 */
open class LogUtils {
    
    companion object{
        private var isDebug = BuildConfig.DEBUG

        private var TAG="---LogUtils"

        fun setTAG(tag:String){ TAG=tag }

        fun setDebug(debug: Boolean) { isDebug = debug }

        fun i(tag: String, msg: String) { if (isDebug) Log.i(tag, msg) }

        fun v(tag: String, msg: String) { if (isDebug) Log.v(tag, msg) }

        fun e(tag: String, msg: String) { if (isDebug) Log.e(tag, msg) }

        fun w(tag: String, msg: String) { if (isDebug) Log.w(tag, msg) }

        fun d(tag: String, msg: String) { if (isDebug) Log.d(tag, msg) }

        fun i(msg: String) {
            if (isDebug) Log.i(TAG, msg)
        }

        fun v(msg: String) {
            if (isDebug) Log.v(TAG, msg)
        }

        fun e(msg: String) {
            if (isDebug) Log.e(TAG, msg)
        }

        fun w(msg: String) {
            if (isDebug) Log.w(TAG, msg)
        }

        fun d(msg: String) {
            if (isDebug) Log.d(TAG, msg)
        }
    }
}