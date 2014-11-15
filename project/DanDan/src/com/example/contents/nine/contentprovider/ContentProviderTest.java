package com.example.contents.nine.contentprovider;

import java.util.ArrayList;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

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
					String name = cursor.getString(cursor.getColumnIndex(
							ContactsContract.Contacts.DISPLAY_NAME));
					names.add(name);
					Log.d(TAG,"name = " +name);
					Log.d(TAG, "ID = " + contactId);
					
					Cursor phones = getContentResolver()
							.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
									null, 
									ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ " = " + contactId,
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
						String emailAddress = emails.getString(emails.getColumnIndex(
								ContactsContract.CommonDataKinds.Email.DATA));
						detail.add("邮件地址：" + emailAddress);
						
					}
					emails.close();
					details.add(detail);
				}
				cursor.close();
				
				View resultDialog = getLayoutInflater()
						.inflate(R.layout.nine_content_provider_result, null);
				ExpandableListView list = (ExpandableListView) resultDialog
						.findViewById(R.id.nine_content_provider_result_list);
				ExpandableListAdapter adapter = new ExpandableListAdapter() {
					
					private TextView getTextView()
					{
						AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
								ViewGroup.LayoutParams.MATCH_PARENT,64);
						TextView textView = new TextView(ContentProviderTest.this);
						textView.setLayoutParams(lp);
						textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
						textView.setPadding(36, 0, 0, 0);
						textView.setTextSize(20);
						return textView;
					}
					
					@Override
					public void unregisterDataSetObserver(DataSetObserver observer) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void registerDataSetObserver(DataSetObserver observer) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onGroupExpanded(int groupPosition) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onGroupCollapsed(int groupPosition) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public boolean isEmpty() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public boolean isChildSelectable(int groupPosition, int childPosition) {
						Log.d(TAG, "ischildSelectable groupPosition=" 
							+ groupPosition + "childPosition=" + childPosition);
						
						return true;
					}
					
					@Override
					public boolean hasStableIds() {
						Log.d(TAG, "hasStableIds");
						return true;
					}
					
					@Override
					public View getGroupView(int groupPosition, boolean isExpanded,
							View convertView, ViewGroup parent) {
						Log.d(TAG, "getGroupView groupPosition="+groupPosition);
						TextView textView = getTextView();
						textView.setText(getGroup(groupPosition).toString());
						return textView;
					}
					
					@Override
					public long getGroupId(int groupPosition) {
						Log.d(TAG, "getGroupId groupPosition=" + groupPosition);
						
						return groupPosition;
					}
					
					@Override
					public int getGroupCount() {
						Log.d(TAG,"getGroupCount is called");
						
						return names.size();
					}
					
					@Override
					public Object getGroup(int groupPosition) {
						Log.d(TAG, "getGroup groupPosition=" + groupPosition);
						
						return names.get(groupPosition);
					}
					
					@Override
					public long getCombinedGroupId(long groupId) {
						// TODO Auto-generated method stub
						return 0;
					}
					
					@Override
					public long getCombinedChildId(long groupId, long childId) {
						// TODO Auto-generated method stub
						return 0;
					}
					
					@Override
					public int getChildrenCount(int groupPosition) {
						Log.d(TAG, "getChildrenCount groupPosition:" + groupPosition);
						
						return details.get(groupPosition).size();
					}
					
					@Override
					public View getChildView(int groupPosition, int childPosition,
							boolean isLastChild, View convertView, ViewGroup parent) {
						Log.d(TAG, "getChildView groupPosition=" 
							+ groupPosition + ",childPosition=" + childPosition);
						TextView textView = getTextView();
						textView.setText(getChild(groupPosition, childPosition).toString());
						return textView;
					}
					
					
					@Override
					public long getChildId(int groupPosition, int childPosition) {
						Log.d(TAG, "getChildId childPosition" +
							childPosition +"groupPosition:" + groupPosition);
						return childPosition;
					}
					
					@Override
					public Object getChild(int groupPosition, int childPosition) {
						Log.d(TAG, "getChind groupPosition:"
					        + groupPosition + ",childPosition:" + childPosition);
						return details.get(groupPosition).get(childPosition);
					}
					
					@Override
					public boolean areAllItemsEnabled() {
						// TODO Auto-generated method stub
						return false;
					}
				};
				list.setAdapter(adapter);
				new AlertDialog.Builder(ContentProviderTest.this)
				   .setView(resultDialog).setPositiveButton("确定", null)
				   .show();
			}
		});
		
		mAddBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = ((EditText) findViewById(R.id.nine_content_provider_name_text))
						.getText().toString();
				String phone = ((EditText) findViewById(R.id.nine_content_provider_number_text))
						.getText().toString();
				String email = ((EditText) findViewById(R.id.nine_content_provider_email_text))
						.getText().toString();
				ContentValues values = new ContentValues();
				Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
				long rawContactId = ContentUris.parseId(rawContactUri);
				values.clear();
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
				values.put(StructuredName.GIVEN_NAME, name);
				getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI,
						values);
				values.clear();
				
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
				values.put(Phone.NUMBER, phone);
				values.put(Phone.TYPE, Phone.TYPE_MOBILE);
				getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI, 
						values);
				
				values.clear();
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				values.put(Data.MIMETYPE, Email.CONTENT_ITEM_TYPE);
				values.put(Email.DATA, email);
				values.put(Email.TYPE, Email.TYPE_WORK);
				getContentResolver().insert(android.provider.ContactsContract.Data.CONTENT_URI,
						values);
				Toast.makeText(ContentProviderTest.this, 
						"联系人数据添加成功", Toast.LENGTH_LONG).show();
				
				
				
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
