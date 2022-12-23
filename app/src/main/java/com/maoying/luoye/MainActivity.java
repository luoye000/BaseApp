package com.maoying.luoye;


import android.content.Intent;

import com.luoye.apptool.viewbinding.activity.BaseViewAppCompatActivity;
import com.maoying.luoye.databinding.ActivityMainBinding;


public class MainActivity extends BaseViewAppCompatActivity<ActivityMainBinding> {


    @Override
    protected void initActivity() {


        binding.bindingText.setOnClickListener(v -> startActivity(new Intent(context,BindingTextActivity.class)));
        binding.complexText.setOnClickListener(v -> startActivity(new Intent(context,ComplexActivity.class)));
        binding.lazyText.setOnClickListener(v -> startActivity(new Intent(context,LazyActivity.class)));

    }

}