package com.example.onlyb.bootservicetest.KeepAlive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static com.example.onlyb.bootservicetest.KeepAlive.KeepAliveActivity.isKeepAliveRunning;

public class ScreenStatusService extends Service {

    public static boolean isScreenStatusCheck = false;

    @Override
    public void onCreate() {
        super.onCreate();
        new ScreenStatusListener(this).begin(new ScreenStatusListener.ScreenStateListener() {

            @Override
            public void onScreenOn() {
                // 亮屏，finish一个像素的Activity
                if (isKeepAliveRunning == true) {
                    Toast.makeText(ScreenStatusService.this.getApplicationContext(), "Screen On!", Toast.LENGTH_LONG).show();
                    KeepAliveManager.getInstance(ScreenStatusService.this).finishKeepAliveActivity();
                    Log.d("KeepAlive", "ScreenOn!!!!!!");
                }

            }

            @Override
            public void onScreenOff() {
                // 灭屏，启动一个像素的Activity
                KeepAliveManager.getInstance(ScreenStatusService.this).startKeepAliveActivity();
                Log.d("KeepAlive", "ScreenOff!!!!!");
            }
        });

        isScreenStatusCheck = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {

    }
}