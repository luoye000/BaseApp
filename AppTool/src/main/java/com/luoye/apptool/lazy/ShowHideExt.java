package com.luoye.apptool.lazy;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import java.util.List;

/**
 * Created by: luoye
 * Time: 2022/12/23
 * 扩展Fragment及Activity,使用add+show+hide模式下的Fragment的懒加载
 * 当调用 Fragment.showHideFragment ，确保已经先调用 Fragment.loadFragments
 * 当调用 FragmentActivity.showHideFragment，确保已经先调用 FragmentActivity.loadFragments
 */
public class ShowHideExt {


    /**
     * 加载根Fragment
     *
     * @param context         上下文
     * @param containerViewId 布局id
     * @param rootFragment    根fragment
     */
    public static void loadRootFragment(Fragment context, @IdRes int containerViewId, Fragment rootFragment) {
        loadFragmentsTransaction(containerViewId, 0, context.getChildFragmentManager(), rootFragment);
    }

    /**
     * 加载同级的Fragment
     *
     * @param context         上下文
     * @param containerViewId 布局id
     * @param showPosition    默认显示的角标
     * @param fragments       加载的fragment
     */
    public static void loadFragments(Fragment context, @IdRes int containerViewId, int showPosition, Fragment fragments) {
        loadFragmentsTransaction(containerViewId, showPosition, context.getChildFragmentManager(), fragments);
    }

    /**
     * 显示目标fragment，并隐藏其他fragment
     *
     * @param context      上下文
     * @param showFragment 需要显示的fragment
     */
    public static void showHideFragment(Fragment context, Fragment showFragment) {
        showHideFragmentTransaction(context.getChildFragmentManager(), showFragment);
    }


    /**
     * 加载根Fragment
     *
     * @param context         上下文
     * @param containerViewId 布局id
     * @param rootFragment    根fragment
     */
    public static void loadRootFragment(FragmentActivity context, @IdRes int containerViewId, Fragment rootFragment) {
        loadFragmentsTransaction(containerViewId, 0, context.getSupportFragmentManager(), rootFragment);
    }

    /**
     * 加载同级的Fragment
     *
     * @param context         上下文
     * @param containerViewId 布局id
     * @param showPosition    默认显示的角标
     * @param fragments       加载的fragment
     */
    public static void loadFragments(FragmentActivity context, @IdRes int containerViewId, int showPosition, Fragment... fragments) {
        loadFragmentsTransaction(containerViewId, showPosition, context.getSupportFragmentManager(), fragments);
    }

    /**
     * 显示目标fragment，并隐藏其他fragment
     *
     * @param context      上下文
     * @param showFragment 需要显示的fragment
     */
    public static void showHideFragment(FragmentActivity context, Fragment showFragment) {
        showHideFragmentTransaction(context.getSupportFragmentManager(), showFragment);
    }

    /**
     * 使用add+show+hide模式加载fragment
     * <p>
     * 默认显示位置[showPosition]的Fragment，最大Lifecycle为Lifecycle.State.RESUMED
     * 其他隐藏的Fragment，最大Lifecycle为Lifecycle.State.STARTED
     *
     * @param containerViewId 容器id
     * @param showPosition    fragments
     * @param fragmentManager FragmentManager
     * @param fragments       控制显示的Fragments
     */
    private static void loadFragmentsTransaction(@IdRes int containerViewId, int showPosition, FragmentManager fragmentManager, Fragment... fragments) {

        if (fragments != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            for (int i = 0; i < fragments.length; i++) {
                fragmentTransaction.add(containerViewId, fragments[i], fragments[i].getClass().getName());
                if (showPosition == i) {
                    fragmentTransaction.setMaxLifecycle(fragments[i], Lifecycle.State.RESUMED);
                } else {
                    fragmentTransaction.hide(fragments[i]);
                    fragmentTransaction.setMaxLifecycle(fragments[i], Lifecycle.State.STARTED);
                }
            }
            fragmentTransaction.commit();
        } else {
            throw new IllegalStateException("fragments must not empty");
        }
    }

    /**
     * 显示需要显示的Fragment[showFragment]，并设置其最大Lifecycle为Lifecycle.State.RESUMED。
     * 同时隐藏其他Fragment,并设置最大Lifecycle为Lifecycle.State.STARTED
     *
     * @param fragmentManager
     * @param showFragment
     */
    private static void showHideFragmentTransaction(FragmentManager fragmentManager, Fragment showFragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(showFragment);
        fragmentTransaction.setMaxLifecycle(showFragment, Lifecycle.State.RESUMED);
        List<Fragment> fragments1 = fragmentManager.getFragments();
        for (Fragment fragment : fragments1) {
            if (fragment != showFragment) {
                fragmentTransaction.hide(fragment);
                fragmentTransaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);

            }
        }
        fragmentTransaction.commit();
    }

}
