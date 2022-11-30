package com.luoye.ktbase.binding.viewbinding.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.ViewBindingUtil
import com.luoye.ktbase.tool.ActivityTool

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user:
 *
 */
abstract class BaseViewFragmentActivity<V : ViewBinding> : FragmentActivity() {

    protected var TAG = "---"
    protected lateinit var context: Context
    protected lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewBindingUtil.create(javaClass, LayoutInflater.from(this))
        setContentView(binding.getRoot())
        context = this
        ActivityTool.instance.addActivity(this)
        initActivity()
    }

    protected abstract fun initActivity()


    override fun onDestroy() {
        super.onDestroy()
        ActivityTool.instance.removeActivity(this)
    }

}