package com.luoye.ktbase.xtool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by:
 * user:
 */
public class FragmentInject {
    protected static View inject(Fragment object, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Class<?> aClass = object.getClass();

        View view = null;
        ViewDataBindingX viewDataBindingX = aClass.getAnnotation(ViewDataBindingX.class);
        if (viewDataBindingX != null) {
            Class<? extends ViewDataBinding> binding = viewDataBindingX.binding();
            if (binding != null) {
                view = injectViewDataBinding(object, binding, layoutInflater, viewGroup);
                injectViewModel(object);
                return view;
            }
        }


        ViewBindingX viewBindingX = aClass.getAnnotation(ViewBindingX.class);
        if (viewBindingX != null) {
            Class<? extends ViewBinding> binding = viewBindingX.binding();
            if (binding != null) {
                view = injectViewBinding(object, binding, layoutInflater, viewGroup);
                return view;
            }
        }

        ContentViewX contentView = aClass.getAnnotation(ContentViewX.class);
        if (contentView != null) {
            view = injectContentView(contentView, layoutInflater, viewGroup);
            return view;
        }

        return view;
    }

    /**
     * 创建ViewModel 并赋值
     */
    private static void injectViewModel(Fragment object) {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            ViewModelX viewModelX = field.getAnnotation(ViewModelX.class);
            if (viewModelX != null) {
                try {
                    Object viewModel = null;
                    switch (viewModelX.type()) {
                        case SELF:
                            viewModel = new ViewModelProvider(object).get(viewModelX.vmClass());
                            break;
                        case ACTIVITY:
                            viewModel = new ViewModelProvider(object.getActivity()).get(viewModelX.vmClass());
                            break;
                    }
                    if (viewModel != null) {
                        field.set(object, viewModel);
                    }
                } catch (Exception e) {

                }

            }
        }
    }


    /**
     * 反射创建 ViewDataBinding 并添加布局 为binging 赋值
     */
    private static <V extends ViewDataBinding> View injectViewDataBinding(Fragment object, Class<V> vClass, LayoutInflater layoutInflater, ViewGroup viewGroup) {

        Class<?> aClass = object.getClass();
        try {
            //获取ViewBinding.inflate()方法
            Method inflate = vClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            V binding = (V) inflate.invoke(null, layoutInflater, viewGroup, false);

            //注册生命周期
            binding.setLifecycleOwner(object);
            //为binding 赋值
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                BindingX bindingX = field.getAnnotation(BindingX.class);
                if (bindingX != null) {
                    field.set(object, binding);
                }
            }
            return binding.getRoot();
        } catch (Exception e) {

            return null;
        }
    }

    /**
     * 反射创建 ViewBinding 并添加布局 为binging 赋值
     */
    private static <V extends ViewBinding> View injectViewBinding(Fragment object, Class<V> vClass, LayoutInflater layoutInflater, ViewGroup viewGroup) {

        Class<?> aClass = object.getClass();
        try {
            //获取ViewBinding.inflate()方法
            Method inflate = vClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            V binding = (V) inflate.invoke(null, layoutInflater, viewGroup, false);
            //为binding 赋值
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                BindingX bindingX = field.getAnnotation(BindingX.class);
                if (bindingX != null) {
                    field.set(object, binding);
                }
            }
            return binding.getRoot();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 添加布局
     */
    private static View injectContentView(ContentViewX contentView, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int value = contentView.value();
        if (value == -1) {
            return null;
        }
        try {
            return layoutInflater.inflate(value, viewGroup, false);
        } catch (Exception e) {
            return null;
        }
    }

}
