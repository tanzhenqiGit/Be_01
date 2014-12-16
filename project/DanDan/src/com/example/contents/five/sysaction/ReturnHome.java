/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-16 ÏÂÎç9:59:03.
*/ 
package com.example.contents.five.sysaction;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Administrator
 *
 */
public class ReturnHome extends Activity {

	private final String TAG = "ReturnHome";
	private Button mRetHomeBtn;
	private EditText mShowText;
	
	private void initialize()
	{
		mRetHomeBtn = (Button)findViewById(R.id.five_common_activity_main_btn);
		mShowText = (EditText)findViewById(R.id.five_common_activity_main_txt);
		if (mRetHomeBtn != null) {
			mRetHomeBtn.setText("·µ»ØHome»­Ãæ");
			mRetHomeBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_MAIN);
					intent.addCategory(Intent.CATEGORY_HOME);
					startActivity(intent);
					
				}
			});
		}
		if (mShowText != null) {
			mShowText.setVisibility(View.INVISIBLE);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_common_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
