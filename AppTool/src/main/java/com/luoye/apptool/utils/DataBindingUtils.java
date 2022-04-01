package com.luoye.apptool.utils;

import androidx.lifecycle.ViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/*
 * TIME：2022/3/28
 * user：DataBinding 工具类
 */
public class DataBindingUtils {


    //获取 泛型的(T.class)
    public  static Class<?> getViewModelClass(Class<?> clazz) {
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = Objects.requireNonNull(parameterizedType).getActualTypeArguments();
        Class<?> bindingClass = null;
        for (Type type : types) {
            if (type instanceof Class<?>) {
                Class<?> temp = (Class<?>) type;
                if (ViewModel.class.isAssignableFrom(temp)) bindingClass = temp;
            }
        }
        return bindingClass;
    }

}
