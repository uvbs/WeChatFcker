package com.example.onlyb.bootservicetest.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.onlyb.bootservicetest.Service.BackgroundService;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Boot Broadcast Received", Toast.LENGTH_LONG).show();
        Log.d("Broadcast", "Boot Received");

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent service = new Intent(context, BackgroundService.class);
            context.startService(service);
            Toast.makeText(context, "Boot Success", Toast.LENGTH_LONG).show();
        }
    }
}
