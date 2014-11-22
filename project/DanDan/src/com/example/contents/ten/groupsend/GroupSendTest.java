package com.example.contents.ten.groupsend;

import java.util.ArrayList;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class GroupSendTest extends Activity {

	private final static String TAG = "GroupSendTest";
	
	private Button mSelectBtn, mSendBtn;
	private EditText mNumber, mContent;
	private SmsManager mManager;
	private ArrayList<String> mSendList = new ArrayList<String>();
	
	private boolean isChecked(String phone)
	{
		for (String s1 : mSendList) {
			if (s1.equals(phone)) {
				return true;
				
			}
		}
		return false;
	}
	private void sendCallBack()
	{
		for (String number : mSendList) {
			PendingIntent pi = PendingIntent.getActivity(GroupSendTest.this,
					0, new Intent(), 0);
			mManager.sendTextMessage(number, null, mContent.getText().toString(), pi, null);
			Toast.makeText(GroupSendTest.this, "短信群发完毕", Toast.LENGTH_LONG).show();
		}
	}
	private void selectCallBack()
	{
		final Cursor cursor = getContentResolver()
				.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						null,
						null, 
						null);
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				Log.d(TAG, "getView positon=" + position);
				cursor.moveToPosition(position);
				CheckBox rb = new CheckBox(GroupSendTest.this);
				String number = cursor.getString(cursor.getColumnIndex(
						ContactsContract.CommonDataKinds.Phone.NUMBER)).replace("-", "");
				rb.setText(number);
				if (isChecked(number)) {
					rb.setChecked(true);
				}
				return rb;
			}
			
			@Override
			public long getItemId(int position) {
				Log.d(TAG,"getItemId position=" + position);
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				Log.d(TAG,"getItem position=" + position);
				return position;
			}
			
			@Override
			public int getCount() {
				Log.d(TAG,"getCount=" + cursor.getCount());
				return cursor.getCount();
			}
		};
		
		View selectView = getLayoutInflater().inflate(R.layout.ten_blackmain_line, null);
		final ListView listview = (ListView) selectView.findViewById(R.id.ten_blackmain_line_list);
		listview.setAdapter(adapter);
		new AlertDialog.Builder(GroupSendTest.this).setView(selectView)
			.setPositiveButton("sure", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.d(TAG,"DialogInterface onclicked");
				mSendList.clear();
				for (int i =0; i < listview.getCount(); i++) {
					CheckBox checkbox = (CheckBox)listview.getChildAt(i);
					if (checkbox.isChecked()) {
						mSendList.add(checkbox.getText().toString());
					}
				}
				mNumber.setText(mSendList.toString());
				
			}
		}).show();
	}
	private void initialize()
	{
		mManager = SmsManager.getDefault();
		mSelectBtn = (Button)findViewById(R.id.ten_group_send_main_select_btn);
		mSendBtn = (Button)findViewById(R.id.ten_group_send_main_send_btn);
		mNumber = (EditText)findViewById(R.id.ten_group_send_number_text);
		mContent = (EditText)findViewById(R.id.ten_group_send_content_text);
		
		if (mSelectBtn != null) {
			mSelectBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mSelectBtn buttion is onclicked");
					selectCallBack();
				}
			});
		}
		
		if (mSendBtn != null) {
			mSendBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mSendBtn is onclicked");
					sendCallBack();
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_group_send_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG,"onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
