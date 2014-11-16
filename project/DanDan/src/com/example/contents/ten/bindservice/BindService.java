package com.example.contents.ten.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {

	private final String TAG = "BindService";
	private int mCount = 0;
	private boolean mQuit = false;
	private MyBinder mBinder = new MyBinder();
	public class MyBinder extends Binder
	{
		public int getCount()
		{
			Log.d(TAG,"MyBinder::getCount() return mCount = " + mCount);
			return mCount;
		}
	}
	
	private void HandlerOnServiceOnCreate()
	{
		mQuit = false;
		new Thread()
		{
			@Override
			public void run() 
			{
				while(!mQuit) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mCount++;
				}
			};
		}.start();
	}
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return mBinder;
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
		HandlerOnServiceOnCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mQuit = true;
		Log.d(TAG,"onDestroy");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "onUnbind");
		return true;
	}

}
