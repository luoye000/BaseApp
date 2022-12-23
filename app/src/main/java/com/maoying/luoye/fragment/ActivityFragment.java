package com.maoying.luoye.fragment;

import com.luoye.apptool.databinding.BaseDataActivityFragment;
import com.maoying.luoye.R;
import com.maoying.luoye.databinding.FragmentText2Binding;
import com.maoying.luoye.viewModel.MainModel;

public class ActivityFragment extends BaseDataActivityFragment<FragmentText2Binding, MainModel> {
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_text2;
    }

    @Override
    protected void initFragment() {

        binding.setActivityData(activityViewModel);

    }
}