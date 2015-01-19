/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-19
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-19 ÏÂÎç4:12:01
* @class GradienterActivity.java
*/ 
package com.example.contents.fifteen.Gradienter;

import com.example.dandan.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @author free
 *
 */
public class GradienterActivity extends Activity implements SensorEventListener {

	
	private final String TAG = "GradienterActivity";
	private final int MAX_ANGLE = 30;
	private SensorManager mSensorManager;
	private MyView mShow;
	
	
	private void initialize()
	{
		mShow = (MyView) findViewById(R.id.fifteen_grandienter_main_view);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifteen_gradienter_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void onResume() {
		Log.d(TAG, "onResume");
		super.onResume();
		if (mSensorManager != null) {
			mSensorManager.registerListener(this, 
					mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
					SensorManager.SENSOR_DELAY_UI);
		} else {
			Log.d(TAG, "onResume mSensorManager == null");
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		if (mSensorManager != null) {
			mSensorManager.unregisterListener(this);
		} else {
			Log.d(TAG, "onStop unregisterListener");
		}
		super.onStop();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {		
		Log.d(TAG, "onPause");
		super.onPause();
		if (mSensorManager != null) {
			mSensorManager.unregisterListener(this);
		} else {
			Log.d(TAG,"onPause mSensorManager == null");
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	/* (non-Javadoc)
	 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.d(TAG, "onSensorChanged");
		float [] values = event.values;
		int sensorType = event.sensor.getType();
		switch (sensorType) {
		case Sensor.TYPE_ORIENTATION:
			//float zAngle = values[0];
			float yAngle = values[1];
			float xAngle = values[2];
			//
			int x = (mShow.mBackground.getWidth() - mShow.mBubble.getWidth()) / 2;
			int y = (mShow.mBackground.getHeight() - mShow.mBubble.getHeight()) / 2;
			
			if (Math.abs(xAngle) <= MAX_ANGLE) {
				int offset = (int) ((mShow.getWidth() - mShow.mBubble.getWidth()) / 2 * xAngle / MAX_ANGLE);
				x += offset;
			} else if (xAngle > MAX_ANGLE) {
				x = 0;
			} else {
				x = mShow.mBackground.getWidth() - mShow.mBubble.getWidth();
			}
			
			
			if (Math.abs(yAngle) <= MAX_ANGLE)
			{
				int offset = (int) ((mShow.mBackground.getHeight() - mShow.mBubble.getHeight()) / 2 * yAngle / MAX_ANGLE);
				y += offset;
			} else if (yAngle > MAX_ANGLE) {
				y = mShow.mBackground.getHeight() - mShow.mBubble.getHeight();
			} else {
				y = 0;
			}
			
			if (isContain(x, y)) {
				mShow.mBubbleX = x;
				mShow.mBubbleY = y;
			}
			
			mShow.postInvalidate();
			break;
		default:
			
			break;
		}
		
	}
	/* (non-Javadoc)
	 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		Log.d(TAG, "onAccuracyChanged");
	}
	
	private boolean isContain(int x, int y)
	{
		int bubbleCx = x + mShow.mBubble.getWidth() / 2;
		int bubbleCy = y + mShow.mBubble.getHeight() / 2;
		
		int backCx = mShow.mBackground.getWidth() / 2;
		int backCy = mShow.mBackground.getHeight() / 2;
		
		double distance = Math.sqrt((bubbleCx - backCx) * (bubbleCx - backCx)
				+ (bubbleCy - backCy) * (bubbleCy - backCy));
		
		if (distance < (mShow.mBackground.getWidth() - mShow.mBubble.getWidth()) / 2)
		{
			return true;
		}
		
		return false;
	}

}
