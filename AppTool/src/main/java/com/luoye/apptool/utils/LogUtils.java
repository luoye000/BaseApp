package com.luoye.apptool.utils;

import android.util.Log;

/**
 * Created by: luoye
 * Time: 2022/8/17
 * user: 日志工具
 */
public class LogUtils {

    private static boolean isDebug = true;


    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    public static void i(String tag, String msg) {
        if (isDebug) Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug) Log.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug) Log.e(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug) Log.w(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug) Log.d(tag, msg);
    }
}
