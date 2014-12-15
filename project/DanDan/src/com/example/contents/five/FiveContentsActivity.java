/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-15 ÉÏÎç10:25:18
* @class FiveContentsActivity.java
*/ 
package com.example.contents.five;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.five.component.ComponentAttrActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class FiveContentsActivity extends CommonListActivity<String> {
	
	private final int COMPONENT_ATTR = 0;

	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position)
		{
		case COMPONENT_ATTR:
			Intent component_attr_intent = 
				new Intent(FiveContentsActivity.this, ComponentAttrActivity.class);
			startActivity(component_attr_intent);
			break;
		case 1:
			
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
		String[] FiveContents = getResources().getStringArray(R.array.chapterFiveContents);
		super.prepareContents(FiveContents);
		
	}

}
