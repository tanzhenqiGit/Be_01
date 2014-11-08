package com.example.contents.nine;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NineContentsActivity extends Activity{

	private String TAG = "ChapterNineContents";
	
	private ListView mList;
	private void  initializeList()
	{
		Log.d(TAG, "NineContentsActivity initializeList ");
		mList = (ListView)findViewById(R.id.nine_chapter_contests);
		String [] Contents = getResources().getStringArray(R.array.chapterNineContents);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1,
				Contents);
		if (mList != null) {
			mList.setAdapter(adapter);
		} else {
			Log.d(TAG, "initializeList mList == null");
			return;
		}
		
		mList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
			}
		
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nine_chapter_contents);
		initializeList();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_interface, menu);
		return true;
	}
}
