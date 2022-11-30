package com.luoye.ktbase.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user:
 *
 */
open class BaseUtils {

    companion object {

        fun startActivity(context: Context, clz: Class<*>) {
            context.startActivity(Intent(context, clz))
        }

        fun startActivity(context: Context, clz: Class<*>, bundle: Bundle) {
            val intent = Intent()
            intent.setClass(context, clz)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}