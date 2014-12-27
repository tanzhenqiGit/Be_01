/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-26 ÏÂÎç1:35:26
* @class MutiThreadClient.java
*/ 
package com.example.contents.thirteen.multi;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class MutiThreadClient extends Activity {

	private final String TAG = "MutiThreadClient";
	
	private EditText mInputText, mShowText;
	private Button mSendBtn;
	private OutputStream mOs;
	private Handler mHandler;
	private Socket  mSock;
	
	
	private void setSendMsgBtn()
	{
		if (mSendBtn != null)
		{
			mSendBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mInputText != null) {
						try {
							if (mOs == null) {
								Log.d(TAG, "mOs == null do nothing ,return.");
								return;
							}
							mOs.write((mInputText.getText().toString() + "\r\n").getBytes("utf-8"));
							mInputText.setText("");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			});
		}
	}
	
	
	private void setSocket()
	{
		Log.d(TAG, "setSocket");
		try {
			mSock = new Socket("172.26.178.33", 30001);
			new Thread(new ClientThread(mSock, mHandler)).start();
			mOs = mSock.getOutputStream();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setHandler()
	{				
		mHandler = new Handler()
		{

			/* (non-Javadoc)
			 * @see android.os.Handler#handleMessage(android.os.Message)
			 */
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x123)
				{
					Log.d(TAG, "receiver msg!!");
					if (mShowText != null) {
						mShowText.append("\n" + msg.obj.toString());
					}
				}
			}
		
		};
	}
	private void initialize()
	{
		//Looper.prepare();
		mInputText = (EditText) findViewById(R.id.thirteen_multi_thread_client_input_txt);
		mShowText = (EditText) findViewById(R.id.thirteen_multi_thread_client_show_txt);
		mSendBtn = (Button) findViewById(R.id.thirteen_multi_thread_client_send_btn);
		setSendMsgBtn();

		setSocket();
		//Looper.loop();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen_multi_thread_client);
		setHandler();
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
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	

}
