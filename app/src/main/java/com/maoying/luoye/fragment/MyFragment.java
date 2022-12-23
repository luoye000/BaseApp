package com.maoying.luoye.fragment;


import com.luoye.apptool.databinding.BaseDataFragment;
import com.maoying.luoye.R;
import com.maoying.luoye.databinding.FragmentText1Binding;
import com.maoying.luoye.viewModel.FragModel;

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
