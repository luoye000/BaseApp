package com.luoye.ktbase.binding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.getViewBinding

/**
 *
 * Created by:
 * user:
 *
 */
abstract class BaseAdapter<V : ViewBinding>(owner: LifecycleOwner? = null): RecyclerView.Adapter<BaseAdapter.ViewHolder<V>>(), DefaultLifecycleObserver {


    init {
        owner?.lifecycle?.addObserver(this)
    }


    class ViewHolder<V : ViewBinding>(val binding: V) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        return ViewHolder(getViewBinding(LayoutInflater.from(parent.context), parent, 0))
    }

}
