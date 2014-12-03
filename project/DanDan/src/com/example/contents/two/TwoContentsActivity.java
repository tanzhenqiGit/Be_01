/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014����1:22:44
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time ��2014-12-2 ����1:22:44 
* class declare 
*/ 
package com.example.contents.two;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.two.chronometer.ChronometerActivity;
import com.example.contents.two.imageview.ImageViewActivity;
import com.example.contents.two.listactivity.MyListActivity;
import com.example.contents.two.simpleadapter.SimpleAdapterTest;
import com.example.contents.two.toggle.ToggleButtonActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class TwoContentsActivity extends CommonListActivity<String> {

	private final String TAG = "TwoContentsActivity";
	private final int TOGGLE_BUTTON = 0;
	private final int CHRONOMETER = 1;
	private final int IMAGEVIEW = 2;
	private final int LIST_ACTIVITY = 3;
	private final int SIMPLEADAPTER = 4;
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch(position) {
		case TOGGLE_BUTTON:
			Intent toggle_button_intent 
				= new Intent(TwoContentsActivity.this, ToggleButtonActivity.class);
			startActivity(toggle_button_intent);
			break;
		case CHRONOMETER:
			Intent chronometer_intent 
				= new Intent(TwoContentsActivity.this, ChronometerActivity.class);
			startActivity(chronometer_intent);
			break;
		case IMAGEVIEW:
			Intent imageview_intent 
				= new Intent(TwoContentsActivity.this, ImageViewActivity.class);
			startActivity(imageview_intent);
			break;
		case LIST_ACTIVITY:
			Intent list_activity_intent 
				= new Intent(TwoContentsActivity.this, MyListActivity.class);
			startActivity(list_activity_intent);
			break;
		case SIMPLEADAPTER:
			Intent simpleadapter_intent 
				= new Intent(TwoContentsActivity.this, SimpleAdapterTest.class);
			startActivity(simpleadapter_intent);
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
