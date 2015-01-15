/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-15 ÏÂÎç1:56:12
* @class FourteenContentActivity.java
*/ 
package com.example.contents.fourteen;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.fourteen.livewallpaper.LiveWallPaperService;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class FourteenContentActivity extends CommonListActivity<String> {

	private final String TAG = "FourteenContentActivity";
	private final int LIVE_WALL_PAPER = 0;
	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		Log.d(TAG, "handlerOnItemListClicked! position=" + position);
		switch (position)
		{
		case LIVE_WALL_PAPER:
			Intent live_wall_paper = new Intent(FourteenContentActivity.this,
					LiveWallPaperService.class);
			startService(live_wall_paper);
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
		String[] Content = getResources().getStringArray(R.array.chapterFourteenContents);
		super.prepareContents(Content);
		
	}

}
