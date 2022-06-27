package com.luoye.apptool.databinding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.luoye.apptool.OnBaseListener;
import com.luoye.apptool.utils.TClassUtils;

/*
 * TIME：2022/3/28
 * user：
 */
public abstract class BaseDataDialog<T, B extends ViewDataBinding, V extends ViewModel> extends Dialog implements DefaultLifecycleObserver {

    protected static String TAG = "---" + BaseDataDialog.class.getName();
    protected V viewModel;
    protected B binding;
    protected Context context;
    protected Activity activity;
    protected OnBaseListener<T> onBaseListener;
    private LifecycleOwner owner;


    public BaseDataDialog(@NonNull Context context, int themeResId, LifecycleOwner owner, OnBaseListener<T> onBaseListener) {
        super(context, themeResId);
        this.context = context;
        this.activity = (Activity) context;
        this.owner = owner;
        this.onBaseListener = onBaseListener;
    }

    public void setOwner(LifecycleOwner owner) {
        this.owner = owner;
        owner.getLifecycle().addObserver(this);
    }

    public void setOnBaseListener(OnBaseListener<T> onBaseListener) {
        this.onBaseListener = onBaseListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), setLayoutId(), null, false);
        viewModel = new ViewModelProvider((ComponentActivity) context).get((Class<V>) TClassUtils.getViewModelClass(getClass()));
        setContentView(binding.getRoot());
        if (owner != null) {
            owner.getLifecycle().addObserver(this);
        } else {
            try {
                ((ComponentActivity)context).getLifecycle().addObserver(this);
            } catch (Exception e) {
                Log.i(TAG, "BaseViewDialog: LifecycleOwner 失败 context 非来自 ComponentActivity 以及他的子类");
            }
        }
        setCanceledOnTouchOutside(true);
        initDialog();
    }

    protected abstract int setLayoutId();

    protected abstract void initDialog();
}
