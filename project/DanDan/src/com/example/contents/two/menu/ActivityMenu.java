/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 下午2:51:01.
*/ 
package com.example.contents.two.menu;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/**
 * @author Administrator
 *
 */
public class ActivityMenu extends Activity {

	private final String TAG  = "ActivityMenu";
	
	private void intialize()
	{
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		intialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(TAG, "onCreateOptionsMenu");
		SubMenu prog = menu.addSubMenu("启动程序");
		if (prog != null) {
			prog.setHeaderIcon(R.drawable.tools);
			prog.setHeaderTitle("选择您要的启动程序");
			MenuItem item = prog.add("查看earth");
			item.setIntent(new Intent(ActivityMenu.this, OtherActivity.class));
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
	
}
