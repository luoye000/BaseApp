package com.luoye.ktbase.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.utils.LogUtils
import java.lang.reflect.ParameterizedType


/**
 * @param position 泛型的位置
 */
inline fun <VB : ViewBinding> Any.getViewBinding(inflater: LayoutInflater,container: ViewGroup?=null, position: Int): VB {
    val allClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    LogUtils.i("getViewBinding: javaClass:${javaClass} allClass.size:${allClass.size}")
    val  vbClass:MutableList<Class<*>> = mutableListOf()
    allClass.forEach{
        LogUtils.i("getViewBinding: allClass:${it} ")
        if (ViewBinding::class.java.isAssignableFrom(it)) vbClass.add(it)
    }

    container?.let {
        val inflate = vbClass[position].getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return inflate.invoke(null, inflater, container, false) as VB
    }?:let {
        val inflate = vbClass[position].getDeclaredMethod("inflate", LayoutInflater::class.java)
        return inflate.invoke(null, inflater) as VB
    }

}


///**
// * @param position 泛型的位置
// */
//inline fun <VB : ViewBinding> Any.getViewBinding(
//    inflater: LayoutInflater,
//    container: ViewGroup?,
//    position: Int
//): VB {
//    val allClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
//    val  vbClass:MutableList<Class<*>> = mutableListOf()
//    allClass.forEach{
//        if (ViewBinding::class.java.isAssignableFrom(it)) vbClass.add(it)
//    }
//    val inflate = vbClass[position].getDeclaredMethod(
//        "inflate",
//        LayoutInflater::class.java,
//        ViewGroup::class.java,
//        Boolean::class.java
//    )
//    return inflate.invoke(null, inflater, container, false) as VB
//}


/**
 * @param position 泛型的位置
 */
inline fun <VM : ViewModel> ComponentActivity.createViewModel(
    activity: ComponentActivity,
    position: Int
): VM {
    val allClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    LogUtils.i("ComponentActivity.createViewModel: javaClass:${javaClass} allClass.size:${allClass.size}")
    val  vbClass:MutableList<Class<*>> = mutableListOf()
    allClass.forEach{
        val assignableFrom = ViewModel::class.java.isAssignableFrom(it)
        LogUtils.i("ComponentActivity.createViewModel: allClass:${it}  ViewModel::class.java.isAssignableFrom:$assignableFrom")
        if (assignableFrom) vbClass.add(it)
    }
    return ViewModelProvider(activity).get(vbClass[position] as Class<VM>)
}

/**
 * @param position 泛型的位置
 */
inline fun <VM : ViewModel> Fragment.createViewModel(
    fragment: Fragment,
    position: Int
): VM {
    val allClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    LogUtils.i("Fragment.createViewModel: javaClass:${javaClass} allClass.size:${allClass.size}")
    val  vbClass:MutableList<Class<*>> = mutableListOf()
    allClass.forEach{
        val assignableFrom = ViewModel::class.java.isAssignableFrom(it)
        LogUtils.i("Fragment.createViewModel: allClass:${it}  ViewModel::class.java.isAssignableFrom:$assignableFrom")
        if (assignableFrom) vbClass.add(it)
    }
    return ViewModelProvider(fragment).get(vbClass[position] as Class<VM>)
}

/**
 * @param position 泛型的位置
 */
inline fun <VM : ViewModel> Fragment.createActivityViewModel(
    fragment: Fragment,
    position: Int
): VM {
    val allClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    LogUtils.i(" Fragment.createActivityViewModel: javaClass:${javaClass} allClass.size:${allClass.size}")
    val  vbClass:MutableList<Class<*>> = mutableListOf()
    allClass.forEach{
        val assignableFrom = ViewModel::class.java.isAssignableFrom(it)
        LogUtils.i("Fragment.createActivityViewModel: allClass:${it}  ViewModel::class.java.isAssignableFrom:$assignableFrom")
        if (assignableFrom) vbClass.add(it)
    }
    return ViewModelProvider(fragment.requireActivity()).get(vbClass[position] as Class<VM>)
}

