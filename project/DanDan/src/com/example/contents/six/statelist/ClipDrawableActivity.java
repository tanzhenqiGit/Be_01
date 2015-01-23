/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 ÉÏÎç10:45:00
* @class ClipDrawableActivity.java
*/ 
package com.example.contents.six.statelist;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

/**
 * @author free
 *
 */
@SuppressLint("HandlerLeak")
public class ClipDrawableActivity extends Activity {

	private final String TAG = "ClipDrawableActivity";
	private final int MSG_TYPE_UPDATE = 0x01;
	private ImageView mImageView;
	
	private void initialize()
	{
		Log.d(TAG, "intialize is start");

		mImageView = (ImageView) findViewById(R.id.six_clip_drawable_main_image);
		
		final ClipDrawable tDrawable = (ClipDrawable) mImageView.getDrawable();
		final Handler tHandler = new Handler()
		{

			/* (non-Javadoc)
			 * @see android.os.Handler#handleMessage(android.os.Message)
			 */
			@Override
			public void handleMessage(Message msg) {
				
				if (msg.what == MSG_TYPE_UPDATE) {
					if (tDrawable != null) {
						Log.d(TAG, "handle Message and setLevel ");
						tDrawable.setLevel(tDrawable.getLevel() + 200);
					}
				}
			}
			
			
		};
		
		final Timer tTimer = new Timer();
		if (tTimer != null) {
			tTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					Message msg = new Message();
					msg.what = MSG_TYPE_UPDATE;
					tHandler.sendMessage(msg);
					if (tDrawable.getLevel() >= 10000) {
						tTimer.cancel();
						Log.d(TAG, "Timer cancel");
					}
					
				}
			}, 0, 300);
		}
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.six_clip_drawable_main);
		initialize();
	}
	
	

}
