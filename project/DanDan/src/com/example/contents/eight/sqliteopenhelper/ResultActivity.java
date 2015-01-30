/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-30
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-30 ÏÂÎç3:22:40
* @class ResultActivity.java
*/ 
package com.example.contents.eight.sqliteopenhelper;

import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;


/**
 * @author free
 *
 */
public class ResultActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_dict_result_main);
		initialize();
	}
	
	private void initialize()
	{
		Log.d(TAG, "initialize()");
		mList = (ListView) findViewById(R.id.eight_dict_result_list);
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String,String>>)data.getSerializable("data");
		
		SimpleAdapter adapter = new SimpleAdapter(
				this, 
				list, 
				R.layout.eight_dict_result_line, 
				new String[]{"word", "detail"}, 
				new int[] {R.id.eight_dict_result_line_word_txt,R.id.eight_dict_result_line_explain_txt});
		if (mList != null) {
			mList.setAdapter(adapter);
		}
	}
	
	public final String TAG = "ResultActivity";
	private ListView mList;
	

}
