package com.luoye.ktbase.binding.adapter

import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

/**
 *
 * Created by:
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewAdapter<T, V : ViewBinding>(var objectArrayList: MutableList<T> = mutableListOf(), owner: LifecycleOwner? = null) : BaseAdapter<V>( owner) {


    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) {
        initAdapter(holder, objectArrayList[position], position)
    }

    protected abstract fun initAdapter(holder: ViewHolder<V>, t: T, position: Int)


    override fun getItemCount(): Int {
        return objectArrayList.size
    }

    //移除指定的item 以及 他的数据 带动画
    open fun removeItem(position: Int) {
        notifyItemRemoved(position)
        if (objectArrayList.size > position) {
            notifyItemRangeChanged(position, objectArrayList.size - position)
            objectArrayList.removeAt(position)
        }
    }

    //指定位置添加item 以及 他的数据 带动画
    open fun addItem(position: Int, t: T) {
        objectArrayList.add(t)
        notifyItemInserted(position)
    }

    //尾部添加item 以及 他的数据 带动画
    open fun addItem(t: T) {
        objectArrayList.add(t)
        notifyItemInserted(objectArrayList.size)
    }


}