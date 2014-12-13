/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-13 …œŒÁ9:48:32.
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * @author Administrator
 *
 */
public class SearchViewActivity extends Activity
	implements SearchView.OnQueryTextListener{

	private final String TAG = "SearChViewActivity";
	private final String[] mStrings = new String[] {
			"AAAA","AABB", "BBBB", "BBCC", "CCCC", "CCDD","DDDD", "DDEE"
	};
	private ListView mList;
	private SearchView mSearchView;
	
	@SuppressLint({ "CutPasteId", "NewApi" })
	private void initialize()
	{
		mList = (ListView)findViewById(R.id.two_searchview_main_list);
		if (mList != null) {
			mList.setAdapter(new ArrayAdapter<String>(
					this, android.R.layout.simple_list_item_1,mStrings));
		}
		mSearchView = (SearchView)findViewById(R.id.two_searchview_main_search);
		if (mSearchView != null){
			mSearchView.setIconifiedByDefault(false);
			mSearchView.setOnQueryTextListener(this);
			mSearchView.setSubmitButtonEnabled(true);
			mSearchView.setQueryHint("≤È’“");
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_searchview_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	/* (non-Javadoc)
	 * @see android.widget.SearchView.OnQueryTextListener#onQueryTextChange(java.lang.String)
	 */
	@Override
	public boolean onQueryTextChange(String newText) {
		Log.d(TAG, "onQueryTextChange newText=" + newText);
		if (mList != null) {
			if (TextUtils.isEmpty(newText)) {
				Log.d(TAG, "clearTextFilter");
				mList.clearTextFilter();
			} else {
				Log.d(TAG, "setFilterText");
				mList.setFilterText(newText);
			}
		
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see android.widget.SearchView.OnQueryTextListener#onQueryTextSubmit(java.lang.String)
	 */
	@Override
	public boolean onQueryTextSubmit(String query) {
		Toast.makeText(this, "you choice :" + query, Toast.LENGTH_LONG).show();
		return false;
	}

}
