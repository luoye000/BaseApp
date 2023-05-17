package com.text.luoye.fragment;


import com.luoye.ktbase.binding.fragment.databinding.BaseDataFragment;
import com.text.luoye.databinding.FragmentText1Binding;
import com.text.luoye.viewModel.FragModel;

public class MyFragment extends BaseDataFragment<FragmentText1Binding, FragModel> {

    @Override
    protected void initFragment() {
        getBinding().setMyData(getViewModel());

    }
}
