package com.example.onlyb.bootservicetest.KeepAlive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by onlyb on 2017/9/7.
 */

public class ScreenStatusListener {

    private ScreenStateListener mScreenStateListener;
    private Context mContext;
    private ScreenBroadcastReceiver mScreenReceiver;

    public ScreenStatusListener(Context context) {
        this.mContext = context;
        mScreenReceiver = new ScreenBroadcastReceiver();
    }

    public void begin(ScreenStateListener listener) {
        this.mScreenStateListener = listener;
        registerReceiver();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mContext.registerReceiver(mScreenReceiver, filter);
    }

    interface ScreenStateListener {
        void onScreenOn();
        void onScreenOff();
    }

    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏
                mScreenStateListener.onScreenOn();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
                mScreenStateListener.onScreenOff();
            }
        }
    }
}
