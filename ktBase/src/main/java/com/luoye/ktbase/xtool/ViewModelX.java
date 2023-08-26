package com.luoye.ktbase.xtool;

import androidx.lifecycle.ViewModel;


import com.luoye.ktbase.xtool.ViewModelType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by:
 * user:
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelX {
    Class<? extends ViewModel> vmClass();

    ViewModelType type() default ViewModelType.SELF;// 只有在Fragment 中生效

}
