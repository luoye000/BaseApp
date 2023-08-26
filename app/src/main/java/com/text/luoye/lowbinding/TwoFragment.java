package com.text.luoye.lowbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luoye.ktbase.xtool.BindingX;
import com.luoye.ktbase.xtool.ViewBindingX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.databinding.ItemTwoBinding;


/**
 * Created by:
 * user:
 */

@ViewBindingX(binding = ItemTwoBinding.class)
public class TwoFragment extends Fragment {


    @BindingX
    private ItemTwoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return XTool.inject(this,inflater,container);//必须要写的
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.text.setOnClickListener(v -> {
            Toast.makeText(getContext(), binding.text.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}