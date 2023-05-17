package com.luoye.ktbase.binding.fragment.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.getViewBinding

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewFragment<V : ViewBinding> : Fragment() {

    protected var TAG = "---BaseViewFragment"
    protected lateinit var binding: V
        private set
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        avedInstanceState: Bundle?
    ): View {
        binding = getViewBinding(inflater, container, 0)
        return binding.getRoot()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }


    protected abstract fun initFragment()

}