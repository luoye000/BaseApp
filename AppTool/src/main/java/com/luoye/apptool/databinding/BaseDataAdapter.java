package com.luoye.apptool.databinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.luoye.apptool.OnBaseListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: luoye
 * Time: 2022/9/6
 * user:
 */
public abstract class BaseDataAdapter<T, E extends ViewDataBinding> extends RecyclerView.Adapter<BaseDataAdapter<T, E>.ViewHolder> implements DefaultLifecycleObserver {
    protected String TAG = "---BaseViewAdapter";
    protected Context context;
    protected List<T> objectArrayList;
    protected OnBaseListener<T> onBaseListener;
    protected ViewHolder viewHolder;
    
    public BaseDataAdapter(Context context, LifecycleOwner owner, List<T> objectArrayList) {
        this.context = context;
        this.objectArrayList = objectArrayList;
        if (owner != null) owner.getLifecycle().addObserver(this);
    }


    public void setLifecycleOwner(LifecycleOwner owner) {
        if (owner != null) owner.getLifecycle().addObserver(this);
    }

    public void setObjectArrayList(List<T> objectArrayList) {
        this.objectArrayList = objectArrayList;
        notifyDataSetChanged();
    }

    public List<T> getObjectArrayList() {
        return objectArrayList;
    }

    public void setObjectArrayList(List<T> objectArrayList, Object... objects) {
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

    protected abstract int setLayoutId();

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), setLayoutId(), parent, false));
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

