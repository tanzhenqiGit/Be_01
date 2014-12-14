/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-13 下午6:58:37.
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
public class MenuTest extends Activity {

	private final String TAG = "MenuTest";
	final int FONT_10 = 0x111;
	final int FONT_12 = 0x112;
	final int FONT_14 = 0x113;
	final int FONT_16 = 0x114;
	final int FONT_18 = 0x115;
	
	
	final int FONT_RED = 0x116;
	final int FONT_BLUE = 0x117;
	final int FONT_GREEN = 0x118;
	
	final int PLAIN_ITEM = 0x11b;
	private EditText mShowTxt;
	private Button mShowBtn;
	private void initialize()
	{
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowTxt != null)
		{
			mShowTxt.setText("Menu测试");
			mShowTxt.setFocusable(false);
			
		}
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		if (mShowBtn != null) {
			mShowBtn.setVisibility(View.INVISIBLE);
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG, "onCreateOptionsMenu");
		SubMenu fontMenu = menu.addSubMenu("字体大小");
		if (fontMenu != null) {
			fontMenu.setIcon(R.drawable.font);
			fontMenu.setHeaderIcon(R.drawable.font);
			fontMenu.setHeaderTitle("选择字体大小");
			fontMenu.add(0,FONT_10,0,"10好字体");
			fontMenu.add(0,FONT_12,0,"12好字体");
			fontMenu.add(0,FONT_14,0,"14好字体");
			fontMenu.add(0,FONT_16,0,"16好字体");
			fontMenu.add(0,FONT_18,0,"18好字体");
		}
		
		menu.add(0,PLAIN_ITEM,0,"普通菜单项");
		SubMenu colorMenu = menu.addSubMenu("字体颜色");
		if (colorMenu != null) {
			colorMenu.setIcon(R.drawable.color);
			colorMenu.setHeaderIcon(R.drawable.color);
			colorMenu.setHeaderTitle("选择文字颜色");
			colorMenu.addSubMenu(0, FONT_RED, 0, "红色");
			colorMenu.addSubMenu(0, FONT_BLUE, 0, "蓝色");
			colorMenu.addSubMenu(0, FONT_GREEN, 0, "绿色");
			
		}
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "Oncreate");
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
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mShowTxt == null) {
			Log.d(TAG, "mShowTxt == null do nothing.");
			return super.onOptionsItemSelected(item);
		}
		
		switch(item.getItemId())
		{
		case FONT_10:
			mShowTxt.setTextSize(10 * 2);
			break;
		case FONT_12:
			mShowTxt.setTextSize(12 * 2);	
			break;
		case FONT_14:
			mShowTxt.setTextSize(14 * 2);
			break;
		case FONT_16:
			mShowTxt.setTextSize(16 * 2);
			break;
		case FONT_18:
			mShowTxt.setTextSize(18 * 2);
			break;
			
		case FONT_RED:
			mShowTxt.setTextColor(Color.RED);
			break;
		case FONT_BLUE:
			mShowTxt.setTextColor(Color.BLUE);
			break;
		case FONT_GREEN:
			mShowTxt.setTextColor(Color.GREEN);
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}

	
	
}
