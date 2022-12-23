package com.maoying.luoye;


import com.luoye.apptool.databinding.activity.BaseDataAppCompatActivity;
import com.luoye.apptool.utils.BaseUtils;
import com.maoying.luoye.databinding.ActivityComplexBinding;
import com.maoying.luoye.fragment.ComplexBindingFragment;
import com.maoying.luoye.fragment.ComplexFragment;
import com.maoying.luoye.viewModel.MainModel;

public class ComplexActivity extends BaseDataAppCompatActivity<ActivityComplexBinding, MainModel> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_complex;
    }

    ComplexBindingFragment complexbindingFragment;
    ComplexFragment complexFragment;

    @Override
    protected void initActivity() {

        complexbindingFragment = new ComplexBindingFragment();
        complexFragment = new ComplexFragment();

        binding.complex.setOnClickListener(view -> {
            viewModel.getText().postValue("这是多布局list样式演示 使用view");
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), complexFragment).commit();
        });

        binding.complexBinding.setOnClickListener(view -> {
            viewModel.getText().postValue("这是多布局list样式演示 使用viewBinging");
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), complexbindingFragment).commit();
        });


    }

}