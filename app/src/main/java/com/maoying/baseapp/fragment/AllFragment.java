package com.maoying.baseapp.fragment;

import com.luoye.apptool.databinding.BaseDataAllFragment;
import com.maoying.baseapp.R;
import com.maoying.baseapp.databinding.FragmentText3Binding;
import com.maoying.baseapp.viewModel.FragModel;
import com.maoying.baseapp.viewModel.MainModel;

public class AllFragment extends BaseDataAllFragment<FragmentText3Binding, MainModel, FragModel> {
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
