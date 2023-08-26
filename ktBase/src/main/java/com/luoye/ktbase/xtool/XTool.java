package com.luoye.ktbase.xtool;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Created by:
 * user:
 */
public class XTool {

    public static void inject(Activity object) {
        ActivityInject.inject(object);
    }


    public static View inject(Fragment object, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return FragmentInject.inject(object,layoutInflater,viewGroup);
    }

}
