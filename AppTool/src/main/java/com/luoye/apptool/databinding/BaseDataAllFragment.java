package com.luoye.apptool.databinding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.luoye.apptool.utils.TClassUtils;

public abstract class BaseDataAllFragment<B extends ViewDataBinding, A_activity extends ViewModel, M_my extends ViewModel> extends Fragment implements DefaultLifecycleObserver {

    protected String TAG = "---BaseFragment";
    protected Context context;
    protected Activity activity;
    protected B binding;
    protected M_my viewModel;
    protected A_activity activityViewModel;

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
        binding = DataBindingUtil.inflate(inflater, setLayoutId(), container, false);
        viewModel = new ViewModelProvider(this).get((Class<M_my>) TClassUtils.getTClass(getClass(), 2));
        activityViewModel = new ViewModelProvider(getActivity()).get((Class<A_activity>) TClassUtils.getTClass(getClass(), 1));
        binding.setLifecycleOwner(this);
        initFragment();
        return binding.getRoot();
    }


    protected abstract int setLayoutId();

    protected abstract void initFragment();

}

