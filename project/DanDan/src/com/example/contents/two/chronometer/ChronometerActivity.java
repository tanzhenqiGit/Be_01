/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÉÏÎç9:18:52
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-3 ÉÏÎç9:18:52 
* class declare 
*/ 
package com.example.contents.two.chronometer;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

/**
 * @author free
 *
 */

public class ChronometerActivity extends Activity {

	private final String TAG = "ChronometerActivity";
	private Chronometer mCh;
	private Button mStartBtn;
	
	private void initialize()
	{
		mCh = (Chronometer)findViewById(R.id.two_chronometer_activity_main_chronometer);
		mStartBtn = (Button)findViewById(R.id.two_chronometer_activity_main_start_btn);
		if (mStartBtn != null) {
			mStartBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mCh != null) {
						mCh.setBase(SystemClock.elapsedRealtime());
						mCh.start();
					}
					
				}
			});
		}
		
		if (mCh != null) {
			mCh.setOnChronometerTickListener(new OnChronometerTickListener() {
				
				@Override
				public void onChronometerTick(Chronometer chronometer) {
					Log.d(TAG, "onChronometerTick is called format:" + chronometer.getFormat());
					if (SystemClock.elapsedRealtime() - mCh.getBase() > 20 * 1000) {
						mCh.stop();
					}
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_chronometer_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
