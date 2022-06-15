package com.luoye.apptool.viewbinding;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.OnBaseListener;
import com.luoye.apptool.utils.ViewBindingUtil;

import java.util.ArrayList;

/**
 * created by: ls
 * TIME：2021/6/11
 * user：适配器基类
 */
public abstract class BaseViewAdapter<T, E extends ViewBinding> extends RecyclerView.Adapter<BaseViewAdapter<T, E>.ViewHolder> implements DefaultLifecycleObserver {
    protected String TAG = "---BaseViewAdapter";
    protected Context context;
    protected ArrayList<T> objectArrayList;
    protected OnBaseListener<T> onBaseListener;
    protected ViewHolder viewHolder;

    public BaseViewAdapter(Context context, LifecycleOwner owner, ArrayList<T> objectArrayList) {
        this.context = context;
        this.objectArrayList = objectArrayList;
        if (owner != null) owner.getLifecycle().addObserver(this);
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        if (owner != null) owner.getLifecycle().addObserver(this);
    }

    public void setObjectArrayList(ArrayList<T> objectArrayList) {
        this.objectArrayList = objectArrayList;
        notifyDataSetChanged();
    }

    public ArrayList<T> getObjectArrayList() {
        return objectArrayList;
    }

    public void setObjectArrayList(ArrayList<T> objectArrayList, Object... objects) {
        this.objectArrayList = objectArrayList;
        notifyDataSetChanged();
    }

    public void setOnBaseListener(OnBaseListener<T> onBaseListener) {
        this.onBaseListener = onBaseListener;
    }


    //移除指定的item 以及 他的数据 带动画
    protected void removeItem(int position) {
        notifyItemRemoved(position);
        if (objectArrayList != null && objectArrayList.size() > position) {
            notifyItemRangeChanged(position, objectArrayList.size() - position);
            objectArrayList.remove(position);
        }
    }

    //指定位置添加item 以及 他的数据 带动画
    protected void addItem(int position, T t) {
        if (objectArrayList != null) {
            objectArrayList.add(t);
            notifyItemInserted(position);
        }
    }

    //尾部添加item 以及 他的数据 带动画
    public void addItem(T t) {
        if (objectArrayList != null) {
            objectArrayList.add(t);
            notifyItemInserted(objectArrayList.size());
        }
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        public E binding;

        public ViewHolder(@NonNull E binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ViewBindingUtil.create(getClass(), LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        initAdapter(holder, objectArrayList.get(position), position);
    }

    protected abstract void initAdapter(ViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }


}
