package com.example.contents.eleven;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ElevenContentsActivity extends Activity {

	private final String TAG = "ElevenContentsActivity";
	private String[] mContents;
	private ListView mListView;
	private final int SOUND_POOL = 0;
	private void setListCallBack()
	{
		if (mListView != null) {
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position) {
					case SOUND_POOL:
						
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
		mContents = getResources().getStringArray(R.array.chapterElevenContents);
		mListView = (ListView)findViewById(R.id.listView);
		ArrayAdapter<String> adapter 
			= new ArrayAdapter<String>(
					ElevenContentsActivity.this,
					android.R.layout.simple_list_item_1,
					mContents);
		if(mListView != null) {
			mListView.setAdapter(adapter);
			setListCallBack();
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
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}