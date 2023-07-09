package com.rnscandemo;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ScanModule extends ReactContextBaseJavaModule {
    public ScanModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @NonNull
    @Override
    public String getName() {
        return "Scan";
    }
    // promiseのタイプ
    @ReactMethod
    public void startScan(Promise promise) {
        Activity activity = getCurrentActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        ScanActivity.promise = promise;
        Intent intent = new Intent(activity, ScanActivity.class);
        activity.startActivity(intent);
    }

    // callbackのタイプ
    @ReactMethod
    public void startScan2(Callback callback) {
        Activity activity = getCurrentActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        ScanActivity.callback = callback;
        Intent intent = new Intent(activity, ScanActivity.class);
        activity.startActivity(intent);
    }
}
