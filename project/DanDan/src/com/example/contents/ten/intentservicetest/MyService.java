package com.example.contents.ten.intentservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private final String TAG = "Myservice";
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(TAG, "onBind");
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand flags=" + flags + ",startId" + startId);
		long endTime = System.currentTimeMillis() + 20 * 1000;
		
		while(System.currentTimeMillis() < endTime) {
			synchronized(this)
			{
				try {
					Log.d(TAG, "wait time tast");
					wait(endTime - System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		Log.d(TAG, "wait time tast is compeleted");
		return START_STICKY;
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
	@SuppressWarnings("deprecation")
	@Override
	public void onStart(Intent intent, int startId) {
		Log.d(TAG,"onStart");
		super.onStart(intent, startId);
	}

}
