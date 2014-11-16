package com.example.contents.ten.firstService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	private String TAG = "FirstService";
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(TAG, "OnBind is called");
		return null;
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand flags=" + flags + ",startId=" + startId);
		return super.onStartCommand(intent, flags, startId);
	}

	
}
