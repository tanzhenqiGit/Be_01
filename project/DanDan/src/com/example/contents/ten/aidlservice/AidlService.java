package com.example.contents.ten.aidlservice;

import java.util.Timer;
import java.util.TimerTask;

import com.example.contents.ten.aidlservice.ICat.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlService extends Service {

	private final String TAG = "AidlService";
	private CatBinder mCatBinder;
	private Timer mTimer = new Timer();
	private String[] mColors = new String[] {
			"red",
			"yellow",
			"black"
	};
	
	private double [] mWeights = new double[] {
			2.3,
			3.1,
			1.57
	};
	private String mColor;
	private double mWeight;
	public class CatBinder extends Stub
	{

		@Override
		public String getColor() throws RemoteException {
			Log.d(TAG, "CatBinder getColor");
			return mColor;
		}

		@Override
		public double getWeight() throws RemoteException {
			Log.d(TAG,"CatBinder getWeight");
			return mWeight;
		}
		
	}
	
	
	private void initializedService()
	{
		mCatBinder = new CatBinder();
		mTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				int rand = (int)(Math.random() * 3);
				mColor = mColors[rand];
				mWeight = mWeights[rand];
				Log.d(TAG,"rand:" + rand);
			}
		}, 0, 800);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "AidlService");
		return mCatBinder;
	}
	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
		initializedService();
	}
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
		mTimer.cancel();
		Log.d(TAG, "mTimer is cancel");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand flags="+ flags + ",startId=" + startId);
		return super.onStartCommand(intent, flags, startId);
	}

}
