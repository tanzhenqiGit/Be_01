/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÏÂÎç4:07:14
* @class ProximityActivity.java
*/ 
package com.example.contents.sixteen.proximity;

import com.example.dandan.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @author free
 *
 */
public class ProximityActivity extends Activity {

	private final String TAG = "ProximityActivity";
	private final double mLongitude = 113.39;
	private final double mLatitude = 23.13;
	private final float mRadius = 50000;
	private LocationManager mLocationMgr;
	
	private void initialize()
	{
		mLocationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Intent intent = new Intent(ProximityActivity.this, ProximityAlertReciever.class);
		PendingIntent pi = PendingIntent.getBroadcast(ProximityActivity.this, -1, intent, 0);
		if (mLocationMgr != null) {
			mLocationMgr.addProximityAlert(mLatitude, mLongitude, mRadius, -1, pi);
			Log.d(TAG, "initialize end mLatitude=" + mLatitude 
					+ "mLongitude=" + mLongitude 
					+ "mRadius=" + mRadius);
		}
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

}
