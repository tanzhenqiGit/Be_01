/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-16
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-16 下午12:13:27
* @class AccelerometerActivity.java
*/ 
package com.example.contents.fifteen.sensor;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


/**
 * @author free
 *
 */
public class AccelerometerActivity extends Activity implements SensorEventListener {

	private final String TAG = "AccelerometerActivity";
	private SensorManager  mSensorManager;
	private TextView mEdittext;
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.d(TAG, "onResume");
		if (mSensorManager != null) {
			mSensorManager.registerListener(this, 
					mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
					SensorManager.SENSOR_DELAY_UI);
			
		}
		super.onResume();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		if (mSensorManager != null) {
			mSensorManager.unregisterListener(this);
		}
		
		super.onStop();
	}

	private void initialize()
	{
		mEdittext = (TextView) findViewById(R.id.common_view_main_text);
		if (mEdittext != null) {
			mEdittext.setVisibility(View.VISIBLE);
			mEdittext.setText("hello World");
		}
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	}
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
	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.d(TAG, "onSensorChanged");
		float[] values = event.values;
		StringBuilder sb = new StringBuilder();
		sb.append("X方向的加速度：");
		sb.append(values[0]);
		sb.append("\nY方向的加速度：");
		sb.append(values[1]);
		sb.append("\nZ方向的加速度：");
		sb.append(values[2]);
		if (mEdittext != null) {
			mEdittext.setText(sb.toString());
		}
		
	}
	/* (non-Javadoc)
	 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		Log.d(TAG,"onAccuracyChanged");
		
	}

}
