package com.maoying.luoye.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

public class MainModel extends ViewModel {
    private MediatorLiveData<String> text;


    public MediatorLiveData<String> getText() {

        if (text == null) {
            text = new MediatorLiveData<>();
            text.postValue("我是activity的viewModel 时间："+System.currentTimeMillis());
        }
        return text;
    }
}
