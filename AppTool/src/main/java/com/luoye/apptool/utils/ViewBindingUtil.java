package com.luoye.apptool.utils;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;


/**
 * user：利用反射获取ViewBinding   -keep class  包名.databinding.* {*;}
 */
public class ViewBindingUtil {

    public static <Binding extends ViewBinding> Binding create(Class<?> clazz, LayoutInflater inflater) {
        return create(clazz, inflater, null);
    }

    public static <Binding extends ViewBinding> Binding create(Class<?> clazz, LayoutInflater inflater, ViewGroup root) {
        return create(clazz, inflater, root, false);
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public static <Binding extends ViewBinding> Binding create(Class<?> clazz, LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        Class<?> bindingClass =TClassUtils.getViewBindingClass(clazz) ;
        Binding binding = null;
        if (bindingClass != null) {
            try {
                Method method = bindingClass.getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
                binding = (Binding) method.invoke(null, inflater, root, attachToRoot);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Objects.requireNonNull(binding);
    }

}