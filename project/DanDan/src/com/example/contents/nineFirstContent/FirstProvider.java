package com.example.contents.nineFirstContent;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class FirstProvider extends ContentProvider {

	private String TAG = "FirstProvider";
	
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		Log.d(TAG, "FirstProvider::delete where:" + where);
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		Log.d(TAG, "FirstProvider::getType");
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues Values) {
		Log.d(TAG, "FirstProvider::insert Values:" + Values);
		return null;
	}

	@Override
	public boolean onCreate() {
		Log.d(TAG, "FirstProvider::onCreate");
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String where, String[] whereArgs,
			String sortOrder) {
		Log.d(TAG, "FirstProvider::query where =" + where);
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues Values, String where, String[] whereArgs) {
		Log.d(TAG, "FirstProvider::update Values:" + Values + ",where:" + where);
		return 0;
	}

}
