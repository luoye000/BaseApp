package com.text.luoye.lowbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luoye.ktbase.xtool.ContentViewX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.R;


/**
 * Created by:
 * user:
 */


@ContentViewX(R.layout.item_one)
public class OneFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return XTool.inject(this, inflater, container);//必须要写的
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.text);
        textView.setOnClickListener(v -> {
            Toast.makeText(getContext(), textView.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}
