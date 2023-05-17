package com.luoye.ktbase.utils

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: 防止重复点击
 *
 */
open class ClickUtils {

    companion object {

        private var starTime: Long = 0

        /**
         * 间隔触发判断
         * @param interval 间隔时间
         * @return 是否可以触发
         */
        fun isOnClick(interval: Long): Boolean {
            val nowTime = System.currentTimeMillis()
            if (nowTime - starTime > interval) {
                starTime = nowTime
                return true  //触发点击
            } else {
                return false //本次禁止
            }
        }


        private var map: MutableMap<String, Long> = mutableMapOf()


        /**
         * 带有标签的 间隔触发判断
         * @param tag 标签
         * @param interval 间隔时间
         * @return 是否可以触发
         */
        fun isOnClick(tag: String, interval: Long): Boolean {
            val nowTime = System.currentTimeMillis()
            map[tag]?.let {
                if (nowTime - it > interval) {
                    map[tag] = nowTime
                    return true  //触发点击
                } else {
                    return false //本次禁止
                }
            } ?: let {
                map.put(tag, nowTime)
                return true //触发点击
            }
        }

        /**
         * 清除 带标签的间隔触发的缓存
         */
        fun clear() {
            map.clear()
        }

    }

}