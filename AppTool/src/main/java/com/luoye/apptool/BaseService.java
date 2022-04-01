package com.luoye.apptool;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public abstract class BaseService extends Service {

    protected String TAG = "---BaseService";
    protected Context context;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        try {
            initService();
        } catch (Exception e) {
            Log.i(TAG, "BaseService_initService_Exception:" + e.getMessage());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            createNotificationChannel();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "onStartCommand:_createNotificationChannel: " + e.getMessage());
        }
        return super.onStartCommand(intent, flags, startId);
    }


    protected abstract void createNotificationChannel() throws Exception;


    @Override
    public void onDestroy() {
        super.onDestroy();
        //是否清除之前发送的通知
        stopForeground(true);
    }

    protected abstract void initService() throws Exception;

}
