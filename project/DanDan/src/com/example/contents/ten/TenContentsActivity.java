package com.example.contents.ten;

import com.example.contents.ten.firstService.FirstServiceTest;
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

public class TenContentsActivity extends Activity {

	private String TAG = "TenContentsActivity";
	private ListView mListView = null;
	private final int FIRST_SERVICE = 0;
	private void initializeComponent()
	{
		Log.d(TAG, "initializeComponent");
		mListView = (ListView)findViewById(R.id.listView);
		String[] Contents = getResources().getStringArray(R.array.chapterTenContents);
		
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(TenContentsActivity.this,
						android.R.layout.simple_list_item_1, Contents);
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View source, int position,
					long id) {
				switch(position) {
				case FIRST_SERVICE:
					Intent first_service_intent = 
						new Intent(TenContentsActivity.this,
								FirstServiceTest.class);
					startActivity(first_service_intent);
					break;
				}
				
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initializeComponent();
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
