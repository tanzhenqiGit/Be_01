/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç8:53:11.
*/ 
package com.example.contents.two.progressbar;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * @author Administrator
 *
 */
@SuppressLint("HandlerLeak")
public class ProgressBarActivity extends Activity {

	private final String TAG = "ProgressBarActivity";
	public final int MSG_PROGRESS_CHANGED = 0x111;
	private int[] mData = new int[100];
	private int mHasData = 0;
	private int mProgressSts = 0;
	private ProgressBar mBar1, mBar2;
	
	
	@SuppressLint("HandlerLeak")
	public Handler mHalder = new Handler()
	{

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_PROGRESS_CHANGED) {
				if (mBar1 != null) {
					mBar1.setProgress(mProgressSts);
				}
				if (mBar2 != null) {
					mBar2.setProgress(mProgressSts);
				}
			}
		}
		
	};
	
	private int doJob()
	{
		mData[mHasData++] = (int)(Math.random()) * 100;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(TAG,"mHasData = " + mHasData);
		return mHasData;
	}
	
	private void initialize()
	{
		mBar1 = (ProgressBar)findViewById(R.id.two_progress_bar_main_bar);
		mBar2 = (ProgressBar)findViewById(R.id.two_progress_bar_main_bar2);
		new Thread()
		{

			@Override
			public void run() {
				while(mProgressSts < 100) {
					mProgressSts = doJob();
					Log.d(TAG, "mProgressSts=" + mProgressSts);
					mHalder.sendEmptyMessage(MSG_PROGRESS_CHANGED);
				}
				super.run();
			}
			
		}.start();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_progress_bar_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

}
