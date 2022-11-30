package com.luoye.ktbase.binding.viewbinding.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.ViewBindingUtil

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewFragment<V : ViewBinding> : Fragment() {

    protected var TAG = "---BaseViewFragment"
    protected lateinit var binding: V


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