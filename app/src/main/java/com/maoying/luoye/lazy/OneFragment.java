package com.maoying.luoye.lazy;

import com.luoye.apptool.lazy.BaseLazyViewFragment;
import com.luoye.apptool.lazy.LazyInterFace;
import com.luoye.apptool.utils.BaseUtils;
import com.maoying.luoye.databinding.FragmentTextBinding;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * user:
 */
public class OneFragment extends BaseLazyViewFragment<FragmentTextBinding> implements LazyInterFace {


    @Override
    protected void initFragment() {
 //       binding.text.setText("OneFragment: initFragment");
    }


    //懒加载

    @Override
    public void lazyInit() {
        binding.text.setText("OneFragment: lazyInit");
        BaseUtils.makeShortText(context,"OneFragment: lazyInit");
    }

}

