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
import com.example.contents.eight.file.FileActivity;
import com.example.contents.eight.file.SDCardActivity;
import com.example.contents.eight.gesture.GestureTest;
import com.example.contents.eight.gesture.PageTurningActivity;
import com.example.contents.eight.sharedpreferences.SharedPreferencesActivity;
import com.example.contents.eight.sqlite.HandleSQLiteActivity;
import com.example.contents.eight.sqliteopenhelper.DictActivity;
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
		case FILE_TEST:
			Intent file_test = new Intent(EightContentsActivity.this,
					FileActivity.class);
			startActivity(file_test);
			break;
		case SD_CARD_TEST:
			Intent sd_card_test = new Intent(EightContentsActivity.this,
					SDCardActivity.class);
			startActivity(sd_card_test);
			break;
		case SQLITE_TEST:
			Intent sqlite_test = new Intent(EightContentsActivity.this,
					HandleSQLiteActivity.class);
			startActivity(sqlite_test);
			break;
		case SQLITE_OPEH_HELPER:
			Intent sqlite_open = new Intent(EightContentsActivity.this,
					DictActivity.class);
			startActivity(sqlite_open);
			break;
		case GESTURE_DETECTOR:
			Intent gesture_detector = new Intent(EightContentsActivity.this,
					GestureTest.class);
			startActivity(gesture_detector);
			break;
		case PAGE_TURNING:
			Intent page_turning = new Intent(EightContentsActivity.this,
					PageTurningActivity.class);
			startActivity(page_turning);
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
	public final int FILE_TEST = 1;
	public final int SD_CARD_TEST = 2;
	public final int SQLITE_TEST = 3;
	public final int SQLITE_OPEH_HELPER = 4;
	public final int GESTURE_DETECTOR = 5;
	public final int PAGE_TURNING = 6;
}
