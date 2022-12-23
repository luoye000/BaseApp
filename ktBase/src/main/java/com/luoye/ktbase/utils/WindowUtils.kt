package com.luoye.ktbase.utils

import android.app.Activity
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorInt

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user: 状态栏工具 推荐使用第三方的
 *
 */
open class WindowUtils {

    companion object {

        /*状态栏颜色*/
        fun winTextColorWhite(context: Activity, @ColorInt color: Int) {
            context.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            context.window.statusBarColor = color
        }

        /*状态栏颜色*/
        fun winTextColorBlack(activity: Activity, @ColorInt color: Int) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            activity.window.statusBarColor = color
        }

        /*全屏*/
        fun winXY(activity: Activity) {
            val params = activity.window.attributes
            params.systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN
            activity.window.attributes = params
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        /**
         * 主题哀悼色
         */
        fun winSadColor(activity: Activity) {
            satColor(activity.window.decorView, 0f)
        }

        /**
         * view 添加灰度滤镜
         * @param view
         * @param sat 0~1
         */
        fun satColor(view: View, sat: Float) {
            val paint = Paint()
            val cm = ColorMatrix()
            cm.setSaturation(0f)
            paint.colorFilter = ColorMatrixColorFilter(cm)
            view.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
        }
    }
}