/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-16
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-16 ÉÏÎç11:28:36
* @class DesktopApp.java
*/ 
package com.example.contents.fourteen.desktop;

import com.example.dandan.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * @author free
 *
 */
public class DesktopApp extends AppWidgetProvider {

	private final String TAG = "AppWidgetProvider";
	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceiver");
		super.onReceive(context, intent);
	}

	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onDeleted(android.content.Context, int[])
	 */
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Log.d(TAG, "onDeleted appWidgetIds = " + java.util.Arrays.toString(appWidgetIds));
	
		
		super.onDeleted(context, appWidgetIds);
	}

	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[])
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.d(TAG, "onDeleted appWidgetIds = " + java.util.Arrays.toString(appWidgetIds));
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.common_view_main);
		remoteViews.setImageViewResource(R.id.common_view_main_img, R.drawable.shuangta);
		ComponentName conponentName = new ComponentName(context, DesktopApp.class);
		appWidgetManager.updateAppWidget(conponentName, remoteViews);
	}

	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onEnabled(android.content.Context)
	 */
	@Override
	public void onEnabled(Context context) {
		Log.d(TAG, "onEnabled");
		super.onEnabled(context);
	}

	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onDisabled(android.content.Context)
	 */
	@Override
	public void onDisabled(Context context) {
		Log.d(TAG, "onDisabled");
		super.onDisabled(context);
	}

	
}
