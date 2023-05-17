package com.text.luoye.lazy;


import com.luoye.ktbase.binding.fragment.lazy.LazyInterFace;
import com.luoye.ktbase.binding.fragment.viewbinding.BaseLazyViewFragment;
import com.luoye.ktbase.utils.ToastUtils;
import com.text.luoye.databinding.FragmentTextBinding;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * user:
 */
public class OneFragment extends BaseLazyViewFragment<FragmentTextBinding> implements LazyInterFace {


    @Override
    protected void initFragment() {

    }


    //懒加载

    @Override
    public void lazyInit() {
        getBinding().text.setText("OneFragment: lazyInit");
        ToastUtils.Companion.makeLong(getContext(),"OneFragment: lazyInit");

    }

}

