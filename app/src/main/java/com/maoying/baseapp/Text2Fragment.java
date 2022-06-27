package com.maoying.baseapp;

import com.luoye.apptool.databinding.BaseDataActivityFragment;
import com.maoying.baseapp.databinding.FragmentText2Binding;
import com.maoying.baseapp.viewModel.MainModel;

public class Text2Fragment extends BaseDataActivityFragment<FragmentText2Binding, MainModel> {
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_text2;
    }

    @Override
    protected void initFragment() {

        binding.setActivityData(activityViewModel);

    }
}