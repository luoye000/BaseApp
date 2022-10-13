package com.maoying.baseapp;


import com.luoye.apptool.databinding.activity.BaseDataAppCompatActivity;
import com.maoying.baseapp.fragment.ActivityFragment;
import com.maoying.baseapp.databinding.ActivityMainBinding;
import com.maoying.baseapp.fragment.AllFragment;
import com.maoying.baseapp.fragment.ComplexBindingFragment;
import com.maoying.baseapp.fragment.ComplexFragment;
import com.maoying.baseapp.fragment.MyFragment;
import com.maoying.baseapp.viewModel.MainModel;
import com.luoye.apptool.utils.BaseUtils;

public class MainActivity extends BaseDataAppCompatActivity<ActivityMainBinding, MainModel> {

    MyFragment myFragment;
    ActivityFragment activityFragment;
    AllFragment allFragment;
    ComplexBindingFragment complexbindingFragment;
    ComplexFragment complexFragment;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initActivity() {

        binding.setMainViewModel(viewModel);


        myFragment = new MyFragment();
        activityFragment = new ActivityFragment();
        allFragment = new AllFragment();
        complexbindingFragment = new ComplexBindingFragment();
        complexFragment = new ComplexFragment();

        BaseUtils.switchFragment(this, binding.frameLayout.getId(), myFragment).commit();

        //Fragment 使用自己的viewModel
        binding.my.setOnClickListener(view -> {
            viewModel.getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), myFragment).commit();
        });

        //Fragment 使用activity的viewModel
        binding.activity.setOnClickListener(view -> {
            viewModel.getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), activityFragment).commit();
        });

        //Fragment 使用activity的+自己的viewModel
        binding.all.setOnClickListener(view -> {
            viewModel.getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), allFragment).commit();
        });


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