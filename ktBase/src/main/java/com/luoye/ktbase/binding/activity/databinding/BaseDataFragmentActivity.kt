package com.luoye.ktbase.binding.activity.databinding

import android.content.Context
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.luoye.ktbase.binding.createViewModel
import com.luoye.ktbase.binding.getViewBinding
import com.luoye.ktbase.tool.ActivityTool
import java.lang.Deprecated

/**
 *
 * Created by: 
 * Time: 2023/4/7
 * user:
 *
 */
abstract class BaseDataFragmentActivity<V : ViewDataBinding, M : ViewModel>:FragmentActivity() {

    protected var TAG = "---"
    protected val context: Context by lazy(mode = LazyThreadSafetyMode.NONE) { this }
        @Deprecated
        get
    protected val binding by lazy(mode = LazyThreadSafetyMode.NONE) { getViewBinding<V>(inflater = layoutInflater, position = 0) }
    protected val viewModel by lazy(mode = LazyThreadSafetyMode.NONE) { createViewModel<M>(this, 1) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.getRoot())
        binding.lifecycleOwner = this
        ActivityTool.instance.addActivity(this)
        initActivity()
    }

    protected abstract fun initActivity()

    override fun onDestroy() {
        super.onDestroy()
        ActivityTool.instance.removeActivity(this)
    }

}