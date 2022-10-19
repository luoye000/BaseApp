package com.luoye.complexlist.view

import android.view.View
import android.view.ViewGroup
import com.luoye.complexlist.bean.ComplexBean

/**
 *
 * Created by: luoye
 * Time: 2022/10/13
 * user:
 *
 */
open class ItemView<T : ComplexBean>(var itemViewInterface: ItemViewInterface<T>) {

    interface ItemViewInterface<T> {
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : View
        fun onBindViewHolder(bean: T, holder: ComplexAdapter.ViewHolder, position: Int)
    }
}