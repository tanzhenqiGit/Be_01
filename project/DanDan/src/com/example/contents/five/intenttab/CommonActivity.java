/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-21 ÏÂÎç10:37:32.
*/ 
package com.example.contents.five.intenttab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.dandan.R;

/**
 * @author Administrator
 *
 */
public class CommonActivity extends Activity {
	
	private final String TAG = "IntentTabActivity";
	private Button mShowBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mShowBtn = (Button )findViewById(R.id.five_com_button_main_button1);
		mShowTxt = (EditText)findViewById(R.id.five_common_activity_main_txt);
	}
	
	public boolean setText(String BtnTitle, String TxtTitle)
	{
		Log.d(TAG, "setText");
		if (mShowBtn != null) {
			mShowBtn.setText(BtnTitle);
		}
		
		if (mShowTxt != null) {
			mShowTxt.setText(TxtTitle);
		}
		return false;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_common_activity_main);
		initialize();
	}
}
