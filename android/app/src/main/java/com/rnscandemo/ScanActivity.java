package com.rnscandemo;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private static final String TAG = "ScanActivity";

    public static Promise promise = null;
    public static Callback callback = null;
    ZXingView zXingView = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        zXingView = findViewById(R.id.zXingView);
        zXingView.setDelegate(this);
    }

    @Override
    protected void onStart() {
        zXingView.startCamera();
        zXingView.startSpotAndShowRect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        zXingView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zXingView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();
      Log.i(TAG, "result=" + result);
      promise.resolve(result);
//      callback.invoke(result);
      this.finish();
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
        // TODO:環境が暗くなったらの対応
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        // TODO:カメラ起動異常
        // 1.システムエラー
        // 2.権限
    }
}
