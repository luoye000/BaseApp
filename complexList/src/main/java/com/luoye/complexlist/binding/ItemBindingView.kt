package com.luoye.complexlist.binding


import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.luoye.complexlist.bean.ComplexBean

open class ItemBindingView<T : ComplexBean>(var itemViewInterface: ItemViewInterface<T, *>) {

    interface ItemViewInterface<T : ComplexBean, V : ViewBinding> {
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V
        fun onBindViewHolder(bean: T, binding: ViewBinding, position: Int
        )
    }
}