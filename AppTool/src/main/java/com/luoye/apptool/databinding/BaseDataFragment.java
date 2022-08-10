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


/*
 * TIME：2022/3/21
 * user：绑定自己ViewModel
 */
public abstract class BaseDataFragment<B extends ViewDataBinding, V extends ViewModel> extends Fragment {

    protected String TAG = "---BaseFragment";
    protected Context context;
    protected Activity activity;
    protected B binding;
    protected V viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, setLayoutId(), container, false);
        viewModel = new ViewModelProvider(this).get((Class<V>) TClassUtils.getViewModelClass(getClass()));
        binding.setLifecycleOwner(this);
        initFragment();
        return binding.getRoot();
    }

    protected abstract int setLayoutId();

    protected abstract void initFragment();

}
