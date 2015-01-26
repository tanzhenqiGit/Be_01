/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÏÂÎç2:26:07
* @class AllProvidersActivity.java
*/ 
package com.example.contents.sixteen.provider;

import java.util.List;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author free
 *
 */
public class AllProvidersActivity extends Activity {

	private final String TAG = "AllProvidersActivity";
	private ListView mList;
	LocationManager mLocalMgr;
	
	private void initialize()
	{
		mLocalMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria cri = new Criteria();
		cri.setCostAllowed(false);
		cri.setAltitudeRequired(true);
		cri.setBearingRequired(true);
		
		List<String> providerNames = mLocalMgr.getAllProviders();
		Log.d(TAG, "initialize list size="+ providerNames.size());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1,
				providerNames);
				
		mList = (ListView) findViewById(R.id.listView);
		if (mList != null) {
			mList.setAdapter(adapter);
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

}
