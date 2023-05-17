package com.luoye.ktbase.binding.activity.viewbinding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.getViewBinding
import com.luoye.ktbase.tool.ActivityTool
import java.lang.Deprecated

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewFragmentActivity<V : ViewBinding> : FragmentActivity() {

    protected var TAG = "---"
    protected val context: Context by lazy(mode = LazyThreadSafetyMode.NONE) { this }
        @Deprecated
        get
    protected val binding by lazy { getViewBinding<V>(inflater = layoutInflater, position = 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.getRoot())
        ActivityTool.instance.addActivity(this)
        initActivity()
    }

    protected abstract fun initActivity()


    override fun onDestroy() {
        super.onDestroy()
        ActivityTool.instance.removeActivity(this)
    }

}