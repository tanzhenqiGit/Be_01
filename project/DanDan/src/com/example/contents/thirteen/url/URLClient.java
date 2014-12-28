/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-28 ÉÏÎç9:19:44.
*/ 
package com.example.contents.thirteen.url;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

/**
 * @author Administrator
 *
 */
@SuppressLint("HandlerLeak")
public class URLClient extends Activity {

	private final String TAG = "URLClient";
	public final int MSG_CMD_SHOW_IMAGE = 0;
	private ImageView mImage;
	private Bitmap mBitmap;
	private Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_CMD_SHOW_IMAGE) {
				if (mImage != null && mBitmap != null) {
					mImage.setImageBitmap(mBitmap);
				} else {
					Log.d(TAG, "handleMessage do nothing.");
				}
			}
		}
		
	};
	
	@SuppressLint("WorldReadableFiles")
	private void initialize()
	{
		mImage = (ImageView) findViewById(R.id.common_view_main_img);
		new Thread(){

			@Override
			public void run() {
				try {
					URL url = new URL("http://www.crazyit.org/attachments/"+
					    "month_1008/20100812_7763e970f822325bfb019ELQVym8tW3A.png");
					InputStream is = url.openStream();
					mBitmap = BitmapFactory.decodeStream(is);
					mHandler.sendEmptyMessage(MSG_CMD_SHOW_IMAGE);
					is.close();
					
					is = url.openStream();
					@SuppressWarnings("deprecation")
					OutputStream os = openFileOutput("crazyit.png", MODE_WORLD_READABLE);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					while ((hasRead = is.read(buff)) > 0)
					{
						os.write(buff, 0, hasRead);
					}
					
					is.close();
					os.close();
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}.start();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
