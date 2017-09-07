package com.example.zbh.wechatfucker;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by zbh on 2017/9/5.
 */
public class DetectionService extends AccessibilityService {
    private static volatile String foregroundPackageName = "error";

    public static boolean isForeground(String packagenName) {
        return foregroundPackageName.equals(packagenName); }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            foregroundPackageName = event.getPackageName().toString();
        }
    }
    @Override
    public void onInterrupt() { }
}