package com.luoye.apptool.databinding;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.luoye.apptool.tool.ActivityTool;
import com.luoye.apptool.utils.DataBindingUtils;

/*
 * TIME：2022/3/18
 * user：
 */
public abstract class BaseDataActicity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {
    protected static String TAG = "---BaseDataActicity";
    protected Context context;
    protected B binding;
    protected V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定activity
        ActivityTool.getInstance().addActivity(this);
        context = this;
        binding = DataBindingUtil.setContentView(this, setLayoutId());
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(this).get((Class<V>) DataBindingUtils.getViewModelClass(getClass()));
        initActivity();
    }

    protected abstract int setLayoutId();

    protected abstract void initActivity();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑activity
        ActivityTool.getInstance().removeActivity(this);
    }
}
