package com.luoye.complexlist.binding


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.luoye.complexlist.bean.AdapterBean


class ComplexBindingAdapter<T : AdapterBean>(
    var itemBindingViewMap: Map<Int, ItemBindingView<T>>,
    var objectList: List<T>
) : RecyclerView.Adapter<ComplexBindingAdapter.ViewHolder>() {

    //获取类型
    override fun getItemViewType(position: Int): Int {
        return objectList[position].viewType
    }

    override fun getItemCount(): Int {
        return objectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = itemBindingViewMap[viewType]?: throw NullPointerException("itemViewMap.get(viewType)==null")
        return ViewHolder(itemView.itemViewInterface.onCreateViewHolder(parent,viewType))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemBindingViewMap[objectList[position].viewType]?.itemViewInterface?.onBindViewHolder(objectList[position],holder,position)
    }

    class ViewHolder(var binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

}