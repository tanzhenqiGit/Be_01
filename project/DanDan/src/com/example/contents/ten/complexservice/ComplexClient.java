package com.example.contents.ten.complexservice;

import java.util.List;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ComplexClient extends Activity {

	private final String TAG = "ComplexClient";
	private IPet mPetService;
	private Button mGetServiceInfo;
	private ListView mListView;
	private EditText mInputText;
	
	private ServiceConnection mConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected");
			mPetService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected");
			mPetService = IPet.Stub.asInterface(service);
		}
	};
	
	private void setComponentInfo()
	{
		if (mGetServiceInfo != null) {
			mGetServiceInfo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "GetServiceInfo button is onclicked");
					String personName = null;
					if (mInputText != null) {
						personName = mInputText.getText().toString();
						List<Pet> pets;
						try {
							pets = mPetService.getPets(new Person(1, personName, personName));
							ArrayAdapter<Pet> adapter = new ArrayAdapter<Pet>(
									ComplexClient.this, 
									android.R.layout.simple_list_item_1, 
									pets);
							mListView.setAdapter(adapter);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			});
		}
	}
	
	private void initializeComponent()
	{
		mGetServiceInfo = (Button)findViewById(R.id.ten_complex_service_main_getServiceBtn);
		mListView = (ListView)findViewById(R.id.ten_complex_service_main_listView);
		mInputText = (EditText)findViewById(R.id.ten_complex_service_main_input_text);
		
		Intent intent = new Intent();
		intent.setAction("com.example.contents.ten.complexservice.ComplexService");
		startService(intent);
		bindService(intent, mConn, Service.BIND_AUTO_CREATE);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_complex_service_main);
		initializeComponent();
		setComponentInfo();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
}
