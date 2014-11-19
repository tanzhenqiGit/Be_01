package com.example.contents.ten.smsmanager;

import com.example.dandan.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsManagerTest extends Activity {

	private final String TAG = "SmsManagerTest";
	private EditText mNumber, mContent;
	private Button mSendManagerBtn;
	private SmsManager mManager;
	
	private void initialize()
	{
		mManager = SmsManager.getDefault();
		mNumber = (EditText)findViewById(R.id.ten_smsmanager_main_number_text);
		mContent = (EditText)findViewById(R.id.ten_smsmanager_main_content_text);
		mSendManagerBtn = (Button)findViewById(R.id.ten_smsmanager_main_send_msg_btn);
		
		if (mSendManagerBtn == null) {
			Log.d(TAG, "mSendManagerBtn == null, retrun");
			return;
		}
		
		mSendManagerBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "mSendManagerBtn is onclicked");
				PendingIntent pi =  PendingIntent.getActivity(SmsManagerTest.this, 0, new Intent(), 0);
				mManager.sendTextMessage(mNumber.getText().toString(), 
						null,
						mContent.getText().toString(), 
						pi,
						null);
				Toast.makeText(SmsManagerTest.this, "短信发送完成", Toast.LENGTH_LONG).show();
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_smsmanager_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
