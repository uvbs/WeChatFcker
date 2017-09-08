package com.example.onlyb.bootservicetest.KeepAlive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by onlyb on 2017/9/7.
 */

public class KeepAliveManager {

    private static KeepAliveManager instance;
    private Context mContext;
    private Activity mKeepAliveActivity;

    public KeepAliveManager(Context context) {
        this.mContext = context;
    }

    public static KeepAliveManager getInstance(Context context) {
        if (instance == null) {
            instance = new KeepAliveManager(context.getApplicationContext());
        }
        return instance;
    }

    public void setKeepAliveActivity(Activity keepAliveActivity) {
        this.mKeepAliveActivity = keepAliveActivity;
        Log.d("KeepAlive", "setKeepAliveActivity -> 1");
    }

    public void finishKeepAliveActivity() {
        mKeepAliveActivity.finish();
        Log.d("KeepAlive", "finishKeepActivity -> 1");
    }

    public void startKeepAliveActivity() {
        Intent intent = new Intent(mContext, KeepAliveActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
        Log.d("KeepAlive", "startKeepAliveActivity -> 1");
    }
}

