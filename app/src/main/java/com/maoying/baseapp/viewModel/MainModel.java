package com.maoying.baseapp.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

public class MainModel extends ViewModel {
    private MediatorLiveData<String> text;


    public MediatorLiveData<String> getText() {

        if (text == null) {
            text = new MediatorLiveData<>();
            text.postValue(getClass().getName());
        }
        return text;
    }
}
