package com.text.luoye;


import android.content.Intent;

import com.luoye.ktbase.binding.activity.viewbinding.BaseViewAppCompatActivity;
import com.text.luoye.databinding.ActivityMainBinding;
import com.text.luoye.lowbinding.LowActivity;


public class MainActivity extends BaseViewAppCompatActivity<ActivityMainBinding> {


    @Override
    protected void initActivity() {


        getBinding().bindingText.setOnClickListener(v -> startActivity(new Intent(getContext(),BindingTextActivity.class)));
        getBinding().complexText.setOnClickListener(v -> startActivity(new Intent(getContext(),ComplexActivity.class)));
        getBinding().lazyText.setOnClickListener(v -> startActivity(new Intent(getContext(),LazyActivity.class)));
        getBinding().bindingX.setOnClickListener(v -> startActivity(new Intent(getContext(), LowActivity.class)));
    }

}