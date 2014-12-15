/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-15 ÏÂÎç3:26:42
* @class ActionAttrActivity.java
*/ 
package com.example.contents.five.intent;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class ActionAttrActivity extends Activity {

	private final String TAG = "ActionAttrActivity";
	public final static String FIVE_ACTION_ATTR = 
			"com.example.contents.five.intent.SecondActivity.Action";
	public final static String FIVE_CATEGORY =
			"com.example.contents.five.intent.CATEGORY";
	private Button mSkipBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mShowTxt = (EditText)findViewById(R.id.five_common_activity_main_txt);
		if (mShowTxt != null) {
			mShowTxt.setVisibility(View.INVISIBLE);
		}
		
		mSkipBtn = (Button)findViewById(R.id.five_common_activity_main_btn);
		
		if (mSkipBtn != null) {
			mSkipBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setAction(ActionAttrActivity.FIVE_ACTION_ATTR);
					intent.addCategory(FIVE_CATEGORY);
					startActivity(intent);
				}
			});
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_common_activity_main);
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
