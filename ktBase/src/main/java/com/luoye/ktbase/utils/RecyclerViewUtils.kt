package com.luoye.ktbase.utils

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: 布局工具 推荐自己写
 *
 */
open class RecyclerViewUtils {

    companion object{

        //线性
        fun getLinearLayoutManager(context: Context, orientation: Int): LinearLayoutManager {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = orientation
            return linearLayoutManager
        }

        //流水
        fun getStaggeredGridLayoutManager(spanCount: Int, orientation: Int): StaggeredGridLayoutManager {
            return StaggeredGridLayoutManager(spanCount, orientation)
        }

        //网格
        fun getGridLayoutManager(context: Context, spanCount: Int): GridLayoutManager {
            return GridLayoutManager(context, spanCount)
        }
    }
}