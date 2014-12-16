/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-16 ÏÂÎç10:23:57.
*/ 
package com.example.contents.five.sysaction;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Administrator
 *
 */
public class DataTypeOverride extends Activity implements OnClickListener{

	private final String TAG = "DataTypeOverride";
	private Button 	mButton1, mButton2, mButton3;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mButton1 = (Button) findViewById(R.id.five_com_button_main_button1);
		if (mButton1 != null) {
			mButton1.setText("¸²¸Çtype");
			mButton1.setOnClickListener(this);
		}
		mButton2 = (Button) findViewById(R.id.five_com_button_main_button2);
		if (mButton2 != null) {
			mButton2.setText("¸²¸Çdata");
			mButton2.setOnClickListener(this);
		}
		mButton3 = (Button) findViewById(R.id.five_com_button_main_button3);
		if (mButton3 != null) {
			mButton3.setText("¶¼²»¸²¸Ç");
			mButton3.setOnClickListener(this);
		}
		
		mShowTxt = (EditText) findViewById(R.id.five_com_button_main_txt);
		
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

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
	
		switch(v.getId())
		{
		case R.id.five_com_button_main_button1:
			intent.setType("ABC/DEF");
			intent.setData(Uri.parse("lee://www.fkjava.org:8888/text"));
			
			break;
		case R.id.five_com_button_main_button2:
			intent.setData(Uri.parse("lee://www.fkjava.org:8888/text"));
			intent.setType("ABC/DEF");

			
			break;
		case R.id.five_com_button_main_button3:
			intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/text"), 
					"ABC/DEF");
			
			break;
		default:
			
			break;
		}
		
		if (mShowTxt == null) {
			Log.d(TAG, "mShowTet == null");
			return;
		}
		mShowTxt.setText(intent.toString());
	}

}
