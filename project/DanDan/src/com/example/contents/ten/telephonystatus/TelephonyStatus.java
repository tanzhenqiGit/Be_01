package com.example.contents.ten.telephonystatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TelephonyStatus extends Activity {

	private final String TAG = "TelephonyStatus";
	
	private ListView mListView = null;
	private String[] mStatusName;
	private ArrayList<String> mStatusValues = new ArrayList<String>();
	
	private void initializeComponent()
	{
		mListView = (ListView)findViewById(R.id.ten_telephony_status_main_listview);
		TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		if (telephonyManager == null) {
			Log.d(TAG, "initializeComponent telephonyManager == null");
			return;
		}
		String[] simState = getResources().getStringArray(R.array.simState);
		String[] phoneType = getResources().getStringArray(R.array.phoneType);
		mStatusName = getResources().getStringArray(R.array.statusNames);
		
		mStatusValues.add(telephonyManager.getDeviceId() != null ? telephonyManager.getDeviceId() : "未知");
		mStatusValues.add(telephonyManager.getDeviceSoftwareVersion() != null 
				? telephonyManager.getDeviceSoftwareVersion() : "未知");
		mStatusValues.add(telephonyManager.getNetworkOperator());
		mStatusValues.add(telephonyManager.getNetworkOperatorName());
		mStatusValues.add(phoneType[telephonyManager.getPhoneType()]);
		mStatusValues.add(telephonyManager.getCellLocation() != null 
				? telephonyManager.getCellLocation().toString() : "未知位置");
		
		mStatusValues.add(telephonyManager.getSimCountryIso());
		mStatusValues.add(telephonyManager.getSimSerialNumber());
		mStatusValues.add(simState[telephonyManager.getSimState()]);
		
		ArrayList<Map<String,String>> status = new ArrayList<Map<String, String>>();
		
		for (int i = 0; i < mStatusValues.size(); i++) {
			HashMap<String, String>	map = new HashMap<String,String>();
			map.put("name", mStatusName[i]);
			map.put("value", mStatusValues.get(i));
			status.add(map);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(
				this, 
				status, 
				R.layout.ten_telephony_status_line, 
				new String[] {"name","value"},
				new int [] {R.id.ten_telephony_status_line_name,
						R.id.ten_telephony_status_line_value});
		mListView.setAdapter(adapter);
	
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_telephony_status_main);
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
