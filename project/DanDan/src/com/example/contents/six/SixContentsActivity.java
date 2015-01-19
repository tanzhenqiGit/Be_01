/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-19 ÏÂÎç9:27:01.
*/ 
package com.example.contents.six;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.six.statelist.StateListDrawbleActivity;
import com.example.dandan.R;

/**
 * @author Administrator
 *
 */
public class SixContentsActivity extends CommonListActivity<String> {

	private final int STATE_LIST_DRAWABLE = 0;
	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position) {
		case STATE_LIST_DRAWABLE:
			Intent state_list_drawable = new Intent(SixContentsActivity.this, StateListDrawbleActivity.class);
			startActivity(state_list_drawable);
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
		String[] contents = getResources().getStringArray(R.array.chapterSixContents);
		prepareContents(contents);
		
	}

}
