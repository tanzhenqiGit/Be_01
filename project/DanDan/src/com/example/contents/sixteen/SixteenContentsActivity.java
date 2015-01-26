/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÏÂÎç1:57:49
* @class SixContentsActivity.java
*/ 
package com.example.contents.sixteen;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.sixteen.location.LocationActivity;
import com.example.contents.sixteen.provider.AllProvidersActivity;
import com.example.contents.sixteen.proximity.ProximityActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class SixteenContentsActivity extends CommonListActivity<String>
{
	private final String TAG = "SixContentsActivity";
	
	private final int ALL_PROVIDERS = 0;
	private final int LOCATION = 1;
	private final int PROXIMITY_ALERT = 2;
	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position)
		{
		case ALL_PROVIDERS:
			Intent all_providers = new Intent(SixteenContentsActivity.this, 
					AllProvidersActivity.class);
			startActivity(all_providers);
			break;
		case LOCATION:
			Intent location = new Intent(SixteenContentsActivity.this, 
					LocationActivity.class);
			startActivity(location);
			break;
		case PROXIMITY_ALERT:
			Intent Proximity_Alert = new Intent(SixteenContentsActivity.this, 
					ProximityActivity.class);
			startActivity(Proximity_Alert);
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
		Log.d(TAG, "onPrePareContents");
		String[] contents = getResources().getStringArray(R.array.chapterSixteenContents);
		prepareContents(contents);
	}

}
