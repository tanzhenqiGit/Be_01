/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-3 下午9:12:10.
*/ 
package com.example.contents.two.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author Administrator
 *
 */
public class SimpleAdapterTest extends Activity {

	private final String TAG = "SimpleAdapterTest";
	private String[] mNames = {
			"张三","李四","王五","八六"
	};
	
	private String[] mDescs = {
			"可爱的小孩","擅长跳舞的帅哥","傻逼一个","纯屌丝一个"
	};
	
	private int [] mImages = new int[]{
		R.drawable.zhangsan,
		R.drawable.lisi,
		R.drawable.wangwu,
		R.drawable.baliu
	};
	
	private void initialize()
	{
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < mNames.length; i++) 
		{
			Map<String, Object> list = new HashMap<String, Object>();
			list.put("header", mImages[i]);
			list.put("personName", mNames[i]);
			list.put("desc", mDescs[i]);
			listItems.add(list);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(
				this, 
				listItems, 
				R.layout.two_simpleadapter_item, 
				new String[] {"personName","header","desc"}, 
				new int[]{R.id.two_simpleadapter_item_name,
						R.id.two_simpleadapter_item_header,
						R.id.two_simpleadapter_item_desc});
		ListView list = (ListView)findViewById(R.id.listView);
		list.setAdapter(simpleAdapter);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

	
}
