package com.example.contents.ten.bindservice;

import com.example.dandan.R;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceTest extends Activity {

	private final String TAG = "BindServiceTest";
	private Button mBindServiceBtn;
	private Button mUnBindServiceBtn;
	private Button mGetInfoBtn;
	
	private BindService.MyBinder mBinder;
	
	private ServiceConnection mConn = new ServiceConnection()
	{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected name=" + name.toString());
			mBinder = (BindService.MyBinder)service;
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected name" + name.toString());
			
		}
		
	};	
	
	private void initializeComponent()
	{
		mBindServiceBtn = (Button)findViewById(R.id.ten_bind_service_main_bind_btn);
		mUnBindServiceBtn = (Button)findViewById(R.id.ten_bind_service_main_unbind_btn);
		mGetInfoBtn = (Button)findViewById(R.id.ten_bind_service_main_getInfo_btn);
		final Intent intent = new Intent();
		intent.setAction("com.example.contents.ten.bindservice.BindService");
		if (mBindServiceBtn != null) {
			mBindServiceBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mBindServiceBtn is onClicked bindService");
					bindService(intent, mConn, Service.BIND_AUTO_CREATE);
					
				}
			});
		}
		
		if (mUnBindServiceBtn != null) {
			mUnBindServiceBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mUnBindServiceBtn is onClicked and unbindService");
					unbindService(mConn);
				}
			});
		}
		
		if (mGetInfoBtn != null) {
			mGetInfoBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mGetInfoBtn OnClicked");
					if (mConn != null) {
						Toast.makeText(BindServiceTest.this,
								"ServiceµÄÖµÎª£º" + mBinder.getCount(),
								Toast.LENGTH_LONG)
								.show();
					}
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		setContentView(R.layout.ten_bind_service_main);
		super.onCreate(savedInstanceState);
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG,"onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
