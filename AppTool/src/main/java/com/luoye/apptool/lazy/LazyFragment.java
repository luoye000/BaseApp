package com.luoye.apptool.lazy;

import androidx.fragment.app.Fragment;

import com.luoye.apptool.lazy.LazyInterFace;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * user: 懒加载
 */
public abstract class LazyFragment extends Fragment {

    protected String TAG = "---BaseFragment";

    public LazyFragment() {
        if (this instanceof LazyInterFace) {
            lazyInterFace = (LazyInterFace) this;
        }
    }

    private boolean isLoaded = false;

    private LazyInterFace lazyInterFace;

    private void lazyInit() {
        if (lazyInterFace != null) lazyInterFace.lazyInit();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (!isLoaded && !isHidden()) {
            lazyInit();
            isLoaded = true;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoaded = false;
    }

}
