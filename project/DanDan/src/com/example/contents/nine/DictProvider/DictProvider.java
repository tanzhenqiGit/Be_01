package com.example.contents.nine.DictProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class DictProvider extends ContentProvider {

	private final String TAG = "DictProvider";
    private MyDatabaseHelper mDBOpenHelper;
    private static UriMatcher mMatch = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int WORDS = 1;
    private static final int WORD = 2;
    static
    {
    	mMatch.addURI(Words.AUTHORITY, "words", WORDS);
    	mMatch.addURI(Words.AUTHORITY, "word/#", WORD);
    }
    
	@Override
	public boolean onCreate() {
		Log.d(TAG, "onCreate");
		mDBOpenHelper = new MyDatabaseHelper(this.getContext(), "myDict.db3", 1);
		return true;
	}
	
	@Override
	public String getType(Uri uri) {
		Log.d(TAG,"getType");
		switch(mMatch.match(uri))
		{
		case WORDS:
			return "vnd.android.cursor.dir/com.example.contents.nine.DictProvider";
		case WORD:
			return "vnd.android.cursor.item/com.example.contents.nine.DictProvider";
		default:
			throw new IllegalArgumentException("unKnow Uri:" + uri);
		}
	}

	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		Log.d(TAG,"delete");
		SQLiteDatabase db = mDBOpenHelper.getReadableDatabase();
		int num = 0;
		switch(mMatch.match(uri)) {
		case WORDS:
			num = db.delete("dict", selection, selectionArgs);
			break;
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" + id;
			if (selection != null && !selection.equals("")) {
				whereClause = whereClause + " and " + selection;
			}
			num = db.delete("dict", whereClause, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("delete UnKnow Uri:" + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return num;
	}


	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Log.d(TAG,"insert");
		SQLiteDatabase db = mDBOpenHelper.getReadableDatabase();
		switch (mMatch.match(uri))
		{
		case WORDS:
			long rowId = db.insert("dict", Words.Word._ID, values);
			if (rowId > 0) {
				Uri wordUri = ContentUris.withAppendedId(uri, rowId);
				getContext().getContentResolver().notifyChange(wordUri, null);
				return wordUri;
			}
		case WORD:
		default:
			throw new IllegalArgumentException("insert UnKnow Uri:" + uri);
		}

	}



	@Override
	public Cursor query(Uri uri, String[] projection, String where,
			String[] selectionArgs, String sortOrder) {
		Log.d(TAG,"query");
		SQLiteDatabase db = mDBOpenHelper.getReadableDatabase();
		switch(mMatch.match(uri))
		{
		case WORDS:
			return db.query("dict",
					projection,
					where, 
					selectionArgs,
					null, 
					null, 
					sortOrder);
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" +id;
			if (where != null && !"".equals(where)) {
				whereClause = whereClause + " and " + where;
			}
			return db.query("dict",
					projection, 
					where, 
					selectionArgs, 
					null, 
					null, 
					sortOrder);
			
		default:
			throw new IllegalArgumentException("query unkown Uri:" + uri);
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		Log.d(TAG,"update");
		SQLiteDatabase db = mDBOpenHelper.getWritableDatabase();
		int num = 0;
		switch(mMatch.match(uri))
		{
		case WORDS:
			num = db.update("dict", values, selection, selectionArgs);
			break;
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" +id;
			if (selection != null && !selection.equals("")) {
				whereClause = whereClause + " and " + selection;
			}
			num = db.update("dict", values, whereClause, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("update Unknow Uri:" + uri);
			
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return num;
	}

}
