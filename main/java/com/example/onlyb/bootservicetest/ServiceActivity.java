package com.example.onlyb.bootservicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlyb.bootservicetest.KeepAlive.KeepAliveActivity;
import com.example.onlyb.bootservicetest.KeepAlive.ScreenStatusService;
import com.example.onlyb.bootservicetest.Service.BackgroundService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button startService = (Button) findViewById(R.id.start_service);
        Button stopService = (Button) findViewById(R.id.stop_service);
        Button testOnepixel = (Button) findViewById(R.id.test_onepixel);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        testOnepixel.setOnClickListener(this);

        Intent intent = new Intent(this, ScreenStatusService.class);
        startService(intent);
        Log.d("KeepAlive", "Keep-Alive Service Started");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent startIntent = new Intent(this, BackgroundService.class);
                startService(startIntent);
                Log.d("Service", "Service Started");
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, BackgroundService.class);
                stopService(stopIntent);
                Log.d("Service", "Service Stopped");
                break;
            case R.id.test_onepixel:
                //Intent intent = new Intent(this, ScreenStatusService.class);
                //startService(intent);
                //Log.d("KeepAlive", "Keep-Alive Service Started");
                //Intent intent = new Intent(this, KeepAliveActivity.class);
                //startActivity(intent);
                //Log.d("KeepAlive", "Initialled");
                //finish();
                //Log.d("KeepAlive", "FFFFinished");
                break;
            default:
                break;
        }
    }
}
