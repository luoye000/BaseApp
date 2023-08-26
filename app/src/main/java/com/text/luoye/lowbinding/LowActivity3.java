package com.text.luoye.lowbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.luoye.ktbase.binding.fragment.ShowHideExtKt;
import com.luoye.ktbase.xtool.BindingX;
import com.luoye.ktbase.xtool.ViewDataBindingX;
import com.luoye.ktbase.xtool.ViewModelX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.databinding.ActivityLow3Binding;
import com.text.luoye.viewModel.MainModel;

@ViewDataBindingX(binding = ActivityLow3Binding.class)
public class LowActivity3 extends AppCompatActivity {

    @BindingX
    private ActivityLow3Binding binding;

    @ViewModelX(vmClass = MainModel.class)
    private MainModel mainModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);

        binding.setData(mainModel);


        mainModel.getText().postValue(this.getClass().getName());

        Fragment oneFragment = new OneFragment();
        Fragment twoFragment = new TwoFragment();
        Fragment treeFragment = new ThreeFragment();


        ShowHideExtKt.loadFragments(this, binding.frameLayout.getId(), 0, oneFragment, twoFragment, treeFragment);



        binding.but1.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, oneFragment);
        });

        binding.but2.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, twoFragment);
        });

        binding.but3.setOnClickListener(v -> {
            ShowHideExtKt.showHideFragment(this, treeFragment);
        });
    }
}