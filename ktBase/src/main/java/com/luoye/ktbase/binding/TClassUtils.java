package com.luoye.ktbase.binding;

import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public class TClassUtils {


    /**
     * 获取 ViewModel 类型的第一个 泛型的(T.class)
     *
     * @param clazz getClazz()
     * @return T.class
     */
    public static Class<?> getViewModelClass(Class<?> clazz) {
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = Objects.requireNonNull(parameterizedType).getActualTypeArguments();
        for (Type type : types) {
            if (type instanceof Class<?>) {
                Class<?> temp = (Class<?>) type;
                if (ViewModel.class.isAssignableFrom(temp)) return temp;
            }
        }
        return null;
    }

    /**
     * 获取 ViewBinding 类型的第一个 泛型的(T.class)
     *
     * @param clazz getClazz()
     * @return T.class
     */
    public static Class<?> getViewBindingClass(Class<?> clazz) {
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = Objects.requireNonNull(parameterizedType).getActualTypeArguments();
        for (Type type : types) {
            if (type instanceof Class<?>) {
                Class<?> temp = (Class<?>) type;
                if (ViewBinding.class.isAssignableFrom(temp)) return temp;
            }
        }
        return null;
    }





    /**
     * 获取 泛型的(T.class)
     *
     * @param clazz getClazz()
     * @param id    获取第几个
     * @return T.class
     */
    public static Class<?> getTClass(Class<?> clazz, int id) {
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = Objects.requireNonNull(parameterizedType).getActualTypeArguments();
        if (types.length > id) {
            return (Class<?>) types[id];
        }
        return null;
    }
}
