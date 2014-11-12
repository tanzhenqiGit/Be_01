package com.example.contents.nine;

import com.example.contents.nine.DictProvider.DictResolvertTest;
import com.example.contents.nine.contentprovider.ContentProviderTest;
import com.example.contents.nineFirstContent.FirstResolver;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
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
	private final int FIRST_CONTENT = 0;
	private final int DICT_PROVIDER = 1;
	private final int CONTENT_PROVIDER = 2;
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
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				switch(position)
				{
				case FIRST_CONTENT:
					Intent intent = new Intent(NineContentsActivity.this,
							FirstResolver.class);
					startActivity(intent);
					break;
				case DICT_PROVIDER:
					Intent dict_intent = new Intent(NineContentsActivity.this,
							DictResolvertTest.class);
					startActivity(dict_intent);
					break;
				case CONTENT_PROVIDER:
					Intent content_intent = new Intent(NineContentsActivity.this, 
							ContentProviderTest.class);
					startActivity(content_intent);
					break;
				default:
					
					break;
				}
				
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
