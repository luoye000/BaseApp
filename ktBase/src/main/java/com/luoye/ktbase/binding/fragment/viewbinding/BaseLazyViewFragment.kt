package com.luoye.ktbase.binding.fragment.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.fragment.lazy.LazyFragment
import com.luoye.ktbase.binding.getViewBinding

/**
 *
 * Created by: 
 * Time: 2022/12/23
 * user: 懒加载
 *
 */
abstract class BaseLazyViewFragment<V : ViewBinding> : LazyFragment() {

    protected lateinit var binding: V
        private set

    init {
        TAG = "---BaseViewFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        avedInstanceState: Bundle?
    ): View {
        binding =getViewBinding(inflater, container, 0)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }


    protected abstract fun initFragment()

}