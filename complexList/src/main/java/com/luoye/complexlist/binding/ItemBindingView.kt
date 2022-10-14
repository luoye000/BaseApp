package com.luoye.complexlist.binding


import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.luoye.complexlist.bean.AdapterBean

open class ItemBindingView<T : AdapterBean>(var itemViewInterface: ItemViewInterface<T>) {

    interface ItemViewInterface<T> {
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewBinding
        fun onBindViewHolder(bean: T, holder: ComplexBindingAdapter.ViewHolder, position: Int)
    }
}