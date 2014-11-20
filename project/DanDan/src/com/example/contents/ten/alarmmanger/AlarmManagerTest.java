package com.example.contents.ten.alarmmanger;

import java.util.Calendar;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmManagerTest extends Activity {

	private final String TAG = "AlarmManagerTest";
	private AlarmManager mManager;
	private Button mSetCurrentTimeBtn;
	
	
	
	private void setTimeBtnCallBack()
	{
		Calendar currentTime = Calendar.getInstance();
		new TimePickerDialog(AlarmManagerTest.this, 0, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				Log.d(TAG, "onTimeSet hourOfDay = " + hourOfDay + ",minute=" + minute);
				Intent intent = new Intent(AlarmManagerTest.this, AlarmActivity.class);
				PendingIntent pi = PendingIntent.getActivity(AlarmManagerTest.this, 0, intent, 0);
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(System.currentTimeMillis());
				c.set(Calendar.HOUR, hourOfDay);
				c.set(Calendar.MINUTE,minute);
				if (mManager != null) {
					mManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
					Toast.makeText(AlarmManagerTest.this, "闹钟设置成功", Toast.LENGTH_LONG).show();
				}
		
				
			}
		}, currentTime.get(Calendar.HOUR_OF_DAY), currentTime.get(Calendar.MINUTE), false).show();
	}
	
	private void initialize()
	{
		mSetCurrentTimeBtn = (Button)findViewById(R.id.ten_alarm_manager_main_set_time_btn);
		mManager = (AlarmManager)getSystemService(Service.ALARM_SERVICE);
		if (mSetCurrentTimeBtn != null) {
			mSetCurrentTimeBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG,"mSerCurrentTimeBtn is onCliceked");
					setTimeBtnCallBack();
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_alarm_manager_main);
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
