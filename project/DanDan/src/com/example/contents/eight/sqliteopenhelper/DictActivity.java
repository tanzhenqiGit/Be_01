/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-30
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-30 ÉÏÎç10:41:15
* @class DictActivity.java
*/ 
package com.example.contents.eight.sqliteopenhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author free
 *
 */
public class DictActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_sqlite_open_helper);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mDBHelper != null) {
			mDBHelper.close();
		}
	}
	
	private ContentValues parserContentValues(String word, String detail)
	{
		ContentValues values = new ContentValues();
		values.put("word", word);
		values.put("detail", detail);
		return values;
	}
	
	private void InsertData(SQLiteDatabase db , String word , String detail)
	{
		if (db != null && mDBHelper != null) {
			if (isWordExisted(db, word)) {
				updateData(db,word,detail);
				Toast.makeText(this, "update word:" + word + "\ndetail:" + detail,
						Toast.LENGTH_LONG).show();
			} else {
			    ContentValues values = parserContentValues(word, detail);
			    db.insert(mDBHelper.getSQLiteTableName(), null, values);
			    Toast.makeText(this, "insert word:" + word + "\ndetail:" + detail,
						Toast.LENGTH_LONG).show();
			}
		} else {
			Log.d(TAG, "InsertData db == null");
		}
	}
	
	private boolean isWordExisted(SQLiteDatabase db, String key)
	{
		if (db != null) {
			Cursor cursor = db.query(mDBHelper.getSQLiteTableName(), 
					null, 
					"word = ? ", 
					new String[] {key}, 
					null, 
					null, 
					null);
			if (cursor != null && cursor.getCount() >0 ) {
				Log.d(TAG, "isWordExited count =" + cursor.getCount());
				return true;
			}
			return false;
		} else {
			Log.d(TAG, "QueryData db == null, do nothing.");
			return false;
		}
	}
	
	private void updateData(SQLiteDatabase db, String word, String detail)
	{
		ContentValues values = new ContentValues();
		values.put("detail", detail);
		if (db != null && mDBHelper != null) {
			db.update(mDBHelper.getSQLiteTableName(), values, "word = ?", new String[]{word});
		} else {
			Log.d(TAG, "updateData db == null or mDBHelper == null");
		}
	}
	
	private Cursor QueryData(SQLiteDatabase db, String word)
	{
		Log.d(TAG, "QueryData word = " + word);
		if (db != null && mDBHelper != null) {
			Cursor cursor = db.query(mDBHelper.getSQLiteTableName(), 
					new String[] {"_id, word, detail"}, 
					"word like ?", 
					new String[] {"%" + word + "%"},
					null, 
					null, 
					null);
			Log.d(TAG, "QueryData end");
			return cursor;
		} else {
			Log.d(TAG, "QueryData db == null, do nothing.");
			return null;
		}
	}
	
	private void InsertCallBack(View source)
	{
		Log.d(TAG, "InsertCallBack is called.");
		if (mInsertWordTxt != null && mExplainTxt != null) {
			String word = mInsertWordTxt.getText().toString();
			String detail = mExplainTxt.getText().toString();
			if (word.equals("") || detail.equals("")) {
				Log.e(TAG, "InsertCallBack insert word os detail is empty, do nothing.");
				return;
			}
			if (mDBHelper != null) {
				InsertData(mDBHelper.getWritableDatabase(), word, detail);
			} else {
				Log.e(TAG, "mDBHelper is null, do nothing.");
			}
		}
	}
	
	private ArrayList<Map<String, String> > converCursorToList(Cursor cursor)
	{
		Log.d(TAG, "converCursorToList");
		ArrayList<Map<String, String>> result = new ArrayList<Map<String,String>>();
		if (cursor != null) {
			while(cursor.moveToNext())
			{
				Map<String, String> map = new HashMap<String, String>();
				map.put("word", cursor.getString(1));
				map.put("detail", cursor.getString(2));
				result.add(map);
			}
		} else {
			Log.d(TAG, "converCursorToList");
		}
		
		return result;
	}
	
	private void QueryCallBack(View source)
	{
		if (mQueryTxt != null && mDBHelper != null) {
			String word = mQueryTxt.getText().toString();
			Cursor cursor  = QueryData(mDBHelper.getReadableDatabase(), word);
			Bundle data = new Bundle();
			data.putSerializable("data", converCursorToList(cursor));
			Intent intent = new Intent(DictActivity.this, ResultActivity.class);
			intent.putExtras(data);
			startActivity(intent);

		}
	}
	
	
	private void initialize()
	{
		Log.d(TAG, "intialize is start");
		mInsertWordTxt = (EditText) findViewById(R.id.eight_sqlite_open_helper_word_txt);
		mExplainTxt = (EditText) findViewById(R.id.eight_sqlite_open_helper_explain_txt);
		mQueryTxt = (EditText) findViewById(R.id.eight_sqlite_open_helper_query_txt);
		
		mInsertBtn = (Button) findViewById(R.id.eight_sqlite_open_helper_insert_btn);
		if (mInsertBtn != null) {
			mInsertBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					InsertCallBack(v);
				}
			});
		}
		
		mQueryBtn = (Button) findViewById(R.id.eight_sqlite_open_helper_query_btn);
		if (mQueryBtn != null) {
			mQueryBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					QueryCallBack(v);
				}
			});
		}
		
		mDBHelper = new MySQLiteOpenHelper(this, "SQLiteOpenHelper.db3", 1);
	}
	
	public final String TAG = "DictActivity";
	MySQLiteOpenHelper mDBHelper;
	
	private Button mInsertBtn, mQueryBtn;
	private EditText mInsertWordTxt, mExplainTxt, mQueryTxt;

	
}
