package com.example.contents.ten.MonitorPhont;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;


import com.example.dandan.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.Toast;

public class MonitorPhone extends Activity {

	private final String TAG = "MonitorPhone";
	private TelephonyManager mTMgr;
	
	
	private void initializeComponent()
	{
		mTMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		PhoneStateListener listener = new PhoneStateListener()
		{

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				Log.d(TAG,"onCallStateChange state=" + state + ",incomingNumber" + incomingNumber);
				switch (state) {
				case TelephonyManager.CALL_STATE_IDLE:
					Log.d(TAG, "onCallStateChange CALL_STATE_IDLE");
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:
					Log.d(TAG, "onCallStateChange CALL_STATE_OFFHOOK");
					break;
				case TelephonyManager.CALL_STATE_RINGING:
					Log.d(TAG, "onCallStateChange CALL_STATE_RINGING");
					OutputStream os = null;
					try {
						os = openFileOutput("phoneList", MODE_APPEND);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					PrintStream ps = new PrintStream(os);
					ps.print(new Date() + "call:" + incomingNumber);
					ps.close();
					Toast.makeText(MonitorPhone.this, 
							new Date() + "call:" + incomingNumber, 
							Toast.LENGTH_LONG).show();
					break;
				default:
					Log.d(TAG, "onCallStateChange default");
					break;
				}
				super.onCallStateChanged(state, incomingNumber);
			}
			
		};
		
		mTMgr.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_monitor_phone_main);
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
