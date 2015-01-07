/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÉÏÎç10:03:28
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-2 ÉÏÎç10:03:28 
* class declare 
*/ 
package com.example.contents.thirteen;

import com.example.contents.thirteen.http.MultiThreadDownActivity;
import com.example.contents.thirteen.multi.MutiThreadClient;
import com.example.contents.thirteen.postutil.GetPostMainActivity;
import com.example.contents.thirteen.simpleclient.SimpleClient;
import com.example.contents.thirteen.url.URLClient;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
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
	private final int SIMPLE_CLIENT = 0;
	private final int MULTI_THREAD_CLIENT = 1;
	private final int URL_CLIENT = 2;
	private final int HTTP_GET_POST = 3;
	private final int HTTP_MULT_THREAD_DOWNLOAD = 4;
	
	private void ListCallBack()
	{
		if (mListView != null) {
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position) {
					case SIMPLE_CLIENT:
						Intent simple_client_intent = new Intent(ThirteenContentsActivity.this, 
								SimpleClient.class);
						startActivity(simple_client_intent);
						break;
					case MULTI_THREAD_CLIENT:
						Intent multi_thread_client_intent = new Intent(ThirteenContentsActivity.this, 
								MutiThreadClient.class);
						startActivity(multi_thread_client_intent);
						break;
					case URL_CLIENT:
						Intent url_client_intent = new Intent(ThirteenContentsActivity.this, 
								URLClient.class);
						startActivity(url_client_intent);
						break;
					case HTTP_GET_POST:
						Intent http_get_post_intent = new Intent(ThirteenContentsActivity.this, 
								GetPostMainActivity.class);
						startActivity(http_get_post_intent);
						break;
					case HTTP_MULT_THREAD_DOWNLOAD:
						Intent http_mult_thread_donw_intent = new Intent(ThirteenContentsActivity.this, 
								MultiThreadDownActivity.class);
						startActivity(http_mult_thread_donw_intent);
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
