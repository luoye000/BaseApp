package com.maoying.luoye;


import com.luoye.apptool.lazy.ShowHideExt;
import com.luoye.apptool.viewbinding.activity.BaseViewAppCompatActivity;
import com.maoying.luoye.databinding.ActivityLazyBinding;
import com.maoying.luoye.lazy.OneFragment;
import com.maoying.luoye.lazy.TreeFragment;
import com.maoying.luoye.lazy.TwoFragment;


public class LazyActivity extends BaseViewAppCompatActivity<ActivityLazyBinding> {

    OneFragment oneFragment;
    TreeFragment treeFragment;
    TwoFragment twoFragment;

    @Override
    protected void initActivity() {

        oneFragment = new OneFragment();
        treeFragment = new TreeFragment();
        twoFragment = new TwoFragment();


        ShowHideExt.loadFragments(this, binding.frameLayout.getId(), 0, oneFragment, twoFragment, treeFragment);


        binding.one.setOnClickListener(v -> {
            ShowHideExt.showHideFragment(this, oneFragment);
        });

        binding.two.setOnClickListener(v -> {
            ShowHideExt.showHideFragment(this, twoFragment);
        });

        binding.three.setOnClickListener(v -> {
            ShowHideExt.showHideFragment(this, treeFragment);
        });


    }


}