/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-3 ÏÂÎç8:58:45.
*/ 
package com.example.contents.two.listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

/**
 * @author Administrator
 *
 */
public class MyListActivity extends ListActivity {

	private final String TAG = "MyListActivity";
	private String[] arr = new String[] {
		"Mr Tan","Mr Li","Mr Wang","Ms Lv"	
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreat");
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice,arr);
		setListAdapter(adapter);
	}

	
}
