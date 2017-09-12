package com.example.onlyb.bootservicetest.KeepAlive;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.onlyb.bootservicetest.R;

public class KeepAliveActivity extends Activity {

    public static boolean isKeepAliveRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("KeepAlive", "KeepAliveActivity -> onCreated");
        //生成1像素活动
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = 1;
        params.height = 1;
        window.setAttributes(params);

        KeepAliveManager.getInstance(this).setKeepAliveActivity(this);
        isKeepAliveRunning = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("KeepAlive", "KeepAliveActivity -> onDestroyed");
    }
}
