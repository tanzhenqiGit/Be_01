/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-16
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-16 ÉÏÎç11:57:11
* @class FifteenContentsActivity.java
*/ 
package com.example.contents.fifteen;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.fifteen.compass.CompassActivity;
import com.example.contents.fifteen.sensor.AccelerometerActivity;
import com.example.contents.fifteen.sensor.SensorManagerSimulatorActivity;
import com.example.contents.fifteen.sensor.SensorTestActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class FifteenContentsActivity extends CommonListActivity<String> {

	private final int SENSOR_MANAGER = 0;
	private final int SENSOR_MANAGER_EMULATOR = 1;
	private final int SENSOR_MANAGER_TEST = 2;
	private final int COMPASSS = 3;
	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position) {
		case SENSOR_MANAGER:
			Intent sensor_manager = new Intent(FifteenContentsActivity.this,
					AccelerometerActivity.class);
			startActivity(sensor_manager);
			break;
		case SENSOR_MANAGER_EMULATOR:
			Intent sensor_manager_emulator = new Intent(FifteenContentsActivity.this,
					SensorManagerSimulatorActivity.class);
			startActivity(sensor_manager_emulator);
			break;
		case SENSOR_MANAGER_TEST:
			Intent sensor_manager_test = new Intent(FifteenContentsActivity.this,
					SensorTestActivity.class);
			startActivity(sensor_manager_test);
			break;
		case COMPASSS:
			Intent compass = new Intent(FifteenContentsActivity.this,
					CompassActivity.class);
			startActivity(compass);
			break;
		default:
			
			break;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#onPrepareContents()
	 */
	@Override
	public void onPrepareContents() {
		String [] contents = getResources().getStringArray(R.array.chapterFifteenContents);
		prepareContents(contents);
	}

}
