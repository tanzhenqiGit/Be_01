/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-27
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-27 下午4:57:55
* @class SharedPreferencesActivity.java
*/ 
package com.example.contents.eight.sharedpreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class SharedPreferencesActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main);
		initialize();
	}
	
	@SuppressLint("SimpleDateFormat")
	private void BtnCallBack()
	{
		Log.d(TAG, "BtnCallBack mType:" + mType);
		if (mType == EN_TYPE.EN_TYPE_WRITE) {
			if (mBtn != null) {
				mBtn.setText("读出");
			}
			mType = EN_TYPE.EN_TYPE_READ;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 mm月 dd日 " + "HH:mm:ss");
			if (mEditor != null) {
				mEditor.putString(TIME_KEY, sdf.format(new Date()));
				mEditor.putInt(RANDOM_KEY, (int)(Math.random() * 100));
				mEditor.commit();
			}
		} else {
			mType = EN_TYPE.EN_TYPE_WRITE;
			if (mBtn != null) {
				mBtn.setText("写入");
			}
			if (mSharedPreferences != null && mTxt != null) {
			    String time = mSharedPreferences.getString(TIME_KEY, null);
			    int randNum = mSharedPreferences.getInt(RANDOM_KEY, 0);
			    mTxt.setText(time +" randNum:" +randNum);
			}
		}
	}
	
	private void initialize()
	{
		mType = EN_TYPE.EN_TYPE_WRITE;
		mSharedPreferences = getSharedPreferences(NAME, MODE_PRIVATE);
		if (mSharedPreferences != null) {
			mEditor = mSharedPreferences.edit();
		}
		
		mTxt = (TextView) findViewById(R.id.common_view_main_text);
		if (mTxt != null) {
			mTxt.setVisibility(View.VISIBLE);
			mTxt.setText(R.string.Default);
		}
		mBtn = (Button) findViewById(R.id.common_view_main_btn);
		if (mBtn != null) {
			mBtn.setVisibility(View.VISIBLE);
			mBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					BtnCallBack();
				}
			});
		}
		
	}
	
	private final String TAG = "SharedPreferencesActivity";
	private final String NAME = "com.example.dandan";
	private final String TIME_KEY = "time";
	private final String RANDOM_KEY = "random";
	private SharedPreferences mSharedPreferences;
	private SharedPreferences.Editor mEditor;
	private TextView mTxt;
	private Button mBtn;
	enum EN_TYPE {EN_TYPE_WRITE, EN_TYPE_READ};
	EN_TYPE mType;

}
