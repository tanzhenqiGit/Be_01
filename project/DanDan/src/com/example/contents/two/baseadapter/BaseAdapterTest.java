/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-3 下午10:00:31.
*/ 
package com.example.contents.two.baseadapter;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class BaseAdapterTest extends Activity {

	private final String TAG = "BaseAdapterTest";
	
	private ListView mList;
	private void initialize()
	{
		mList = (ListView)findViewById(R.id.listView);
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(BaseAdapterTest.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ImageView image = new ImageView(BaseAdapterTest.this);
				image.setImageResource(R.drawable.p);
				TextView text = new TextView(BaseAdapterTest.this);
				text.setText("第" + (position + 1) + "个列表项");
				text.setTextSize(20);
				text.setTextColor(Color.RED);
				ll.addView(image);
				ll.addView(text);
				return ll;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {

				return null;
			}
			
			@Override
			public int getCount() {
				return 40;
			}
		};
		
		mList.setAdapter(adapter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "BaseAdapterTest");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

}
