/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-29
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-29 ÏÂÎç4:33:15
* @class HandleSQLiteActivity.java
*/ 
package com.example.contents.eight.sqlite;

import java.io.File;

import com.example.dandan.R;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * @author free
 *
 */
public class HandleSQLiteActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestory");
		super.onDestroy();
		if (mSQLite != null && mSQLite.isOpen()) {
			Log.d(TAG,"close SQLite");
			mSQLite.close();
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_handle_sqlite);
		initialize();
	}

	void createSQLiteDatabase(File path)
	{
		if (path != null) {
			String SQLiteName = path.getAbsolutePath() + SQLITE_NAME;
			Log.d(TAG, "createSQLiteDatabase");
			mSQLite = SQLiteDatabase.openOrCreateDatabase(SQLiteName, null);
		} else {
			Log.d(TAG, "createSQLiteDatabase path == null, do nothing");
		}
	}
	
	void createSQLiteTable(SQLiteDatabase db)
	{
		if (db != null) {
			db.execSQL("create table news_inf(_id integer primary key autoincrement, "
					+ "news_title varchar(50), "
					+ "news_content varchar(255))");
			Log.d(TAG, "creatSQLIteTable is succeed.");
		} else {
			Log.e(TAG, "createSQLiteTable db == null, do nothing.");
		}
	}
	
	void deleteData(SQLiteDatabase db, String key, String value)
	{
		if (db != null && key != null && value != null)
		{
			db.execSQL("insert into news_inf values(null, ? , ?)", new String[] {key, value});
			Log.d(TAG, "deleteData key:" + key + ",value:" + value);
			Cursor cursor = db.rawQuery("select * from news_inf", null);
			inflateList(cursor);
		} else {
			Log.e(TAG, "deleteData some error ocurred");
		}
	}
	
	void insertData(SQLiteDatabase db, String key, String value)
	{
		if (db != null && key != null && value != null)
		{
			db.execSQL("insert into news_inf values(null, ? , ?)", new String[] {key, value});
			Log.d(TAG, "insertData key:" + key + ",value:" + value);
			Cursor cursor = db.rawQuery("select * from news_inf", null);
			inflateList(cursor);
		} else {
			Log.e(TAG, "insertData some error ocurred");
		}
	}
	
	
	void deleteBtnCallBack(View source)
	{
		String key = null, value = null;
		if ((mKeyTxt != null) && (mValueTxt != null)) {
			key = mKeyTxt.getText().toString();
			value = mValueTxt.getText().toString();
			deleteData(mSQLite, key, value);
		}
		
	}
	
	void queryBtnCallBack(View source)
	{
		if (mSQLite != null) {
			Log.d(TAG, "queryBtnCallBack is start");
			Cursor cursor = mSQLite.rawQuery("select * from news_inf", null);
			inflateList(cursor);
		} else {
			Log.d(TAG, "queryBtnCallBack mSQLite == null");
		}
	}
	
	void insertBtnCallBack(View source)
	{
		String key = null,value = null;
		if ((mKeyTxt != null) && (mValueTxt != null)) 
		{
			key = mKeyTxt.getText().toString();
			value = mValueTxt.getText().toString();
			if (mSQLite != null) {
				try {
					insertData(mSQLite, key, value);
					
				} catch (SQLiteException e) {
					createSQLiteTable(mSQLite);
					insertData(mSQLite, key, value);
				}
			} else {
				Log.d(TAG,"insertBtnCallBack mSQLite == null");
			}
		}
	}
	
	private void inflateList(Cursor cursor)
	{
		if (cursor != null) {
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sa = new SimpleCursorAdapter(
					this, 
					R.layout.eight_handle_sqlite_line,
					cursor, new String[] {"news_title", "news_content"},
					new int []{R.id.eight_handle_sqlite_line_key,
							R.id.eight_handle_sqlite_line_value});
			if (mList != null) {
				mList.setAdapter(sa);
			}
		} else {
			Log.d(TAG, "inflateList cursor == null");
		}
	}
	
	private void initialize()
	{
		mKeyTxt = (EditText) findViewById(R.id.eight_handl_sqlite_key_txt);
		mValueTxt = (EditText) findViewById(R.id.eight_handle_sqlite_value_txt);
		mList = (ListView) findViewById(R.id.eight_handle_sqlite_list);
		
		mInsertBtn = (Button) findViewById(R.id.eight_handle_sqlite_insert_btn);
		if (mInsertBtn != null) {
			mInsertBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					insertBtnCallBack(v);
				}
			});
		}
		
		mDeleteBtn = (Button) findViewById(R.id.eight_handle_sqlite_delete_btn);
		if (mDeleteBtn != null) {
			mDeleteBtn.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					deleteBtnCallBack(v);
				}
				
			});
		}
		
		mQueryBtn = (Button) findViewById(R.id.eight_handle_sqlite_query_btn);
		if (mQueryBtn != null) {
			mQueryBtn.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					queryBtnCallBack(v);
				}
				
			});
		}
		File path = getFilesDir();
		createSQLiteDatabase(path);

	}
	
	private final String TAG = "HandleSQLiteActivity";
	private final String SQLITE_NAME = "/SQLiteTest.db3";
	private EditText mKeyTxt, mValueTxt;
	private Button mInsertBtn, mDeleteBtn, mQueryBtn;
	private ListView mList;
	private SQLiteDatabase mSQLite;
	
}
