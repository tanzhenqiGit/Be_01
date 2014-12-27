/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-26 ÏÂÎç1:49:57
* @class ClientThread.java
*/ 
package com.example.contents.thirteen.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * @author free
 *
 */
public class ClientThread implements Runnable {

	private final String TAG = "ClientThread";
	private Socket mSock;
	private Handler mHandler;
	private BufferedReader mBufferReader = null;
	
	public ClientThread(Socket sock, Handler handler) throws IOException
	{
		Log.d(TAG, "ClientThread is created");
		this.mSock = sock;
		this.mHandler = handler;
		mBufferReader = new BufferedReader(new InputStreamReader(mSock.getInputStream()));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		String content = null;
		Log.d(TAG, "ClientThread run()");
		try {
			while((content = mBufferReader.readLine()) != null)
			{
				Log.d(TAG, "ClientThread run receiver msg in Client Thread msg:" + content);
				Message msg = new Message();
				msg.what = 0x123;
				msg.obj = content;
				mHandler.sendMessage(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
