package com.maoying.baseapp;


import com.maoying.baseapp.databinding.ActivityMainBinding;
import com.maoying.baseapp.viewModel.MainModel;
import com.luoye.apptool.databinding.BaseDataActicity;
import com.luoye.apptool.utils.BaseUtils;

public class MainActivity extends BaseDataActicity<ActivityMainBinding, MainModel> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initActivity() {

        binding.setMainViewModel(viewModel);


        Text1Fragment text1Fragment = new Text1Fragment();
        Text2Fragment text2Fragment = new Text2Fragment();
        Text3Fragment text3Fragment = new Text3Fragment();

        binding.my.setOnClickListener(view -> {
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), text1Fragment).commit();
        });

        binding.activity.setOnClickListener(view -> {
            viewModel.getText().postValue(viewModel.getText().getValue() + "?");
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), text2Fragment).commit();
        });

        binding.all.setOnClickListener(view -> {
            viewModel.getText().postValue(viewModel.getText().getValue() + "?");
            BaseUtils.switchFragment(this, binding.frameLayout.getId(), text3Fragment).commit();
        });

    }

}