/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç3:23:46.
*/ 
package com.example.contents.four.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Administrator
 *
 */
public class LifeCycleActivity extends Activity {

	private final String TAG = "LifeCycleActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "-------------- onCreate --------------");
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "-------------- onDestroy --------------");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "-------------- onPause --------------");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "-------------- onRestart --------------");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "-------------- onResume --------------");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "-------------- onStart --------------");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "-------------- onStop --------------");
		super.onStop();
	}

}
