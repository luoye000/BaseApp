package com.luoye.ktbase.utils

import androidx.recyclerview.widget.RecyclerView

/**
 *
 * Created by:
 * user:
 *
 */

/**
 * 设置 layoutManager 水平布局
 */
fun RecyclerView.setLM_llmH(){
    this.layoutManager =RecyclerViewUtils.llmH(context)
}

/**
 * 设置 layoutManager 水平布局
 */
fun RecyclerView.setLM_llmV(){
    this.layoutManager =RecyclerViewUtils.llmV(context)
}

/**
 * 设置 layoutManager 瀑布布局
 */
fun RecyclerView.setLM_sglmH(spanCount: Int){
    this.layoutManager =RecyclerViewUtils.sglmH(spanCount)
}

/**
 * 设置 layoutManager 瀑布布局
 */
fun RecyclerView.setLM_sglmV(spanCount: Int){
    this.layoutManager =RecyclerViewUtils.sglmV(spanCount)
}

/**
 * 设置 layoutManager 网格布局
 */
fun RecyclerView.setLM_glm(spanCount: Int){
    this.layoutManager =RecyclerViewUtils.getGridLayoutManager(context,spanCount)
}