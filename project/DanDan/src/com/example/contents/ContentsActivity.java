package com.example.contents;

import com.example.contents.nine.NineContentsActivity;
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

public class ContentsActivity extends Activity {
	private ListView mList;
	private String TAG = "MainInterface";
	private final int CHAPTER_ONE = -1;
	private final int CHAPTER_TWO = 0;
	private final int CHAPTER_THREE = 1;
	private final int CHAPTER_FOUR = 2;
	private final int CHAPTER_FIVE = 3;
	private final int CHAPTER_SIX = 4;
	private final int CHAPTER_SEVEN = 5;
	private final int CHAPTER_EIGHT = 6;
	private final int CHAPTER_NINE = 7;
	private final int CHAPTER_TEN = 8;
	private final int CHAPTER_ELEVEN = 9;
	private final int CHAPTER_TWELVE = 10;
	private final int CHAPTER_THRITEEN = 11;
	private final int CHAPTER_FOURTEEN = 12;
	private final int CHAPTER_FIFTEEN = 13;
	private final int CHAPTER_SIXTEEN = 14;
	private final int CHAPTER_SEVENTEEN = 15;
	private final int CHAPTER_EIGHTEEN = 16;
	private final int CHAPTER_NINETEEN = 17;
	
	private void initializeConpoment()
	{
		mList = (ListView)findViewById(R.id.listView);
		if (mList == null) {
			Log.d(TAG,"initializeConpoment can't find ListView");
			return;
		}
		String[] Contents = getResources().getStringArray(R.array.Contents);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,
				Contents);
		mList.setAdapter(adapter);
	}
	
	private void setListViewOnClickListener()
	{
		if(mList != null) {
			mList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					Log.d(TAG, "onItemClick arg2:" + position + "arg3:" + arg3);
					switch(position) {
					case CHAPTER_ONE:
						break;
					case CHAPTER_TWO:
						break;
					case CHAPTER_THREE:
						break;
					case CHAPTER_FOUR:
						break;
					case CHAPTER_FIVE:
						
						break;
					case CHAPTER_SIX:
						break;
					case CHAPTER_SEVEN:
						break;
					case CHAPTER_EIGHT:
						
						break;
					case CHAPTER_NINE:
						Log.d(TAG, "goto nine chapter contents");
						Intent intent = new Intent(ContentsActivity.this, NineContentsActivity.class);
						startActivity(intent);
						break;
					case CHAPTER_TEN:
						break;
					case CHAPTER_ELEVEN:
						break;
					case CHAPTER_TWELVE:
						break;
					case CHAPTER_THRITEEN:
						break;
					case CHAPTER_FOURTEEN:
						break;
					case CHAPTER_FIFTEEN:
						break;
					case CHAPTER_SIXTEEN:
						
						break;
					case CHAPTER_SEVENTEEN:
						
						break;
					case CHAPTER_EIGHTEEN:
						
						break;
					case CHAPTER_NINETEEN:
						
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initializeConpoment();
		setListViewOnClickListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_interface, menu);
		return true;
	}
}