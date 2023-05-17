package com.luoye.ktbase.binding.fragment.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.luoye.ktbase.binding.createActivityViewModel
import com.luoye.ktbase.binding.createViewModel
import com.luoye.ktbase.binding.getViewBinding

/**
 *
 * Created by: 
 * Time: 2023/4/7
 * user: 绑定自己ViewModel 绑定activity 共享ViewModel
 *
 */
abstract class BaseDataAllFragment<V : ViewDataBinding, MA : ViewModel,M : ViewModel> : Fragment() {


    protected lateinit var binding: V
        private set
    protected val viewModelActivity by lazy { createActivityViewModel<MA>(this, 0) }
    protected val viewModel by lazy { createViewModel<M>(this, 1) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container, 0)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }


    protected abstract fun initFragment()
}