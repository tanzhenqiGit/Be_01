/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-11
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-11 下午4:15:27
* @class TabHostActivity.java
*/ 
package com.example.contents.two.specialview;


import com.example.dandan.R;

import android.app.TabActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * @author free
 *
 */
@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

	private final String TAG = "TabHostActivity";
	
	private void initialize()
	{
		TabHost tabHost = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.two_tabhost_main, tabHost.getTabContentView(),true);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("已接电话").setContent(R.id.two_tabhost_tab01));
		tabHost.addTab(tabHost.newTabSpec("tab2")
				.setIndicator("呼出电话", getResources().getDrawable(R.drawable.t))
				.setContent(R.id.two_tabhost_tab02));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("未接电话").setContent(R.id.two_tabhost_tab03));
		tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("阻止电话").setContent(R.id.two_tabhost_tab04));
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
