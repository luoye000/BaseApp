package com.luoye.ktbase.binding.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.annotation.StyleRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.luoye.ktbase.binding.getViewBinding

/**
 *
 * Created by:
 * user:
 *
 */
abstract class BaseDataDialog<V : ViewDataBinding,M :ViewModel>(
    context: Context,
    @StyleRes res: Int,
    val viewModel: M,
    val owner: LifecycleOwner
) : Dialog(context, res), DefaultLifecycleObserver {

    protected val binding by lazy { getViewBinding<V>(inflater = layoutInflater, position = 0) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super<Dialog>.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCanceledOnTouchOutside(true) //边缘点击消失
        owner.lifecycle.addObserver(this)
        binding.lifecycleOwner=owner
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