/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 下午3:31:36
* @class LocationActivity.java
*/ 
package com.example.contents.sixteen.location;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class LocationActivity extends Activity {

	private final String TAG = "LocationActivity";
	private TextView mShowTxt;
	
	private LocationManager mLocationMgr;
	
	private void updateView(Location newLocation)
	{
		if (newLocation != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("实时的位置信息：\n");
			sb.append("经度：");
			sb.append(newLocation.getLongitude());
			sb.append("\n纬度：");
			sb.append(newLocation.getLatitude());
			sb.append("\n高度：");
			sb.append(newLocation.getAltitude());
			sb.append("\n速度");
			sb.append(newLocation.getSpeed());
			sb.append("\n方向：");
			sb.append(newLocation.getBearing());
			if (mShowTxt != null) {
				mShowTxt.setText(sb.toString());
			}
		} else {
			if (mShowTxt != null) {
				mShowTxt.setText("");
			}
		}
	}
	
	
	private void initialize()
	{
		Log.d(TAG, "initialize() is called");
		mShowTxt = (TextView) findViewById(R.id.sixteen_location_main_txt);
		mLocationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		if (mLocationMgr != null) {
			Location location = mLocationMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			updateView(location);
			mLocationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 8, new LocationListener() {
				
				@Override
				public void onStatusChanged(String provider, int status, Bundle extras) {
					Log.d(TAG, "onStatusChanged status=" + status + ",provider=" + provider);
				}
				
				@Override
				public void onProviderEnabled(String provider) {
					Log.d(TAG, "onProviderEnabled provider=" + provider);
					updateView(mLocationMgr.getLastKnownLocation(provider));					
				}
				
				@Override
				public void onProviderDisabled(String provider) {
					Log.d(TAG, "onProviderDisabled is called");
					updateView(null);
					
				}
				
				@Override
				public void onLocationChanged(Location location) {
					Log.d(TAG, "onLocationChanged");
					updateView(location);
					
				}
			});
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixteen_location_main);
		initialize();
	}
	

}
