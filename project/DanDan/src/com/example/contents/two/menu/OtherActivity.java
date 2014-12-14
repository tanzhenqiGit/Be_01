/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 ÏÂÎç3:00:38.
*/ 
package com.example.contents.two.menu;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Administrator
 *
 */
public class OtherActivity extends Activity {

	private final String TAG  = "ActivityMenu";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_menu_activity_main);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onCreate");
		super.onDestroy();
	}

	
}
