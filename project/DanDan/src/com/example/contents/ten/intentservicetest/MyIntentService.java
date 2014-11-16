package com.example.contents.ten.intentservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	public MyIntentService()
	{
		super("MyIntentService");
		Log.d(TAG, "MyIntentService is construct");
	}
	private final String TAG = "MyIntentService";
	@Override
	protected void onHandleIntent(Intent arg0) {
		Log.d(TAG,"onHandleIntent ");
		long endTime = System.currentTimeMillis() + 20 * 1000;
		Log.d(TAG, "start");
		while(System.currentTimeMillis() < endTime) {
			synchronized(this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Log.d(TAG,"time tast is compeleted");
	}
	@Override
	public void onCreate() {
		Log.d(TAG,"onCreate");
		super.onCreate();
	}
	@Override
	public void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}
	@Override
	public void onStart(Intent intent, int startId) {
		Log.d(TAG,"onStart startId=" + startId);
		super.onStart(intent, startId);
	}

}
