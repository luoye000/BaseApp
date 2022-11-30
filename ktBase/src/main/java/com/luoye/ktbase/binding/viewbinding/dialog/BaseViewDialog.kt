package com.luoye.ktbase.binding.viewbinding.dialog


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.annotation.StyleRes
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.luoye.ktbase.binding.ViewBindingUtil

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user: 基类
 *
 */
abstract class BaseViewDialog<V : ViewBinding>(context: Context, @StyleRes res: Int) : Dialog(context, res) {

    protected var binding: V

    init { binding = ViewBindingUtil.create(javaClass, LayoutInflater.from(context)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCanceledOnTouchOutside(true) //边缘点击消失
        initDialog()
    }

    protected abstract fun initDialog()

    override fun show() {
        super.show()
        window?.let {
            val lp = it.attributes
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.gravity = Gravity.CENTER
            it.attributes = lp
        }
    }

}