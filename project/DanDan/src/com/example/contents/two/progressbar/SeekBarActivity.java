/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç10:43:08.
*/ 
package com.example.contents.two.progressbar;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * @author Administrator
 *
 */
public class SeekBarActivity extends Activity {

	private final String TAG = "SeekBarActivity";
	private ImageView mImage;
	private SeekBar mSeekBar;
	
	
	@SuppressWarnings("deprecation")
	private void intialize()
	{
		mImage = (ImageView)findViewById(R.id.two_seekbar_main_imageview);
		if (mImage != null) {
			mImage.setAlpha(0);
		} else {
			Log.d(TAG, "mImage == null");
		}
		
		mSeekBar = (SeekBar)findViewById(R.id.two_seekbar_main_seekbar);
		
		if (mSeekBar != null) {
			mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					Log.d(TAG, "onStopTrackingTouch");
					
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					Log.d(TAG, "onStartTrackingTouch");
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					if (mImage != null) {
						mImage.setAlpha(progress);
					} else {
						Log.d(TAG, "mImage == null");
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_seekbar_main);
		intialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
