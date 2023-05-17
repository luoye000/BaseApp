package com.text.luoye.fragment;

import com.luoye.ktbase.binding.fragment.databinding.BaseDataAllFragment;
import com.text.luoye.R;
import com.text.luoye.databinding.FragmentText3Binding;
import com.text.luoye.viewModel.FragModel;
import com.text.luoye.viewModel.MainModel;

public class AllFragment extends BaseDataAllFragment<FragmentText3Binding, MainModel, FragModel> {

    @Override
    protected void initFragment() {


        getBinding().setActivityData(getViewModelActivity());
        getBinding().setMyData(getViewModel());

    }
}
