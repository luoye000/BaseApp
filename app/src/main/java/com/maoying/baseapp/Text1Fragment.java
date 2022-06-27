package com.maoying.baseapp;

import com.luoye.apptool.databinding.BaseDataActivityFragment;
import com.luoye.apptool.databinding.BaseDataFragment;
import com.maoying.baseapp.databinding.FragmentText1Binding;
import com.maoying.baseapp.viewModel.Text1Model;

public class Text1Fragment extends BaseDataFragment<FragmentText1Binding, Text1Model> {
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_text1;
    }

    @Override
    protected void initFragment() {
        binding.setMyData(viewModel);
    }
}
