/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-3 ÏÂÎç9:33:35.
*/ 
package com.example.contents.thirteen.postutil;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
@SuppressLint("HandlerLeak")
public class GetPostMainActivity extends Activity {
	private final int MSG_HANGDLER_RESPONSE = 0x12;
	private final String TAG = "GetPostMainActivity";
	private Button mSendReqBtn, mGetReqBtn;
	private TextView mShowTxt;
	private String mResponseMsg = "nothing";
	private Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_HANGDLER_RESPONSE) {
				if (mShowTxt != null) {
					mShowTxt.setText(mResponseMsg);
				}
			}
		}
		
	};
	
	
	private void initialize()
	{
		mSendReqBtn = (Button) findViewById(R.id.thirteen_getpost_main_send_req_btn);
		if (mSendReqBtn != null) {
			mSendReqBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					new Thread()
					{

						@Override
						public void run() {
							mResponseMsg = GetPostUtil.sendPost("http://192.168.1.88:8888/abc/login.jsp"
									, "name=crazyit.org&pass=leegang");
							mHandler.sendEmptyMessage(MSG_HANGDLER_RESPONSE);
						}

					}.start();
				}
			});
		}
		
		mGetReqBtn = (Button) findViewById(R.id.thirteen_getpost_main_get_req_btn);
		if (mGetReqBtn != null) {
			mGetReqBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					new Thread(){

						@Override
						public void run() {
							mResponseMsg = GetPostUtil.sendGet("http://192.168.1.88:8888/abc/a.jsp" , null);
							mHandler.sendEmptyMessage(MSG_HANGDLER_RESPONSE);
						}
						
					}.start();
				}
			});
		}
		
		mShowTxt = (TextView) findViewById(R.id.thirteen_getpost_main_content_txt);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen_getpost_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	

}
