package com.example.zbh.wechatfucker;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;


/**
 * Created by zbh on 2017/9/5.
 */
public class MyAccessibilityActivity extends AccessibilityService {
    private static final String TAG = "MyAccessibilityActivity";
    @SuppressLint("NewApi")  
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event){
        int eventType = event.getEventType();  
        String eventText = "";  
        Log.i(TAG, "==============Start====================");  
        switch (eventType) {  
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                eventText = "TYPE_VIEW_CLICKED";
                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                eventText = "TYPE_VIEW_LONG_CLICKED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                eventText = "TYPE_WINDOW_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
                break;
//            case AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE:
//                eventText = "CONTENT_CHANGE_TYPE_SUBTREE";
//                break;
        }  
        Log.i(TAG, eventText);  
        Log.i(TAG, "=============END=====================");  
    }
    @Override
    public void onInterrupt(){}
}
