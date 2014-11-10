package com.example.contents.nine.DictProvider;

import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DictProviderResultActivity extends Activity
{
	private String TAG = "DictProviderResultActivity";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nine_dict_resolver_result);
		ListView listView = (ListView) findViewById(R.id.nine_dict_resolver_result_show);
		Intent intent = getIntent();
		//获取该intent所携带的数据
		Bundle data = intent.getExtras();
		//从Bundle数据包中取出数据
		@SuppressWarnings("unchecked")
		List<Map<String , String>> list = 
			(List<Map<String , String>>)data.getSerializable("data");
		if (list == null) {
			Log.d(TAG, "list:NULL");
			return;
		}
		Log.d(TAG, "list.size:" + list.size());
		//将List封装成SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(
				DictProviderResultActivity.this , list
			, R.layout.nine_dict_resolver_line , new String[]{"word" , "detail"}
			, new int[]{R.id.nine_dict_resolver_line_word ,
						R.id.nine_dict_resolver_line_detail});
		//填充ListView
		if (listView != null && adapter != null) {
		    listView.setAdapter(adapter);
		} else {
			Log.d(TAG, "listView" + listView.toString() + adapter.toString());
			
		}
			
	}
}
