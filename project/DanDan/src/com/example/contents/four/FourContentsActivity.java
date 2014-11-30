package com.example.contents.four;


import com.example.contents.four.otheractivity.OtherActivity;
import com.example.contents.four.startactivity.StartActivity;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FourContentsActivity extends Activity {

	private final String TAG = "FourContent";
	private String[] mContents = null;
	private ListView mContentList = null;
	private final int OTHER_ACTIVITY= 0;
	private final int START_ACTIVITY = 1;
	private void initialize()
	{
		mContentList = (ListView) findViewById(R.id.listView);
		mContents = getResources().getStringArray(R.array.chapterFourContents);
		if (mContentList != null) {
			ArrayAdapter<String> adapter 
				= new ArrayAdapter<String>(FourContentsActivity.this,
						android.R.layout.simple_list_item_1,
						mContents);
			mContentList.setAdapter(adapter);
			setListViewCallBack();
		}
	}
	
	private void setListViewCallBack()
	{
		if (mContentList != null) {
			mContentList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View source,
						int position, long id) {
					Log.d(TAG, "position=" + position);
					switch(position) {
					case OTHER_ACTIVITY:
						Intent other_activity_intent 
							= new Intent(FourContentsActivity.this, OtherActivity.class);
						startActivity(other_activity_intent);
						break;
					case START_ACTIVITY:
						Intent start_activity_intent 
							= new Intent(FourContentsActivity.this, StartActivity.class);
						startActivity(start_activity_intent);
						break;
					default:
						
						break;
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
