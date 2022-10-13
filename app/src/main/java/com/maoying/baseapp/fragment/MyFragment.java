package com.maoying.baseapp.fragment;


import com.luoye.apptool.databinding.BaseDataFragment;
import com.maoying.baseapp.R;
import com.maoying.baseapp.databinding.FragmentText1Binding;
import com.maoying.baseapp.viewModel.FragModel;

public class MyFragment extends BaseDataFragment<FragmentText1Binding, FragModel> {
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_text1;
    }

    @Override
    protected void initFragment() {
        binding.setMyData(viewModel);
    }
}
