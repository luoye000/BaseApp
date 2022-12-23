package com.luoye.apptool.lazy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.utils.ViewBindingUtil;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * user: 懒加载
 */
public abstract class BaseLazyViewFragment<T extends ViewBinding> extends LazyFragment {

    protected String TAG = "---BaseViewFragment";
    protected Context context;
    protected Activity activity;
    protected T binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ViewBindingUtil.create(getClass(), inflater, container);
        initFragment();
        return binding.getRoot();
    }

    protected abstract void initFragment();

}