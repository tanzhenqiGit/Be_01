package com.example.contents.ten;


import com.example.contents.ten.MonitorPhont.MonitorPhone;
import com.example.contents.ten.aidlservice.AidlClient;
import com.example.contents.ten.alarmmanger.AlarmManagerTest;
import com.example.contents.ten.audiomanaertest.AudioManagerTest;
import com.example.contents.ten.bindservice.BindServiceTest;
import com.example.contents.ten.blockmain.BlockMain;
import com.example.contents.ten.broadcast.BroadcastMain;
import com.example.contents.ten.changewallpaper.AlarmChangeWallPaper;
import com.example.contents.ten.complexservice.ComplexClient;
import com.example.contents.ten.firstService.FirstServiceTest;
import com.example.contents.ten.groupsend.GroupSendTest;
import com.example.contents.ten.intentservicetest.IntentServiceTest;
import com.example.contents.ten.smsmanager.SmsManagerTest;
import com.example.contents.ten.telephonystatus.TelephonyStatus;
import com.example.contents.ten.vibrator.VibratorTest;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TenContentsActivity extends Activity {

	private String TAG = "TenContentsActivity";
	private ListView mListView = null;
	private final int FIRST_SERVICE = 0;
	private final int BIND_SERVICE = 1;
	private final int INTENT_SETVICE = 2;
	private final int AIDL_SERVICE = 3;
	private final int COMPLEX_SERVICE = 4;
	private final int TELEPHONY_STATUS = 5;
	private final int MONITOR_PHONT = 6;
	private final int BLOCK_MAIN = 7;
	private final int SMS_MANAGER = 8;
	private final int GROUP_SEND = 9;
	private final int AUDIO_MANAGER = 10;
	private final int VIBRATOR_TEST = 11;
	private final int ALARM_MANAGER = 12;
	private final int ALARM_CHANGE_WALL_PAPER = 13;
	private final int BROAD_CAST = 14;
	private void initializeComponent()
	{
		Log.d(TAG, "initializeComponent");
		mListView = (ListView)findViewById(R.id.listView);
		String[] Contents = getResources().getStringArray(R.array.chapterTenContents);
		
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(TenContentsActivity.this,
						android.R.layout.simple_list_item_1, Contents);
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View source, int position,
					long id) {
				switch(position) {
				case FIRST_SERVICE:
					Intent first_service_intent = 
						new Intent(TenContentsActivity.this,
								FirstServiceTest.class);
					startActivity(first_service_intent);
					break;
				case BIND_SERVICE:
					Intent bind_service_intent =
						new Intent(TenContentsActivity.this ,
								BindServiceTest.class);
					startActivity(bind_service_intent);
					break;
				case INTENT_SETVICE:
					Intent intent_service_intent = 
						new Intent(TenContentsActivity.this,
								IntentServiceTest.class);
					startActivity(intent_service_intent);
					break;
				case AIDL_SERVICE:
					Intent aidl_service_intent =
						new Intent(TenContentsActivity.this,
								AidlClient.class);
					startActivity(aidl_service_intent);
					break;
				case COMPLEX_SERVICE:
					Intent complex_service_intent = 
						new Intent(TenContentsActivity.this, ComplexClient.class);
					startActivity(complex_service_intent);
					break;
				case TELEPHONY_STATUS:
					Intent telephony_status_intent =
						new Intent(TenContentsActivity.this, TelephonyStatus.class);
					startActivity(telephony_status_intent);
					break;
				case MONITOR_PHONT:
					Intent monitor_phont_intent =
						new Intent(TenContentsActivity.this, MonitorPhone.class);
					startActivity(monitor_phont_intent);
					break;
				case BLOCK_MAIN:
					Intent block_main_intent =
						new Intent(TenContentsActivity.this, BlockMain.class);
					startActivity(block_main_intent);
					break;
				case SMS_MANAGER:
					Intent sms_manager_intent = 
						new Intent(TenContentsActivity.this, SmsManagerTest.class);
					startActivity(sms_manager_intent);
					break;
				case GROUP_SEND:
					Intent group_send_intent =
						new Intent(TenContentsActivity.this, GroupSendTest.class);
					startActivity(group_send_intent);
					break;
				case AUDIO_MANAGER:
					Intent audio_manager_intent = 
						new Intent(TenContentsActivity.this, AudioManagerTest.class);
					startActivity(audio_manager_intent);
					break;
				case VIBRATOR_TEST:
					Intent vibrator_intent =
						new Intent(TenContentsActivity.this, VibratorTest.class);
					startActivity(vibrator_intent);
					break;
				case ALARM_MANAGER:
					Intent alarm_manager_intent = 
						new Intent(TenContentsActivity.this, AlarmManagerTest.class);
					startActivity(alarm_manager_intent);
					break;
				case ALARM_CHANGE_WALL_PAPER:
					Intent alarm_change_wall_intent 
						= new Intent(TenContentsActivity.this, AlarmChangeWallPaper.class);
					startActivity(alarm_change_wall_intent);
					break;
				case BROAD_CAST:
					Intent broad_cast_intent 
						= new Intent(TenContentsActivity.this, BroadcastMain.class);
					startActivity(broad_cast_intent);
					break;
				default:
					
					break;
				}
				
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initializeComponent();
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
