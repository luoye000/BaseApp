package com.text.luoye.fragment;

import com.luoye.ktbase.binding.fragment.databinding.BaseDataActivityFragment;
import com.text.luoye.R;
import com.text.luoye.databinding.FragmentText2Binding;
import com.text.luoye.viewModel.MainModel;

public class ActivityFragment extends BaseDataActivityFragment<FragmentText2Binding, MainModel> {

    @Override
    protected void initFragment() {

        getBinding().setActivityData(getViewModel());

    }
}