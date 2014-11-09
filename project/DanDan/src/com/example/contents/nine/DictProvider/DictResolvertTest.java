package com.example.contents.nine.DictProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DictResolvertTest extends Activity {
	
	private ContentResolver mContentResolver;
	private Button mInsert = null;
	private Button mSearch = null;
	private final String TAG = "ContentResolver";
	private void initializeComponent()
	{
		Log.d(TAG, "initialize");
		mContentResolver = getContentResolver();
		
		mInsert = (Button)findViewById(R.id.nine_dict_resolver_main_insert);
		if (mInsert != null) {
			mInsert.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "insert onClick");
					String word = ((EditText)findViewById(R.id.nine_dict_resolver_main_word))
							.getText().toString();
					String detail = ((EditText)findViewById(R.id.nine_dict_resolver_main_detail))
							.getText().toString();
					Log.d(TAG, "word:" + word + ",detail:" + detail);
					ContentValues values = new ContentValues();
					values.put(Words.Word.WORD, word);
					values.put(Words.Word.DETAIL, detail);
					
					mContentResolver.insert(Words.Word.DICT_CONTENT_URI, values);
					Toast.makeText(DictResolvertTest.this, "添加生词成功" ,
							Toast.LENGTH_LONG).show();
					
				}
			});
		}
		mSearch = (Button)findViewById(R.id.nine_dict_resolver_main_search);
		if (mSearch != null) {
			mSearch.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "search is onclick");
					String Key = ((EditText)findViewById(R.id.nine_dict_resolver_main_key)).getText().toString();
					Cursor cursor = mContentResolver.query(Words.Word.DICT_CONTENT_URI, null,
							"word like ? or detail like ?",
							new String[] {"%" + Key + "%", "%" + Key + "%"}, null);
				
					Bundle data = new Bundle();
					data.putSerializable("dat", converCursorToList(cursor));
					Intent intent = new Intent(DictResolvertTest.this,DictProviderResultActivity.class);
					intent.putExtras(data);
					startActivity(intent);

				}
			});
		}
		
	}
	
	private ArrayList<Map<String,String>> converCursorToList(Cursor cursor) 
	{
		ArrayList<Map<String,String>> result
			= new ArrayList<Map<String, String>>();
		while(cursor.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(Words.Word.WORD, cursor.getString(1));
			map.put(Words.Word.DETAIL, cursor.getString(2));
			result.add(map);
		}
		return result;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nine_dict_resolver_main);
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
