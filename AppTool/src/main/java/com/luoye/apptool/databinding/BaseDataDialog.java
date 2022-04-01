package com.luoye.apptool.databinding;

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

import com.luoye.apptool.utils.DataBindingUtils;

/*
 * TIME：2022/3/28
 * user：
 */
public abstract class BaseDataDialog<B extends ViewDataBinding, V extends ViewModel> extends Dialog implements DefaultLifecycleObserver {

    protected static String TAG = "---" + BaseDataDialog.class.getName();
    protected V viewModel;
    protected B binding;
    protected Context context;

    public BaseDataDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = getContext();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), setLayoutId(), null, false);
        viewModel = new ViewModelProvider((ComponentActivity) context).get((Class<V>) DataBindingUtils.getViewModelClass(getClass()));
        setContentView(binding.getRoot());
        try {
            ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
        }catch (Exception e){
            Log.i(TAG, "BaseDataDialog: LifecycleOwner 失败 context 非来自 ComponentActivity 以及他的子类");
        }

        setCanceledOnTouchOutside(true);
        initDialog();
    }

    protected abstract int setLayoutId();
    protected abstract void initDialog();
}
