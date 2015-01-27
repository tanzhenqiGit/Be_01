/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÏÂÎç1:09:19
* @class EightContentsActivity.java
*/ 
package com.example.contents.eight;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.eight.sharedpreferences.SharedPreferencesActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class EightContentsActivity extends CommonListActivity<String>
{

	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position)
		{
		case SHARED_PREFERENCES:
			Intent shared_preferences = new Intent(EightContentsActivity.this,
					SharedPreferencesActivity.class);
			startActivity(shared_preferences);
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
		String[] constents = getResources().getStringArray(R.array.chapterEightContents);
		prepareContents(constents);
	}

	public final int SHARED_PREFERENCES = 0;
}
