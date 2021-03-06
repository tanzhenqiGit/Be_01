package com.example.contents.three;

import com.example.contents.three.callback.CallBackHandler;
import com.example.contents.three.configuration.ConfigurationActivity;
import com.example.contents.three.configurationchange.ConfigurationChange;
import com.example.contents.three.drawview.CustomViewActivity;
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

public class ThreeContentsActivity extends Activity {

	private final String TAG = "ThreeContentsActivity";
	private ListView mList;
	private String[] mChapterThreeContents;
	private final int CALLBACK_HANDLER = 0;
	private final int CURSTOM_VIEW = 1;
	private final int CONFIGURATION = 2;
	private final int CHANGE_ORIENTATION = 3;
	private void setListCallBack()
	{
		if (mList != null) {
			mList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position) {
					case CALLBACK_HANDLER:
						Intent callback_handler_intent 
							= new Intent(ThreeContentsActivity.this, CallBackHandler.class);
						startActivity(callback_handler_intent);
						break;
					case CURSTOM_VIEW:
						Intent custom_view_intent 
							= new Intent(ThreeContentsActivity.this, CustomViewActivity.class);
						startActivity(custom_view_intent);
						break;
					case CONFIGURATION:
						Intent configuration_inteint 
							= new Intent(ThreeContentsActivity.this, ConfigurationActivity.class);
						startActivity(configuration_inteint);
						break;
					case CHANGE_ORIENTATION:
						Intent change_orientation_intent
							= new Intent(ThreeContentsActivity.this, ConfigurationChange.class);
						startActivity(change_orientation_intent);
						break;
					default:
						Log.d(TAG, "position default");
						break;
					}
					
				}
			});
		}
	}
	private void initialize()
	{
		mChapterThreeContents = getResources().getStringArray(R.array.chapterThreeContents);
		mList = (ListView)findViewById(R.id.listView);
		if (mList != null) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThreeContentsActivity.this,
					android.R.layout.simple_list_item_1,mChapterThreeContents);
			mList.setAdapter(adapter);
			setListCallBack();
		} else {
			Log.d(TAG, "mList == null");
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

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
