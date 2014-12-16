/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-16
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-16 上午11:26:37
* @class SysActionActivity.java
*/ 
package com.example.contents.five.sysaction;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class SysActionActivity extends Activity {

	private final String TAG = "SysActionActivity";
	final int PICK_CONTACT = 0;
	private Button mCheckContactBtn;
	private EditText mContactTxt, mNumberTxt;
	
	private void handOnActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (requestCode) {
		case PICK_CONTACT:
			if (resultCode == Activity.RESULT_OK) {
				Uri contactData = data.getData();
				@SuppressWarnings("deprecation")
				Cursor cursor = managedQuery(contactData, null, null, null, null);
				if (cursor == null) {
					Log.d(TAG, "cursor == null");
					return ;
				}
				if (cursor.moveToFirst())
				{
					String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
					String name = cursor.getString(
							cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
					Log.d(TAG, "contactId=" + contactId + ",name="+name);
					String phoneNumber = "此联系人暂未输入电话号码";
					Cursor phones = getContentResolver().query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null, 
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = " + contactId,
							null,
							null);
					Log.d(TAG, "phones="+phones);
					if (phones.moveToFirst())
					{
						phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						Log.d(TAG, "phoneNumber="+phoneNumber);
					} else {
						Log.d(TAG, "phones move to first return false");
					}
					phones.close();
					if (mContactTxt != null) {
						mContactTxt.setText(name);
					}
					
					if (mNumberTxt != null) {
						mNumberTxt.setText(phoneNumber);
					}

				}
				cursor.close();
			}
			break;
		default:
			
			break;
		}
	}
	
	private void initialize()
	{
		mContactTxt = (EditText) findViewById(R.id.five_sys_action_main_contact_txt);
		mNumberTxt = (EditText) findViewById(R.id.five_sys_action_main_number_txt);
		mCheckContactBtn = (Button) findViewById(R.id.five_sys_action_main_show_contact_btn);
		if (mCheckContactBtn != null) {
			mCheckContactBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_GET_CONTENT);
					intent.setType("vnd.android.cursor.item/phone");
					startActivityForResult(intent, PICK_CONTACT);
					
				}
			});
		}
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_sys_action_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "onActivityResult is called");
		super.onActivityResult(requestCode, resultCode, data);
		handOnActivityResult(requestCode, resultCode, data);
	}

	
	
}
