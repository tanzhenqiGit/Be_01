package com.example.contents.nine.DictProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	private final String TAG = "MyDatabaseHelper";
	
	private final String CREATE_TABLE_SQL 
	= "create table dict(_id integer primary key autoincrement , word , detail)";
	
	public MyDatabaseHelper(Context context, String name,
			 int version) {
		super(context, name, null, version);
		Log.d(TAG, "MyDataBaseHelper construct.");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SQL);
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Log.d(TAG, "onUpgrade");
		
	}

}
