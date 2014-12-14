/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 下午7:57:38.
*/ 
package com.example.contents.two.menu;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Administrator
 *
 */
public class MenuResourceActivity extends Activity {

	private final String TAG = "MenuResourceActivity";
	private Button mShowBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		if (mShowBtn != null) 
		{
			mShowBtn.setText("长按我");
			registerForContextMenu(mShowBtn);
		}
		
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowTxt != null) {
			mShowTxt.setText("MenuResourceActivity 测试");
			mShowTxt.setFocusable(false);
		}
		
		
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.d(TAG, "onConTextItemSelected");
		if (mShowTxt ==  null) {
			Log.d(TAG, "onConTextItemSelected mShowTxt == null");
			return super.onContextItemSelected(item);
		}
		switch(item.getItemId())
		{
		case R.id.two_menu_resource_context_red:
			item.setChecked(true);
			mShowTxt.setBackgroundColor(Color.RED);
			break;
		case R.id.two_menu_resource_context_green:
			item.setChecked(true);
			mShowTxt.setBackgroundColor(Color.GREEN);
			break;
		case R.id.two_menu_resource_context_blue:
			item.setChecked(true);
			mShowTxt.setBackgroundColor(Color.BLUE);
			break;
		default:
			
			break;
		}
		return super.onContextItemSelected(item);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.d(TAG, "onOptionsItemSelected");
		if (mShowTxt == null) {
			Log.d(TAG, "onOptionsItemSelected mShowTxt == null");
			return super.onOptionsItemSelected(item);
		}
		if (item.isCheckable()) {
			item.setChecked(true);
		}
		
		switch(item.getItemId())
		{
		case R.id.two_menu_resource_main_font_10:
			mShowTxt.setTextSize(10 * 2);
			break;
		case R.id.two_menu_resource_main_font_12:
			mShowTxt.setTextSize(12 * 2);
			break;
		case R.id.two_menu_resource_main_font_14:
			mShowTxt.setTextSize(14 * 2);
			break;
		case R.id.two_menu_resource_main_font_16:
			mShowTxt.setTextSize(16 * 2);
			break;
		case R.id.two_menu_resource_main_font_18:
			mShowTxt.setTextSize(18 * 2);
			break;
			
		case R.id.two_menu_resource_main_blue_font:
			mShowTxt.setTextColor(Color.BLUE);
			break;
		case R.id.two_menu_resource_main_green_font:
			mShowTxt.setTextColor(Color.GREEN);
			break;
		case R.id.two_menu_resource_main_red_font:
			mShowTxt.setTextColor(Color.RED);
			break;
		case R.id.two_menu_resource_main_plain_item:
			Toast.makeText(MenuResourceActivity.this, "你单击了plain_item", Toast.LENGTH_LONG).show();
			break;
		default:
			
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.two_menu_resource_context, menu);
		menu.setHeaderIcon(R.drawable.tools);
		menu.setHeaderTitle("颜色选择");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG, "onCreateOptionsMenu");
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.two_menu_resource_mymenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
