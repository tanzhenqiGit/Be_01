package com.example.contents.nineFirstContent;

import com.example.dandan.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FirstResolver extends Activity {

	private String TAG = "FirstResolver";
	private ContentResolver mContentResolver;
	private Uri mUri 
	   = Uri.parse("content://com.example.contents.nineFirstContent");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "FirstResolver::onCreate");
        setContentView(R.layout.nine_first_content);
		mContentResolver = getContentResolver();
	}
	
	public void query(View source)
	{
		Log.d(TAG, "query");
		Cursor c = mContentResolver.query(mUri, null, "query_where", null, null);
		Toast.makeText(this, "Զ��ContentProvider����CursorΪ:"
		+ c, Toast.LENGTH_LONG).show();
	}
	
	public void insert(View Source)
	{
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", "dandan");
		Uri newUri = mContentResolver.insert(mUri, contentValues);
		Toast.makeText(this, "Զ��ContentProvider�²����¼��UriΪ:" + newUri,
				Toast.LENGTH_LONG).show();
	}
	
	public void update(View Source)
	{
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", "dandan");
		int count = mContentResolver.update(mUri, contentValues, "update_where", null);
	    Toast.makeText(this, "Զ��ContentProvider��update�ķ���ֵ:" + count,
	    		Toast.LENGTH_LONG).show();
	}

	public void delete(View Source)
	{
		int count = mContentResolver.delete(mUri, "delete_where", null);
		Toast.makeText(this, "Զ��ContentProvider��delete�ķ���ֵ:"
		+ count, Toast.LENGTH_LONG).show();
	}
}
