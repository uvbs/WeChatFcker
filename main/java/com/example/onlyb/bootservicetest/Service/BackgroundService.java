package com.example.onlyb.bootservicetest.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.onlyb.bootservicetest.KeepAlive.ScreenStatusService;

import static com.example.onlyb.bootservicetest.KeepAlive.ScreenStatusService.isScreenStatusCheck;

public class BackgroundService extends Service {

    public static boolean isBackgroundRunning = false;

    public BackgroundService() {
    }

    @Override
    public void onCreate() {

        super.onCreate();
        if (isScreenStatusCheck == false) {
            Intent screenStatusService = new Intent(BackgroundService.this, ScreenStatusService.class);
            startService(screenStatusService);
        }
        isBackgroundRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                //可能需要在这里处理耗时逻辑
            }
        }).start();*/

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Intent intent = new Intent("com.example.onlyb.bootservicetest.destroy"); //注意改成新包名
        sendBroadcast(intent);
        super.onDestroy();
    }
}
