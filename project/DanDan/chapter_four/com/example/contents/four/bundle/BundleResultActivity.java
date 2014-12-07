/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÉÏÎç10:49:25.
*/ 
package com.example.contents.four.bundle;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class BundleResultActivity extends Activity {

	private String TAG = "BundleResultActivity";
	private TextView mNameText, mPassWdText, mGenderText;
	
	private void initialize()
	{
		mNameText = (TextView)findViewById(R.id.four_bundle_activity_result_name_text);
		mPassWdText = (TextView)findViewById(R.id.four_bundle_activity_result_passwd_text);
		mGenderText = (TextView)findViewById(R.id.four_bundle_activity_result_gender_text);
		
		Intent intent = getIntent();
		PersonInfo personinfo = (PersonInfo)intent.getSerializableExtra("personinfo");
		if (mNameText != null) {
			mNameText.setText("your user name:"+personinfo.getmName());
		}
		if (mPassWdText != null) {
			mPassWdText.setText("your userpasswd:"+personinfo.getmPasswd());
		}
		if (mGenderText != null) {
			mGenderText.setText("your gender:"+personinfo.getmGender());
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_bundle_activity_result);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
