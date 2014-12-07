/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-7 ÏÂÎç9:25:10.
*/ 
package com.example.contents.two.viewanimator;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * @author Administrator
 *
 */
public class ViewFlipperActivity extends Activity {

	private final String TAG =  "ViewFlipperActivity";
	private ViewFlipper mViewFlipper;
	
	
	private void initialize()
	{
		mViewFlipper = (ViewFlipper)findViewById(R.id.two_viewflipper_activity_main_flipper);
		if (mViewFlipper == null) {
			Log.d(TAG, "mViewFlipper == null");
		}
	}
	
	public void OnPrevBtnCalled(View source)
	{
		if (mViewFlipper != null) {
			mViewFlipper.setInAnimation(this, R.animator.slide_in_right);
			mViewFlipper.setInAnimation(this, R.animator.slide_out_left);
			mViewFlipper.showPrevious();
		}
	}
	
	public void OnAutoPlayCalled(View source)
	{
		mViewFlipper.setInAnimation(this, R.animator.slide_in_right);
		mViewFlipper.setInAnimation(this, R.animator.slide_out_left);
		if (mViewFlipper.isFlipping()) {
			mViewFlipper.stopFlipping();
		} else {
			mViewFlipper.startFlipping();
		}
	}
	
	public void OnNextBtnCalled(View source)
	{
		mViewFlipper.setInAnimation(this, R.animator.slide_in_right);
		mViewFlipper.setInAnimation(this, R.animator.slide_out_left);
		mViewFlipper.showNext();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_viewflipper_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
