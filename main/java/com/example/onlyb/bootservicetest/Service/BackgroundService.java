package com.example.onlyb.bootservicetest.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.onlyb.bootservicetest.KeepAlive.ScreenStatusService;

import static com.example.onlyb.bootservicetest.KeepAlive.ScreenStatusService.isScreenStatusCheck;

public class BackgroundService extends Service {
    public BackgroundService() {
    }

    @Override
    public void onCreate() {

        super.onCreate();
        if (isScreenStatusCheck == false) {
            Intent screenStatusService = new Intent(BackgroundService.this, ScreenStatusService.class);
            startService(screenStatusService);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
