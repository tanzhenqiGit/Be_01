/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-7 ÉÏÎç8:44:16.
*/ 
package com.example.contents.two.progressbar;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

/**
 * @author Administrator
 *
 */
public class RatingBarActivity extends Activity {
	private final String TAG = "RatingBarActivity";
	private ImageView mImage;
	private RatingBar mBar;
	
	@SuppressLint("NewApi")
	private void initialize()
	{
		mImage = (ImageView)findViewById(R.id.two_ratingbar_main_image);
		
		mBar = (RatingBar)findViewById(R.id.two_ratingbar_main_bar);
		if (mBar != null) {
			mBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
				
				@Override
				public void onRatingChanged(RatingBar ratingBar, float rating,
						boolean fromUser) {
					Log.d(TAG,"onRatingChanged rating=" + rating);
					if (mImage != null) {
						mImage.setAlpha(rating / 5);
					} else {
						Log.d(TAG, "mImage == null");
					}
				}
			});
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_ratingbar_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

}
