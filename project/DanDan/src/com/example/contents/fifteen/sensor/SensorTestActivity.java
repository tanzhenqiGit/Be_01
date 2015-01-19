/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-19
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-19 ÏÂÎç2:16:23
* @class SensorTestActivity.java
*/ 
package com.example.contents.fifteen.sensor;

import com.example.dandan.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class SensorTestActivity extends Activity {

	private final String TAG = "SensorTestActivity";
	private EditText mOrientationTxt, mMagneticTxt, mTemperatureTxt, mLightTxt, mPressureTxt;
	private SensorManager mSensorManager;
    private SensorListener mListener;
	
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
			
			mSensorManager.registerListener(mListener, 
					mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
					SensorManager.SENSOR_DELAY_UI);
			
			mSensorManager.registerListener(mListener, 
					mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE),
					SensorManager.SENSOR_DELAY_UI);
			
			mSensorManager.registerListener(mListener,
					mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
					SensorManager.SENSOR_DELAY_UI);
			
			mSensorManager.registerListener(mListener, 
					mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), 
					SensorManager.SENSOR_DELAY_UI);
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		if (mSensorManager != null) {
			mSensorManager.unregisterListener(mListener);
		}
		super.onStop();
	}
    
	 
	private class SensorListener implements SensorEventListener
	{
		/* (non-Javadoc)
		 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
		 */
		@SuppressWarnings("deprecation")
		@Override
		public void onSensorChanged(SensorEvent event) {
			float[] values = event.values;
			int sensorType = event.sensor.getType();
			StringBuilder sb = null;
			Log.d(TAG, "onSensorChanged sensor type = " + sensorType);
			
			switch (sensorType) {
			case Sensor.TYPE_ORIENTATION:
				sb = new StringBuilder();
				sb.append("orientation Z:");
				sb.append(values[0]);
				sb.append("\norientation X:");
				sb.append(values[1]);
				sb.append("\norientation Y:");
				sb.append(values[2]);
				if (mOrientationTxt != null) {
					mOrientationTxt.setText(sb.toString());
				}
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				sb = new StringBuilder();
				sb.append("magnetic X:");
				sb.append(values[0]);
				sb.append("\nmagnetic Y:");
				sb.append(values[1]);
				sb.append("\nmagnetic Z:");
				sb.append(values[2]);
				if (mMagneticTxt != null) {
					mMagneticTxt.setText(sb.toString());
				}
				break;
			
			case Sensor.TYPE_TEMPERATURE:
				sb = new StringBuilder();
				sb.append("temperture:");
				sb.append(values[0]);
				if (mTemperatureTxt != null) {
					mTemperatureTxt.setText(sb.toString());
				}
				break;
			case Sensor.TYPE_LIGHT:
				sb = new StringBuilder();
				sb.append("light:");
				sb.append(values[0]);
				if (mLightTxt != null) {
					mLightTxt.setText(sb.toString());
				}
				break;
			case Sensor.TYPE_PRESSURE:
				sb = new StringBuilder();
				sb.append("presure:");
				sb.append(values[0]);
				if (mPressureTxt != null) {
					mPressureTxt.setText(sb.toString());
				}
				
				break;
			default:
				Log.d(TAG, "default case do noting sensorType" + sensorType);
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
		
	};
	
	private void initialize()
	{
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mListener = new SensorListener();
		
		mOrientationTxt = (EditText) findViewById(R.id.fourteen_sensor_orientation);
		mMagneticTxt = (EditText) findViewById(R.id.fourteen_sensor_magnetic);
		mTemperatureTxt = (EditText) findViewById(R.id.fourteen_sensor_temperature);
		mLightTxt = (EditText) findViewById(R.id.fourteen_sensor_light);
		mPressureTxt = (EditText) findViewById(R.id.fourteen_sensor_pressure);
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourteen_sensor_test_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestory");
		super.onDestroy();
	}

}
