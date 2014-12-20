/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-20 下午7:05:18.
*/ 
package com.example.contents.five.sysaction;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Administrator
 *
 */
public class ActionDataActivity extends Activity {

	private final String TAG = "ActionDataActivity";
	private Button mButton1, mButton2, mButton3;
	private EditText mEditText;
	
	private void CallBackBtn1()
	{
		Log.d(TAG, "CallBackBtn1");
		Intent intent = new Intent();
		String Data = "http://www.baidu.com";
		Uri uri = Uri.parse(Data);
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(uri);
		startActivity(intent);
	}
	
	private void CallBackBtn2()
	{
		Log.d(TAG, "CallBackBtn2");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_EDIT);
		String Data = "content://com.android.contacts/contacts/1";
		Uri uri = Uri.parse(Data);
		intent.setData(uri);
		startActivity(intent);
	}
	
	private void CallBackBtn3()
	{
		Log.d(TAG, "CallbackBtn3");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DIAL);
		String Data = "tel:18616312847";
		Uri uri = Uri.parse(Data);
		intent.setData(uri);
		startActivity(intent);
	}
	
	private void initialize()
	{
		Log.d(TAG, "initialize");
		
		mEditText = (EditText) findViewById(R.id.five_com_button_main_txt);
		if (mEditText != null) {
			mEditText.setVisibility(View.INVISIBLE);
		}
		mButton1 = (Button)findViewById(R.id.five_com_button_main_button1);
		if (mButton1 != null) {
			mButton1.setText("切换到百度网页");
			mButton1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					CallBackBtn1();
				}
			});
		}
		
		mButton2 = (Button)findViewById(R.id.five_com_button_main_button2);
		if (mButton2 != null) {
			mButton2.setText("切换编辑联系人");
			mButton2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					CallBackBtn2();
				}
			});
		}
		
		mButton3 = (Button)findViewById(R.id.five_com_button_main_button3);
		if (mButton3 != null) {
			mButton3.setText("切换到打电话");
			mButton3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					CallBackBtn3();
				}
			});
		}
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_com_button_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
