package com.luoye.ktbase.utils

import android.content.Context

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user: dp to px
 *
 */
open class DpUtils {

    companion object {

        fun dip2px(context: Context, dpValue: Float): Float {
            return dpValue * context.resources.displayMetrics.density + 0.5f
        }

        fun px2dip(context: Context, pxValue: Float): Float {
            return pxValue / context.resources.displayMetrics.density + 0.5f
        }

        fun sp2px(context: Context, spValue: Float): Float {
            return spValue * context.resources.displayMetrics.scaledDensity + 0.5f
        }
    }

}