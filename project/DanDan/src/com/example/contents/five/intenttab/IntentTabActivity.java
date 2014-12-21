/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-21 下午10:08:16.
*/ 
package com.example.contents.five.intenttab;

import com.example.dandan.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class IntentTabActivity extends TabActivity
{
	private final String TAG = "IntentTabActivity";
	private void initialize()
	{
		Log.d(TAG, "initialize");
		TabHost tabHost = getTabHost();
		if (tabHost == null) {
			Log.d(TAG, "tabHost == null");
			return;
		}
		
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("已接电话", getResources().getDrawable(R.drawable.font))
				.setContent(new Intent(this, BeCalledActivity.class)));
		
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("呼出电话")
				.setContent(new Intent(this, CalledActivity.class)));
		
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("未接电话")
				.setContent(new Intent(this, UnAnswerActivity.class)));
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		setContentView(R.layout.five_intent_tab_main);
		initialize();
	}


}
