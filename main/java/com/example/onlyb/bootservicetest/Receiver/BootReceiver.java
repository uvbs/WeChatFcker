package com.example.onlyb.bootservicetest.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.onlyb.bootservicetest.Service.BackgroundService;

public class BootReceiver extends BroadcastReceiver {

    private static final String strBootCompleted = "android.intent.action.BOOT_COMPLETED";
    private static final String strBeingDestroyed = "com.example.onlyb.bootservicetest.destroy";//需要改成新包名

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Broadcast Received", Toast.LENGTH_LONG).show();
        Log.d("Broadcast", "Broadcast Received");

        if (intent.getAction().equals(strBootCompleted) || intent.getAction().equals(strBeingDestroyed)) {
            Log.d("Broadcast", intent.getAction());
            Intent service = new Intent(context, BackgroundService.class);
            context.startService(service);
            Toast.makeText(context, "restart Success", Toast.LENGTH_LONG).show();
        }
    }
}
