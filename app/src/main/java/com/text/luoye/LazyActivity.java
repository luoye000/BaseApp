package com.text.luoye;


import com.luoye.ktbase.binding.activity.viewbinding.BaseViewAppCompatActivity;
import com.luoye.ktbase.binding.fragment.ShowHideExtKt;
import com.text.luoye.databinding.ActivityLazyBinding;
import com.text.luoye.lazy.OneFragment;
import com.text.luoye.lazy.TreeFragment;
import com.text.luoye.lazy.TwoFragment;


public class LazyActivity extends BaseViewAppCompatActivity<ActivityLazyBinding> {

    OneFragment oneFragment;
    TreeFragment treeFragment;
    TwoFragment twoFragment;

    @Override
    protected void initActivity() {

        oneFragment = new OneFragment();
        treeFragment = new TreeFragment();
        twoFragment = new TwoFragment();



        ShowHideExtKt.loadFragments(this, getBinding().frameLayout.getId(), 0, oneFragment, twoFragment, treeFragment);


        getBinding().one.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, oneFragment);
        });

        getBinding().two.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, twoFragment);
        });

        getBinding().three.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, treeFragment);
        });


    }


}