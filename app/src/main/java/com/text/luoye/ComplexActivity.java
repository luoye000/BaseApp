package com.text.luoye;



import com.luoye.ktbase.binding.activity.databinding.BaseDataAppCompatActivity;
import com.luoye.ktbase.binding.fragment.ShowHideExtKt;
import com.text.luoye.databinding.ActivityComplexBinding;
import com.text.luoye.fragment.ComplexBindingFragment;
import com.text.luoye.fragment.ComplexFragment;
import com.text.luoye.viewModel.MainModel;

public class ComplexActivity extends BaseDataAppCompatActivity<ActivityComplexBinding, MainModel> {


    ComplexBindingFragment complexbindingFragment;
    ComplexFragment complexFragment;

    @Override
    protected void initActivity() {

        complexbindingFragment = new ComplexBindingFragment();
        complexFragment = new ComplexFragment();



        getBinding().complex.setOnClickListener(view -> {
            getViewModel().getText().postValue("这是多布局list样式演示 使用view");

            ShowHideExtKt.loadRootFragment(this,getBinding().frameLayout.getId(),complexFragment);

        });

        getBinding().complexBinding.setOnClickListener(view -> {
            getViewModel().getText().postValue("这是多布局list样式演示 使用viewBinging");
            ShowHideExtKt.loadRootFragment(this,getBinding().frameLayout.getId(),complexbindingFragment);

        });


    }

}