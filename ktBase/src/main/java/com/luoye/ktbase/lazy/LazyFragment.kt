package com.luoye.ktbase.lazy

import androidx.fragment.app.Fragment

/**
 *
 * Created by: luoye
 * Time: 2022/12/23
 * user: 懒加载
 *
 */
abstract class LazyFragment() : Fragment() {

    protected var TAG = "---BaseFragment"

    private var isLoaded = false

    private var lazyInterFace: LazyInterFace? = null

    init {
        if (this is LazyInterFace) {
            lazyInterFace = this
        }
    }

    private fun lazyInit() {
        lazyInterFace?.lazyInit()
    }


    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }


}