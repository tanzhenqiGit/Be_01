/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-15 ÏÂÎç2:13:30
* @class ComponentAttrActivity.java
*/ 
package com.example.contents.five.intent;

import com.example.dandan.R;

import android.app.Activity;
import android.content.ComponentName;
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
public class ComponentAttrActivity extends Activity {

	private final String TAG = "ComponentAttrActivity";
	private Button mSkipBtn;
	private EditText mSkipTxt;
	
	private void initialize()
	{
		mSkipBtn = (Button)findViewById(R.id.five_common_activity_main_btn);
		if (mSkipBtn != null) {
			mSkipBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mSkipBtn is Clicked.");
					ComponentName comp = new ComponentName(ComponentAttrActivity.this,
							SecondActivity.class);
					Intent intent = new Intent();
					intent.setComponent(comp);
					startActivity(intent);
					
				}
			});
			
		}
		
		mSkipTxt = (EditText)findViewById(R.id.five_common_activity_main_txt);
		if (mSkipTxt != null) {
			mSkipTxt.setVisibility(View.INVISIBLE);
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
