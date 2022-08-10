package com.luoye.apptool.viewbinding.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.tool.ActivityTool;
import com.luoye.apptool.utils.ViewBindingUtil;

public abstract class BaseViewFragmentActivity<T extends ViewBinding> extends AppCompatActivity {

    protected static String TAG = "---";
    protected Context context;
    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ViewBindingUtil.create(getClass(), LayoutInflater.from(this));
        setContentView(binding.getRoot());
        context = this;
        ActivityTool.getInstance().addActivity(this);
        initActivity();
    }

    protected abstract void initActivity();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityTool.getInstance().removeActivity(this);
    }
}
