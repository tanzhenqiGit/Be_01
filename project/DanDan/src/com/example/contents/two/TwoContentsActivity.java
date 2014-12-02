/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÏÂÎç1:22:44
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-2 ÏÂÎç1:22:44 
* class declare 
*/ 
package com.example.contents.two;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.two.toggle.ToggleButtonActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class TwoContentsActivity extends CommonListActivity<String> {

	private final String TAG = "TwoContentsActivity";
	private final int TOGGLE_BUTTON = 0;

	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch(position) {
		case TOGGLE_BUTTON:
			Intent toggle_button_intent 
				= new Intent(TwoContentsActivity.this, ToggleButtonActivity.class);
			startActivity(toggle_button_intent);
			break;
		case 1:
			Log.d(TAG, "1 position="+position);
			break;
		default:
			Log.d(TAG, "2 position="+position);
			break;
		}
		
	}

	@Override
	public void onPrepareContents() {
		String[] contents = getResources().getStringArray(R.array.chapterTwoContents);
		super.prepareContents(contents);
	}

}
