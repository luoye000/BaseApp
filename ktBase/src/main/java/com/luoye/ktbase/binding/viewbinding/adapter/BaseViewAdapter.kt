package com.luoye.ktbase.binding.viewbinding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.ViewBindingUtil

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewAdapter<T, V : ViewBinding>(
    protected var context: Context,
    protected var objectArrayList: MutableList<T>
) :
    RecyclerView.Adapter<BaseViewAdapter.ViewHolder<V>>(), DefaultLifecycleObserver {


    constructor(context: Context, objectArrayList: MutableList<T>, owner: LifecycleOwner) : this(
        context,
        objectArrayList
    ) {
        owner.lifecycle.addObserver(this)
    }


    class ViewHolder<V :ViewBinding>(val binding: V) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        return ViewHolder(ViewBindingUtil.create(javaClass, LayoutInflater.from(context), parent))
    }

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