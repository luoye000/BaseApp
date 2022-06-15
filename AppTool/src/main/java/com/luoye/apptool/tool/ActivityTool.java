package com.luoye.apptool.tool;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * TIME：2022/2/23
 * user：Activity 管理类
 */
public class ActivityTool {


    private static ActivityTool activityTool;


    public static ActivityTool getInstance() {
        if (activityTool == null) {
            synchronized (ActivityTool.class) {
                if (activityTool == null) activityTool = new ActivityTool();
            }
        }
        return activityTool;
    }

    public final List<Activity> activities = new ArrayList<Activity>();

    /*绑定Activity*/
    public void addActivity(Activity activity) {
        synchronized (activities) {
            activities.add(activity);
        }
    }

    /*解绑Activity*/
    public void removeActivity(Activity activity) {
        synchronized (activities) {
            activities.remove(activity);
        }
    }

    /*关闭指定的Activity*/
    public void finishActivity(String... arrActivityName) {
        //在activities集合中找到类名与指定类名相同的Activity就关闭
        synchronized (activities) {
            boolean is = false;
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                String name = activity.getClass().getName();//activity的包名+类名
                for (String activityName : arrActivityName) {
                    if (name.equals(activityName)) {
                        is = true;
                        break;
                    }
                    is = false;
                }
                if (is) {
                    if (activity.isFinishing()) {
                        //当前activity如果已经Finish，则只从activities清除就好了
                        activities.remove(activity);
                    } else {
                        //没有Finish则Finish
                        activity.finish();
                    }
                }
            }
        }
    }

    /*只保留某个Activity，关闭其他所有Activity*/
    public void finishOtherActivity(String... arrActivityName) {
        synchronized (activities) {
            boolean is = false;
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                String name = activity.getClass().getName();//activity的类名
                for (String activityName : arrActivityName) {
                    if (name.equals(activityName)) {
                        is = true;
                        break;
                    }
                    is = false;
                }
                if (!is) {
                    if (activity.isFinishing()) {
                        //当前activity如果已经Finish，则只从activities清除就好了
                        activities.remove(activity);
                    } else {
                        //没有Finish则Finish
                        activity.finish();
                    }
                }
            }
        }
    }

    /*关闭所有Activity*/
    public void finishAll() {
        synchronized (activities) {
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                if (!activity.isFinishing()) activity.finish();
            }
            activities.clear();
        }
    }


}
