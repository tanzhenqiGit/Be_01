/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÏÂÎç1:04:38
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-2 ÏÂÎç1:04:38 
* class declare 
*/ 
package com.example.contents;

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
abstract public class CommonListActivity <T> extends Activity {

	private final String TAG = "CommonListActivity";
	private ListView mList;
	private T [] mContents = null;
	/**
	 * @param mContent
	 */
	public CommonListActivity() {
		super();
	   
	}
	
	public boolean prepareContents(T[] content)
	{
		mContents = content;
		return true;
	}
	abstract public void handlerOnItemListClicked(AdapterView<?> parent, View view, int position, long id);
	abstract public void onPrepareContents();
	public void showList() throws IllegalAccessException
	{
		if (mContents == null) {
			throw new IllegalAccessException();
			
		}
		mList = (ListView)findViewById(R.id.listView);
		if (mList != null) {
			ArrayAdapter<T> adapter 
				= new ArrayAdapter<T>(
						CommonListActivity.this, 
						android.R.layout.simple_list_item_1, 
						mContents);
			mList.setAdapter(adapter);
			mList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					handlerOnItemListClicked(parent, view, position, id);
				}
			});
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);	
		onPrepareContents();
		try {
			showList();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}
	
	
	
}
