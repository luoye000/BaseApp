package com.luoye.ktbase.lazy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.ViewBindingUtil

/**
 *
 * Created by: luoye
 * Time: 2022/12/23
 * user: 懒加载
 *
 */
abstract class BaseLazyViewFragment<V : ViewBinding> : LazyFragment() {

    protected lateinit var binding: V

    init {
        TAG = "---BaseViewFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        avedInstanceState: Bundle?
    ): View {
        binding = ViewBindingUtil.create(javaClass, inflater, container)
        initFragment()
        return binding.getRoot()
    }

    protected abstract fun initFragment()

}