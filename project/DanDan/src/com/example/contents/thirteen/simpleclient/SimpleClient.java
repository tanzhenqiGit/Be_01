/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-26 上午10:34:24
* @class SimpleClient.java
*/ 
package com.example.contents.thirteen.simpleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class SimpleClient extends Activity {

	private final String TAG = "SimpleClient";
	private TextView mShowMsgTxt = null;
	
	private void initialize()
	{
		Log.d(TAG, "initialize() ");
		mShowMsgTxt = (TextView) findViewById(R.id.common_view_main_text);
		try {
			Socket socket = new Socket("172.26.178.174", 30000);
			BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			String Line = br.readLine();
			if (mShowMsgTxt != null) {
				mShowMsgTxt.setVisibility(View.VISIBLE);
				mShowMsgTxt.setText("数据来自SimpleServer : " + Line);
			}
		} catch (UnknownHostException e) {
			Log.d(TAG, "initialize() UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "initialize() IOException");
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate() ");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main);
		new Thread() {

			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				initialize();
			}
			
		}.start();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy() ");
		super.onDestroy();
	}

}
