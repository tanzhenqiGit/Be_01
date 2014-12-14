/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 下午3:28:17.
*/ 
package com.example.contents.two.menu;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Administrator
 *
 */
public class ContextMenuActivity extends Activity {

	private final String TAG = "ContextMenuActivity";
	private Button mShowBtn;
	private EditText mShowTxt;
	
	final int  MENU_RED = 0x111;
	final int  MENU_BLUE = 0x112;
	final int  MENU_GREEN = 0x113;
	
	private void initialize()
	{
		Log.d(TAG, "initialize");
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		if (mShowBtn != null) {
			mShowBtn.setVisibility(View.INVISIBLE);
		}
		
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowTxt != null) {
			mShowTxt.setText("ContextMenu 的测试");
			mShowTxt.setFocusable(false);
			registerForContextMenu(mShowTxt);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.d(TAG, "onContextItemSelected");
		switch(item.getItemId()) {
		case MENU_RED:
			item.setChecked(true);
			if (mShowTxt != null) {
				mShowTxt.setBackgroundColor(Color.RED);
			}
			break;
		case MENU_BLUE:
			item.setChecked(true);
			if (mShowTxt != null) {
				mShowTxt.setBackgroundColor(Color.BLUE);
			}
			break;
		case MENU_GREEN:
			item.setChecked(true);
			if (mShowTxt != null) {
				mShowTxt.setBackgroundColor(Color.GREEN);
			}
			break;
		default:
			
			break;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG,"onCreateOptionsMenu");
		SubMenu menu1 = menu.addSubMenu("选择背景颜色");
		menu1.add(0, MENU_RED, 0, "红色");
		menu1.add(0, MENU_BLUE, 0, "绿色");
		menu1.add(0, MENU_GREEN, 0, "蓝色");
		menu1.setGroupCheckable(0, true, true);
		menu1.setHeaderTitle("选择文字背景颜色");
		menu1.setIcon(R.drawable.tools);
		
		return super.onCreateOptionsMenu(menu);
	}

	
	
}
