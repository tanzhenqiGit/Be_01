/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 ÏÂÎç9:37:43.
*/ 
package com.example.contents.two.actionbar;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Administrator
 *
 */
@SuppressLint("NewApi")
public class ActionBarActivity extends Activity {

	private final String TAG = "ActionBarActivity";
	private Button mShowBar, mHideBar;
	private ActionBar mActionBar;
	
	private void initialize()
	{
		mActionBar = getActionBar();
		mShowBar = (Button)findViewById(R.id.two_action_bar_main_show_btn);
		if (mShowBar != null) {
			mShowBar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					if (mActionBar != null) {
						Log.d(TAG, "Show onclicked action bar show");
						mActionBar.show();
					}
				}
			});
		}
		
		mHideBar = (Button)findViewById(R.id.two_action_bar_main_hide_btn);
		if (mHideBar != null) {
			mHideBar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mActionBar != null) {
						Log.d(TAG, "Hide onclicked action bar hide");
						mActionBar.hide();
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_action_bar_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
