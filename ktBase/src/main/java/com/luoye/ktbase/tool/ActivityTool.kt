package com.luoye.ktbase.tool

import android.app.Activity

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: activity 管理类
 *
 */
open class ActivityTool private constructor() {

    companion object {
        val instance: ActivityTool by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ActivityTool()
        }
    }

    val activities: MutableList<Activity> = mutableListOf()

    /*绑定Activity*/
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    /*解绑Activity*/
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

}