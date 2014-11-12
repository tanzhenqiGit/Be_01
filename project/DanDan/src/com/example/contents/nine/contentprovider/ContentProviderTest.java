package com.example.contents.nine.contentprovider;

import java.util.ArrayList;

import com.example.dandan.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContentProviderTest extends Activity {

	private String TAG = "ContentProviderTest";
	private Button mAddBtn;
	private Button mSearchBtn;
	private void initializeConponent()
	{
		Log.d(TAG, "initializeConponent");
		mAddBtn = (Button)findViewById(R.id.nine_content_provider_add);
		if (mAddBtn == null) {
			Log.e(TAG, "get nine_content_provider_add is null");
			return;
		}
		
		mSearchBtn = (Button)findViewById(R.id.nine_content_provider_search);
		if (mSearchBtn == null) {
			Log.e(TAG, "get nine_content_provider_search is null");
			return;
		}
		setButtonListener();
	}
	
	private void setButtonListener()
	{
		mSearchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final ArrayList<String> names = new ArrayList<String>();
				final ArrayList<ArrayList<String>> details = new ArrayList<ArrayList<String>>();
				
				Cursor cursor = getContentResolver()
						.query(ContactsContract.Contacts.CONTENT_URI,
								null, null, null, null);
				while(cursor.moveToNext())
				{
					String contactId = cursor.getString(cursor.getColumnIndex(
							ContactsContract.Contacts._ID));
					String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					names.add(name);
					Log.d(TAG,"name = " +name);
					Log.d(TAG, "ID = " + contactId);
					
					Cursor phones = getContentResolver()
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
									null, 
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
									null,
									null);
					ArrayList<String> detail = new ArrayList<String>();
					while(phones.moveToNext()) {
						String phoneNumber = phones.getString(
								phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						detail.add("number:" + phoneNumber);
						
					}
					phones.close();
					
					Cursor emails = getContentResolver().query(
							ContactsContract.CommonDataKinds.Email.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId,
							null, null);
					
					while(emails.moveToNext()) {
						String emailAddress = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
						
					}
				}
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ninie_content_provider);
		Log.d(TAG, "onCreate");
		initializeConponent();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
