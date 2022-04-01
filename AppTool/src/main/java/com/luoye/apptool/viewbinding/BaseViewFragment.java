package com.luoye.apptool.viewbinding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.utils.ViewBindingUtil;

public abstract class BaseViewFragment<T extends ViewBinding> extends Fragment implements DefaultLifecycleObserver {

    protected String TAG = "---BaseViewFragment";
    protected Context context;
    protected Activity activity;
    protected T binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
        getLifecycle().addObserver(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ViewBindingUtil.create(getClass(), inflater, container);
        initFragment();
        return binding.getRoot();
    }

    protected abstract void initFragment();

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);
    }
}
