package com.text.luoye.lowbinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luoye.ktbase.xtool.BindingX;
import com.luoye.ktbase.xtool.ViewBindingX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.R;
import com.text.luoye.databinding.ActivityLow1Binding;


@ViewBindingX(binding = ActivityLow1Binding.class)
public class LowActivity1 extends AppCompatActivity {


    @BindingX
    private ActivityLow1Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);

        binding.text.setText(this.getClass().getName());
    }
}