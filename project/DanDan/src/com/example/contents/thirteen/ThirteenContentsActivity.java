/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014����10:03:28
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time ��2014-12-2 ����10:03:28 
* class declare 
*/ 
package com.example.contents.thirteen;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author free
 *
 */
public class ThirteenContentsActivity extends Activity {

	private final String TAG = "ThirteenContentsActivity";
	private ListView mListView;
	private String[] mContents;
	
	private void ListCallBack()
	{
		if (mListView != null) {
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position) {
					case 0:
						
						break;
					case 1:
						
						break;
					case 2:
						
						break;
					default:
						
						break;
					}
					
				}
			});
		}
	}
	private void initialize()
	{
		mContents = getResources().getStringArray(R.array.chapterThirteenContents);
		mListView = (ListView)findViewById(R.id.listView);
		if (mListView != null) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					ThirteenContentsActivity.this,
					android.R.layout.simple_list_item_1, mContents);
			mListView.setAdapter(adapter);
			ListCallBack();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "ThirteenContentsActivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}