package com.luoye.ktbase.utils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

/**
 *
 * Created by: luoye
 * Time: 2022/11/30
 * user: Fragment添加工具
 *
 */
open class FragmentUtils {

    companion object{

        /*设置显示的Fragment*/
        fun switchFragment(activity: FragmentActivity, containerViewId: Int, targetFragment: Fragment): FragmentTransaction {
            val fm = activity.supportFragmentManager
            val fragments = fm.fragments
            val transaction = fm.beginTransaction()
            for (fragment in fragments) {
                if (targetFragment != fragment && !fragment.isHidden) transaction.hide(fragment)
            }
            //判断是否是第一次添加
            if (targetFragment.isAdded) {
                //隐藏当前页面 显示需要显示的页面
                transaction.show(targetFragment)
            } else {
                //添加新的页面
                transaction.add(containerViewId, targetFragment, targetFragment.javaClass.name)
            }
            return transaction
        }

    }
}