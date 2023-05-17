package com.text.luoye;


import com.luoye.ktbase.binding.activity.databinding.BaseDataAppCompatActivity;
import com.luoye.ktbase.binding.fragment.ShowHideExtKt;
import com.text.luoye.databinding.ActivityBindingTextBinding;
import com.text.luoye.fragment.ActivityFragment;
import com.text.luoye.fragment.AllFragment;
import com.text.luoye.fragment.MyFragment;
import com.text.luoye.viewModel.MainModel;

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
    protected void initActivity() {

        getBinding().setMainViewModel(getViewModel());


        myFragment = new MyFragment();
        activityFragment = new ActivityFragment();
        allFragment = new AllFragment();


        ShowHideExtKt.loadFragments(this,getBinding().frameLayout.getId(),0,myFragment,activityFragment,allFragment);

        //Fragment 使用自己的viewModel
        getBinding().my.setOnClickListener(view -> {
            getViewModel().getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            ShowHideExtKt.showHideFragment(this,myFragment);
        });

        //Fragment 使用activity的viewModel
        getBinding().activity.setOnClickListener(view -> {
            getViewModel().getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            ShowHideExtKt.showHideFragment(this,activityFragment);
        });

        //Fragment 使用activity的+自己的viewModel
        getBinding().all.setOnClickListener(view -> {
            getViewModel().getText().postValue("我是activity的viewModel 时间：" + System.currentTimeMillis());
            ShowHideExtKt.showHideFragment(this,allFragment);
        });



    }

}
