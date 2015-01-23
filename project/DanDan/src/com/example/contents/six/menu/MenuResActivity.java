/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 œ¬ŒÁ2:20:35
* @class MenuResActivity.java
*/ 
package com.example.contents.six.menu;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class MenuResActivity extends Activity {

	private final String TAG = "MenuResActivity";
	private TextView mTxt;
	
	private void initialize()
	{
		mTxt = (TextView) findViewById(R.id.common_view_main_text);
		if (mTxt != null) {
			mTxt.setVisibility(View.VISIBLE);
			mTxt.setText("Menu≤‚ ‘-_- ^_^");
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onMenuItemSelected(int, android.view.MenuItem)
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.d(TAG, "onMenuItemSelected");
		int font_size = 8 * 2;
		int color = Color.WHITE;
		switch (item.getItemId()) {
		case R.id.font_10:
			font_size = 10 * 2;
			break;
		case R.id.font_12:
			font_size = 12 * 2;		
		    break;
		case R.id.font_14:
			font_size = 14 * 2;
			break;
		case R.id.font_16:
			font_size = 16 * 2;
			break;
		case R.id.font_18:
			font_size = 18 * 2;
			break;
		case R.id.red_font:
			item.setCheckable(true);
			color = Color.RED;
			break;
		case R.id.blue_font:
			color = Color.BLUE;
			break;
		case R.id.green_font:
			color = Color.GREEN;
			break;
			
		}
		
		if (mTxt != null) {
			mTxt.setTextSize(font_size);
			mTxt.setTextColor(color);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG,"onCreateContextMenu");
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.content, menu);
		menu.setHeaderIcon(R.drawable.tools);
		menu.setHeaderTitle("«Î—°‘Ò—’…´");
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG, "onCreateOptionsMenu");
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.my_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onContextItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.d(TAG, "onContextItemSelected");
	
		int color = Color.BLACK;
		switch(item.getItemId())
		{
		case R.id.red:
			item.setChecked(true);
			color = Color.RED;
			break;
		case R.id.blue:
			item.setCheckable(true);
			color = Color.BLUE;
			break;
		case R.id.green:
			item.setCheckable(true);
			color = Color.GREEN;
			break;
		}
		
		if (mTxt != null) {
			mTxt.setBackgroundColor(color);
		}
		return true;
	}
	
	

	

}
