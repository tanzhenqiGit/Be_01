package com.example.contents.nine.DictProvider;

import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DictProviderResultActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nine_dict_resolver_result);
		ListView listView = (ListView)findViewById(R.id.nine_dict_resolver_result_show);
		Intent intent = getIntent();
		//��ȡ��intent��Я��������
		Bundle data = intent.getExtras();
		//��Bundle���ݰ���ȡ������
		@SuppressWarnings("unchecked")
		List<Map<String , String>> list = 
			(List<Map<String , String>>)data.getSerializable("data");
		//��List��װ��SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(
				DictProviderResultActivity.this , list
			, R.layout.nine_dict_resolver_line , new String[]{"word" , "detail"}
			, new int[]{R.id.nine_dict_resolver_line_word ,
						R.id.nine_dict_resolver_line_detail});
		//���ListView
		listView.setAdapter(adapter);
	}
}
