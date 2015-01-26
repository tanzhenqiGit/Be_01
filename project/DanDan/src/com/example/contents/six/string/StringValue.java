/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-26 ÉÏÎç11:40:47
* @class StringValue.java
*/ 
package com.example.contents.six.string;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class StringValue extends Activity {

	private final String TAG = "StringValue";
	private TextView mTxt;
	private Button mBtn;
	
	private void initialize()
	{
		mTxt = (TextView) findViewById(R.id.common_view_main_text);
		if (mTxt != null) {
			mTxt.setVisibility(View.VISIBLE);
			mTxt.setText(R.string.hello);
		}
		
		mBtn = (Button) findViewById(R.id.common_view_main_btn);
		
		if (mBtn != null) {
			mBtn.setVisibility(View.VISIBLE);
			mBtn.setText(R.string.android);
		}
	}
	
	
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
	
	

}
