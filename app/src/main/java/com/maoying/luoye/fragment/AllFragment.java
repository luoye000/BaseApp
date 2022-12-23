package com.maoying.luoye.fragment;

import com.luoye.apptool.databinding.BaseDataAllFragment;
import com.maoying.luoye.R;
import com.maoying.luoye.databinding.FragmentText3Binding;
import com.maoying.luoye.viewModel.FragModel;
import com.maoying.luoye.viewModel.MainModel;

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
