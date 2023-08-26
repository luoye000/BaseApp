package com.text.luoye.lowbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luoye.ktbase.xtool.BindingX;
import com.luoye.ktbase.xtool.ViewDataBindingX;
import com.luoye.ktbase.xtool.ViewModelType;
import com.luoye.ktbase.xtool.ViewModelX;
import com.luoye.ktbase.xtool.XTool;
import com.text.luoye.databinding.ItemThreeBinding;
import com.text.luoye.viewModel.FragModel;
import com.text.luoye.viewModel.MainModel;

/**
 * Created by:
 * user:
 */

@ViewDataBindingX(binding = ItemThreeBinding.class)
public class ThreeFragment extends Fragment {


    @BindingX
    private ItemThreeBinding binding;

    @ViewModelX(vmClass = MainModel.class,type = ViewModelType.ACTIVITY)
    private MainModel mainModel;

    @ViewModelX(vmClass = FragModel.class,type = ViewModelType.SELF)
    private FragModel fragModel;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return XTool.inject(this,inflater,container);//必须要写的
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setOne(fragModel);
        binding.setMain(mainModel);
        fragModel.getText().postValue(this.getClass().getName());



    }
}
