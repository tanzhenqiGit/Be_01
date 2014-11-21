package com.example.contents.ten.changewallpaper;


import com.example.dandan.R;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ChangeWallPaperService extends Service {
	private final String TAG = "ChangeWallPaperService";

    int [] mWallPapers = new int [] {
		R.drawable.shuangta,
		R.drawable.lijiang,
		R.drawable.qiao,
		R.drawable.shui
	};
	
	WallpaperManager mWallManager;
	private int mCurrrentIndex = 0;
	
	private void initialize()
	{
		mWallManager = WallpaperManager.getInstance(this);
	}
	
	private void OnStartIsCalled()
	{
		if(mCurrrentIndex >= 4) {
			mCurrrentIndex = 0;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return null;
	}
	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
		initialize();
	}
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		Log.d(TAG, "onStart startId=" + startId);
		super.onStart(intent, startId);
		OnStartIsCalled();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand flags="+flags + ",startId=" + startId);
		return super.onStartCommand(intent, flags, startId);
	}

}
