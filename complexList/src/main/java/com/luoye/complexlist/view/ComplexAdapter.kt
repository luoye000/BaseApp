package com.luoye.complexlist.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luoye.complexlist.bean.ComplexBean

/**
 *
 * Created by: luoye
 * Time: 2022/10/13
 * user:
 *
 */
open class ComplexAdapter<T : ComplexBean>() : RecyclerView.Adapter<ComplexAdapter.ViewHolder>() {
    var itemViewMap: Map<Int, ItemView<T>> = mapOf();
    var objectList: List<T> = mutableListOf()

    constructor(itemViewMap: Map<Int, ItemView<T>>, objectList: List<T>) : this() {
        this.itemViewMap = itemViewMap
        this.objectList = objectList
    }

    //获取类型
    override fun getItemViewType(position: Int): Int {
        return objectList[position].viewType
    }

    override fun getItemCount(): Int {
        return objectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            itemViewMap[viewType] ?: throw NullPointerException("itemViewMap.get(viewType)==null")
        return ViewHolder(itemView.itemViewInterface.onCreateViewHolder(parent, viewType))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemViewMap[objectList[position].viewType]?.itemViewInterface?.onBindViewHolder(
            objectList[position],
            holder,
            position
        )
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}