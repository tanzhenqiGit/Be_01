package com.example.contents.ten.aidlservice;

import com.example.dandan.R;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AidlClient extends Activity {

	private final String TAG = "AidlClient";
	private ICat mCatService;
	private Button mGetServiceBtn;
	private EditText mColorText;
	private EditText mWeightText;
	
	private ServiceConnection mConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected name=" + name.toString());
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected name=" + name.toString());
			mCatService = ICat.Stub.asInterface(service);
		}
	};
	
	private void initializeComponent()
	{
		mGetServiceBtn = (Button)findViewById(
				R.id.ten_aidl_service_main_getServiceStsBtn);
		mColorText = (EditText)findViewById(
				R.id.ten_aidl_service_main_color_text);
		mWeightText = (EditText)findViewById(
				R.id.ten_aidl_service_main_weight_text);
		Intent intent = new Intent();
		intent.setAction("com.example.contents.ten.aidlservice.AidlService");
		bindService(intent, mConn, Service.BIND_AUTO_CREATE);
		
		if (mGetServiceBtn != null) {
			mGetServiceBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mGetServiceBtn onClicked");
					if (mColorText != null) {
						try {
							mColorText.setText(mCatService.getColor());
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (mWeightText != null) {
						try {
							mWeightText.setText(mCatService.getWeight() + "");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_aidl_client_main);
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextmenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
		unbindService(mConn);
	}

	
}
