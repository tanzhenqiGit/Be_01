/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-18 ÏÂÎç5:28:23.
*/ 
package com.example.contents.fourteen.desktop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * @author Administrator
 *
 */
@SuppressLint("HandlerLeak")
public class LedClock extends AppWidgetProvider{

	private final String TAG = "LedClock";
	private final int MSG_TYPE_TIME_UPDATE = 0x01;
	private Timer mTimer;
	private int [] mDigits = new int [] {
		R.drawable.su01,
		R.drawable.su02,	
		R.drawable.su03,	
		R.drawable.su04,	
		R.drawable.su05,	
		R.drawable.su06,	
		R.drawable.su07,	
		R.drawable.su08,	
		R.drawable.su09,	
	};
	private int [] mImageId = new int [] {
		R.id.fourteen_led_clock_img01,
		R.id.fourteen_led_clock_img02,
		R.id.fourteen_led_clock_img04,
		R.id.fourteen_led_clock_img05,
		R.id.fourteen_led_clock_img07,
		R.id.fourteen_led_clock_img08,
	};
	
	private AppWidgetManager mAppWingetManager;
	private Context mContext;
	private Handler mHandler = new Handler() 
	{

		@SuppressLint("SimpleDateFormat")
		@Override
		public void handleMessage(Message msg) {
			
			if (msg.what == MSG_TYPE_TIME_UPDATE) {
				Log.d(TAG, "receiver timer update");
				RemoteViews views = new RemoteViews(mContext.getPackageName(),
						R.layout.fourteen_led_clock_main);
				
				SimpleDateFormat df = new SimpleDateFormat("HHmmss");
				String timeStr = df.format(new Date());
				for (int i = 0; i < timeStr.length(); i++)
				{
					int num = timeStr.charAt(i) - 48;
					if (num >= 0 && num < mDigits.length)
					{
						Log.d(TAG, "i:"+ i + "num:" + num);
						views.setImageViewResource(mImageId[i], mDigits[num]);
					}
					
				}
				
				ComponentName componentName = new ComponentName(mContext, LedClock.class);
				mAppWingetManager.updateAppWidget(componentName, views);
			}
			
			super.handleMessage(msg);
		}
		
	};
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Log.d(TAG, "onDeleted");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		Log.d(TAG, "onDisabled");
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		Log.d(TAG, "onEnabled");
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceiver");
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.d(TAG, "onUpdate");
		mAppWingetManager = appWidgetManager;
		mContext = context;
		mTimer = new Timer();
		
		if (mTimer != null) {
			mTimer.schedule(new TimerTask()
			{

				@Override
				public void run() {
					Log.d(TAG, "in Timer run function");
					if (mHandler != null) {
						mHandler.sendEmptyMessage(MSG_TYPE_TIME_UPDATE);
					}
				}
				
			}, 0, 1000);
		}
		
	}

}
