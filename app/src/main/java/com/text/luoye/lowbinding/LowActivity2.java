package com.text.luoye.lowbinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luoye.ktbase.xtool.BindingX;
import com.luoye.ktbase.xtool.ViewDataBindingX;
import com.luoye.ktbase.xtool.ViewModelX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.R;
import com.text.luoye.databinding.ActivityLow2Binding;
import com.text.luoye.viewModel.MainModel;


@ViewDataBindingX(binding = ActivityLow2Binding.class)
public class LowActivity2 extends AppCompatActivity {


    @BindingX
    private ActivityLow2Binding binding;

    @ViewModelX(vmClass = MainModel.class)
    private MainModel mainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);


        binding.setData(mainModel);
        mainModel.getText().postValue(this.getClass().getName());
    }
}