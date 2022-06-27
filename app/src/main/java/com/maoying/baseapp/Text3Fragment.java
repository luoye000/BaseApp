package com.maoying.baseapp;

import com.luoye.apptool.databinding.BaseDataAllFragment;
import com.maoying.baseapp.databinding.FragmentText3Binding;
import com.maoying.baseapp.viewModel.MainModel;
import com.maoying.baseapp.viewModel.Text3Model;

public class Text3Fragment extends BaseDataAllFragment<FragmentText3Binding, MainModel, Text3Model> {
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_text3;
    }

    @Override
    protected void initFragment() {
        binding.setActivityData(activityViewModel);
        binding.setMyData(viewModel);

    }
}
