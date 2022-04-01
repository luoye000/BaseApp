package com.luoye.apptool.viewbinding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.OnBaseListener;
import com.luoye.apptool.utils.ViewBindingUtil;


public abstract class BaseViewDialog<T, E extends ViewBinding> extends Dialog implements DefaultLifecycleObserver {

    protected E binding;
    protected Context context;
    protected Activity activity;
    protected OnBaseListener<T> onBaseListener;
    private LifecycleOwner owner;
    protected String TAG = "---BaseViewDialog";


    public BaseViewDialog(@NonNull Context context, int themeResId, LifecycleOwner owner, OnBaseListener<T> onBaseListener) {
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
        binding = ViewBindingUtil.create(getClass(), LayoutInflater.from(context));
        setContentView(binding.getRoot());
        setCanceledOnTouchOutside(true);//边缘点击消失
        if (owner != null) {
            owner.getLifecycle().addObserver(this);
        } else {
            try {
                ((ComponentActivity)context).getLifecycle().addObserver(this);
            } catch (Exception e) {
                Log.i(TAG, "BaseViewDialog: LifecycleOwner 失败 context 非来自 ComponentActivity 以及他的子类");
            }
        }
        initDialog();
    }

    protected abstract void initDialog();

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        getWindow().setAttributes(lp);
    }

}
