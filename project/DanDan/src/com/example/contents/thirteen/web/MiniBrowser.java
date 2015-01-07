/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-7
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-7 ÉÏÎç11:15:04
* @class MiniBrowser.java
*/ 
package com.example.contents.thirteen.web;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class MiniBrowser extends Activity {

	public final String TAG = "MiniBrowser";
	private EditText mURLTxt;
	private WebView mWebShow;
	
	
	private void initialize()
	{
		mURLTxt = (EditText) findViewById(R.id.thirteen_minibrowser_main_txt);
		mWebShow = (WebView) findViewById(R.id.thirteen_minibrowser_main_show);
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen_minibrowser_main);
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
	/* (non-Javadoc)
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.d(TAG, "onKeyDown keyCode=" + keyCode);
		
		if (keyCode == KeyEvent.KEYCODE_SEARCH);
		{
			if (mURLTxt != null && mWebShow != null) {
				String urlStr = mURLTxt.getText().toString();
				Log.d(TAG, "ursStr = " + urlStr);
				mWebShow.loadUrl(urlStr);
				return true;
			}
		}
		return false;
	}
	
	

}
