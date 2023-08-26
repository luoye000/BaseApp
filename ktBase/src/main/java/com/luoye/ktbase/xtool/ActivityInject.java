package com.luoye.ktbase.xtool;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by:
 * user:
 */
public class ActivityInject {


    protected static void inject(Object object) {
        Class<?> aClass = object.getClass();

        if (object instanceof ComponentActivity) {
            ViewDataBindingX viewDataBindingX = aClass.getAnnotation(ViewDataBindingX.class);
            if (viewDataBindingX != null) {
                Class<? extends ViewDataBinding> binding = viewDataBindingX.binding();
                if (binding != null) {
                    injectViewDataBinding((ComponentActivity) object, binding);
                    injectViewModel((ComponentActivity) object);
                    return;
                }
            }
        }

        if (object instanceof Activity) {

            ViewBindingX viewBindingX = aClass.getAnnotation(ViewBindingX.class);
            if (viewBindingX != null) {
                Class<? extends ViewBinding> binding = viewBindingX.binding();
                if (binding != null) {
                    injectViewBinding((Activity) object, binding);
                    return;
                }
            }

            ContentViewX contentView = aClass.getAnnotation(ContentViewX.class);
            if (contentView != null) {
                injectContentView((Activity) object, contentView);
                return;
            }

        }

    }

    /**
     * 创建ViewModel 并赋值
     */
    private static void injectViewModel(ComponentActivity object) {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            ViewModelX viewModelX = field.getAnnotation(ViewModelX.class);
            if (viewModelX != null) {
                Object viewModel = new ViewModelProvider(object).get(viewModelX.vmClass());
                try {
                    field.set(object, viewModel);
                } catch (Exception e) {

                }

            }
        }
    }


    /**
     * 反射创建 ViewDataBinding 并添加布局 为binging 赋值
     */
    private static <V extends ViewDataBinding> void injectViewDataBinding(ComponentActivity object, Class<V> vClass) {

        Class<?> aClass = object.getClass();
        try {
            //获取 layoutInflater
            Method getLayoutInflater = aClass.getMethod("getLayoutInflater");
            Object layoutInflater = getLayoutInflater.invoke(object);

            //获取ViewBinding.inflate()方法
            Method inflate = vClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            V binding = (V) inflate.invoke(null, layoutInflater, null, false);

            //获取 setContentView
            Method setContentView = aClass.getMethod("setContentView", View.class);

            //添加布局
            setContentView.invoke(object, binding.getRoot());

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
        } catch (Exception e) {

        }
    }

    /**
     * 反射创建 ViewBinding 并添加布局 为binging 赋值
     */
    private static <V extends ViewBinding> void injectViewBinding(Activity object, Class<V> vClass) {

        Class<?> aClass = object.getClass();
        try {
            //获取 layoutInflater
            Method getLayoutInflater = aClass.getMethod("getLayoutInflater");
            Object layoutInflater = getLayoutInflater.invoke(object);

            //获取ViewBinding.inflate()方法
            Method inflate = vClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            V binding = (V) inflate.invoke(null, layoutInflater, null, false);

            //获取 setContentView
            Method setContentView = aClass.getMethod("setContentView", View.class);

            //添加布局
            setContentView.invoke(object, binding.getRoot());

            //为binding 赋值
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                BindingX bindingX = field.getAnnotation(BindingX.class);
                if (bindingX != null) {
                    field.set(object, binding);
                }
            }
        } catch (Exception e) {

        }
    }


    /**
     * 添加布局
     */
    private static void injectContentView(Activity object, ContentViewX contentView) {
        Class<?> aClass = object.getClass();
        int value = contentView.value();
        if (value == -1) {
            return;
        }
        try {
            Method setContentView = aClass.getMethod("setContentView", int.class);
            setContentView.invoke(object, value);
        } catch (Exception e) {

        }
    }

}
