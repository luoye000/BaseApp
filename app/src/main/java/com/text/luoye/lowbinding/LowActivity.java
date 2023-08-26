package com.text.luoye.lowbinding;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.luoye.ktbase.xtool.ContentViewX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.R;


@ContentViewX(R.layout.activity_low)
public class LowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);


        findViewById(R.id.but1).setOnClickListener(v -> startActivity(new Intent(this, LowActivity1.class)));

        findViewById(R.id.but2).setOnClickListener(v -> startActivity(new Intent(this, LowActivity2.class)));

        findViewById(R.id.but3).setOnClickListener(v -> startActivity(new Intent(this, LowActivity3.class)));


    }
}