package com.example.contents.four.otheractivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

public class OtherActivity extends LauncherActivity {

	private final String TAG = "OtherActivity";
	
	private String[] mNames = {
			"set params",
			"check interstellar Arms"
	};
	private Class<?>[] mClazzs = {
			ArmsPreferenceActivity.class,
			ArmsExpandableListActivity.class
	};
	
	private void intialize()
	{
		ArrayAdapter<String> adapter 
			= new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1,
					mNames);
		setListAdapter(adapter);
	}
	@Override
	protected Intent intentForPosition(int position) {
		Log.d(TAG, "intentForPosition position="+position);
		if (position < 2) {
			return new Intent(OtherActivity.this, mClazzs[position]);
		}
		return super.intentForPosition(position);
		
	}

	@Override
	protected void onCreate(Bundle icicle) {
		Log.d(TAG, "onCreate");
		super.onCreate(icicle);
		intialize();
	}

}
