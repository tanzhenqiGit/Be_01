/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÏÂÎç4:15:41
* @class ProximityAlertReciever.java
*/ 
package com.example.contents.sixteen.proximity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

/**
 * @author free
 *
 */
public class ProximityAlertReciever extends BroadcastReceiver
{

	private final String TAG = "ProximityAlertReciever";
	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceiver ^^");
		
		boolean isEnter = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING,
				false);
		if (isEnter) {
			Toast.makeText(context, "inter (xxx.xxx)", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context, "exit (xxx.xxx)", Toast.LENGTH_LONG).show();
		}
		
	}

}
