/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-30
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-30 ÉÏÎç10:33:43
* @class MySQLiteOpenHelper.java
*/ 
package com.example.contents.eight.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author free
 *
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public MySQLiteOpenHelper(Context context, String name, int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		if (db != null) {
			db.execSQL(CREATE_TABLE);
			Log.d(TAG, "onCreate create table is end.");
		} else {
			Log.e(TAG, "onCreate db == null");
		}
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(TAG, "onUpgrade oldVersion:" + oldVersion + "-->" + "newVersion:" + newVersion);
	}
	
	public final String getSQLiteTableName()
	{
		return TABLE_NAME;
	}
	
	public final String CREATE_TABLE = "create table Dict(_id integer primary key autoincrement , word , detail)";

	private final String TABLE_NAME = "Dict";
	
	private final String TAG = "MySQLiteOpenHelper";
}
