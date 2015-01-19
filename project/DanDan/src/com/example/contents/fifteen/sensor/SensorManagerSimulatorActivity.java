/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-16
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-16 下午2:49:22
* @class SenorManagerSimulator.java
*/ 
package com.example.contents.fifteen.sensor;

import org.openintents.sensorsimulator.hardware.SensorEvent;
import org.openintents.sensorsimulator.hardware.SensorEventListener;
import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dandan.R;

/**
 * @author free
 *
 */
public class SensorManagerSimulatorActivity extends Activity {

	private final String TAG = "SenorManagerSimulator";
	private SensorManagerSimulator mSensorManagerSimulator;
	private TextView mEdittext;
	private SensorEventListener mListener;
	
	class SensorListener implements SensorEventListener
	{

		/* (non-Javadoc)
		 * @see org.openintents.sensorsimulator.hardware.SensorEventListener#onAccuracyChanged(org.openintents.sensorsimulator.hardware.Sensor, int)
		 */
		@Override
		public void onAccuracyChanged(
				org.openintents.sensorsimulator.hardware.Sensor arg0, int arg1) {
			Log.d(TAG, "SensorListener onAccuracyChanged");
			
		}

		/* (non-Javadoc)
		 * @see org.openintents.sensorsimulator.hardware.SensorEventListener#onSensorChanged(org.openintents.sensorsimulator.hardware.SensorEvent)
		 */
		@Override
		public void onSensorChanged(SensorEvent arg0) {
			// TODO Auto-generated method stub
			Log.d(TAG, "SensorListener onSensorChanged");
			float[] values = arg0.values;
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
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume registerListener.");
		if (mSensorManagerSimulator != null) {
			mSensorManagerSimulator.registerListener(mListener, 
					mSensorManagerSimulator.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
					SensorManager.SENSOR_DELAY_GAME);
			
		} else {
			Log.e(TAG, "onResume mSensorManagerSimulator == null");
		}
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.d(TAG, "onStop unregisterListener");
		if (mSensorManagerSimulator != null) {
			mSensorManagerSimulator.disconnectSimulator();
			mSensorManagerSimulator.unregisterListener(mListener);
		} else {
			Log.e(TAG, "onStop mSensorManagerSimulator == null");
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
		mSensorManagerSimulator = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
		mListener = new SensorListener();
		new Thread()
		{
			@Override
			public void run() {
				if (mSensorManagerSimulator != null) {
					mSensorManagerSimulator.connectSimulator();
					//mSensorManagerSimulator.
					Log.d(TAG, "initialize connect Simulator");
				}
			};
		}.start();
	
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

	
}

