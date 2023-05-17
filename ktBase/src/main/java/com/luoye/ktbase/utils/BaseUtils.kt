package com.luoye.ktbase.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction


inline fun Any.dip2px(context: Context, dpValue: Float): Float {
    return dpValue * context.resources.displayMetrics.density + 0.5f
}

inline fun Any.px2dip(context: Context, pxValue: Float): Float {
    return pxValue / context.resources.displayMetrics.density + 0.5f
}

inline fun Any.sp2px(context: Context, spValue: Float): Float {
    return spValue * context.resources.displayMetrics.scaledDensity + 0.5f
}


inline fun Context.dip2px(dpValue: Float): Float {
    return dpValue * resources.displayMetrics.density + 0.5f
}

inline fun Context.px2dip(pxValue: Float): Float {
    return pxValue / resources.displayMetrics.density + 0.5f
}

inline fun Context.sp2px(spValue: Float): Float {
    return spValue * resources.displayMetrics.scaledDensity + 0.5f
}


/*状态栏颜色*/
inline fun Activity.winTextColorWhite(
    @ColorInt color: Int = Color.parseColor("#000000")
) {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    window.statusBarColor = color
}


/*状态栏颜色*/
inline fun Activity.winTextColorBlack(@ColorInt color: Int = Color.parseColor("#FFFFFF")) {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    window.statusBarColor = color
}


/*全屏*/
inline fun Activity.winXY() {
    val params = window.attributes
    params.systemUiVisibility =
        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN
    window.attributes = params
    window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
}

/**
 * 主题哀悼色
 */
inline fun Activity.winSadColor() {
    satViewColorMatrix(window.decorView, 0f)
}

/**
 * view 添加灰度滤镜
 * @param view
 * @param sat 0~1
 */
inline fun Any.satViewColorMatrix(view: View, sat: Float) {
    val paint = Paint()
    val cm = ColorMatrix()
    cm.setSaturation(sat)
    paint.colorFilter = ColorMatrixColorFilter(cm)
    view.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
}