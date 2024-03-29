package com.luoye.complexlist.binding


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.luoye.complexlist.bean.ComplexBean


open class ComplexBindingAdapter<T : ComplexBean>(
    val itemBindingViewMap: MutableMap<Int, ItemBindingView<T>>,
    var objectList: MutableList<T> = mutableListOf()
    ) : RecyclerView.Adapter<ComplexBindingAdapter.ViewHolder>() {

    //获取类型
    override fun getItemViewType(position: Int): Int {
        return objectList[position].viewType
    }

    override fun getItemCount(): Int {
        return objectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = itemBindingViewMap[viewType]
            ?: throw NullPointerException("itemViewMap.get(viewType)==null")
        return ViewHolder(itemView.onCreateViewHolder(parent, viewType))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemBindingViewMap[objectList[position].viewType]?.onBindViewHolder(
            objectList[position],
            holder.binding,
            position
        )
    }

    class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

}