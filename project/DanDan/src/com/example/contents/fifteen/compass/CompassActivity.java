/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-19
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-19 ÏÂÎç3:21:41
* @class CompassActivity.java
*/ 
package com.example.contents.fifteen.compass;

import com.example.dandan.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * @author free
 *
 */
public class CompassActivity extends Activity {

	
	private final String TAG = "CompassActivity";
	private ImageView mImageView;
	private SensorManager mSensorManager;
	private SensorListener mListener;
	private float mCurDegree = 0f;
	
	private class SensorListener implements SensorEventListener
	{

		/* (non-Javadoc)
		 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
		 */
		@Override
		public void onSensorChanged(SensorEvent event) {
			int sensorType = event.sensor.getType();
			if (sensorType == Sensor.TYPE_ORIENTATION) {
				float degree = event.values[0];
				RotateAnimation ra = new RotateAnimation(mCurDegree, 
						-degree,
						Animation.RELATIVE_TO_SELF,
						0.5f, 
						Animation.RELATIVE_TO_SELF, 
						0.5f);
				ra.setDuration(200);
				if (mImageView != null) {
					mImageView.startAnimation(ra);
				}
				mCurDegree =- degree;
			}
			
		}

		/* (non-Javadoc)
		 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
		 */
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	private void initialize()
	{
		mImageView = (ImageView) findViewById(R.id.fifteen_compass_main_image);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mListener = new SensorListener();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifteen_compass_main);
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
		if (mSensorManager != null && mListener != null) {
			mSensorManager.registerListener(mListener,
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
		if (mSensorManager != null && mListener != null)
		{
			mSensorManager.unregisterListener(mListener);
		}
		super.onStop();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
	
}
