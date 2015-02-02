/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-2-2
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-2-2 ÉÏÎç10:47:28
* @class GestureTest.java
*/ 
package com.example.contents.eight.gesture;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @author free
 *
 */
public class GestureTest extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mGD != null) {
			mGD.onTouchEvent(event);
		}
		return super.onTouchEvent(event);
	}

	private void initialize()
	{
		mGD = new GestureDetector(GestureTest.this, new GestureDetector.OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				Log.d(TAG, "[ onSingleTapUp ]");				
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				Log.d(TAG, "[ onShowPress ] ");				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {
				Log.d(TAG, "[ onScroll ] ");				
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				Log.d(TAG, "[ onLongPress ] ");				
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				Log.d(TAG, "[ onFling ] ");				
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {
				Log.d(TAG, "[ onDown ] ");				
				return false;
			}
		});
	}
	
	
	private final String TAG = "GestureTest";
	private GestureDetector mGD;
	
}
