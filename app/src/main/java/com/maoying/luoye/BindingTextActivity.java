package com.maoying.luoye;

import com.luoye.apptool.databinding.activity.BaseDataAppCompatActivity;
import com.luoye.apptool.utils.BaseUtils;
import com.maoying.luoye.databinding.ActivityBindingTextBinding;
import com.maoying.luoye.databinding.ActivityMainBinding;
import com.maoying.luoye.fragment.ActivityFragment;
import com.maoying.luoye.fragment.AllFragment;
import com.maoying.luoye.fragment.ComplexBindingFragment;
import com.maoying.luoye.fragment.ComplexFragment;
import com.maoying.luoye.fragment.MyFragment;
import com.maoying.luoye.viewModel.MainModel;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * user:
 */
public class BindingTextActivity extends BaseDataAppCompatActivity<ActivityBindingTextBinding, MainModel> {

    MyFragment myFragment;
    ActivityFragment activityFragment;
    AllFragment allFragment;


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



    }

}
