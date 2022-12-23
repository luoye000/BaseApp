package com.maoying.luoye.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by: luoye
 * Time: 2022/10/13
 * user:
 */
public class FragModel extends ViewModel {


    private MediatorLiveData<String> text;


    public MediatorLiveData<String> getText() {

        if (text == null) {
            text = new MediatorLiveData<>();
            text.postValue("我是Frag的viewModel 时间："+System.currentTimeMillis());
        }
        return text;
    }
}

