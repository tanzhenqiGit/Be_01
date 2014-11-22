package com.example.contents.ten.changewallpaper;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlarmChangeWallPaper extends Activity {

	private final String TAG = "AlarmChangeWallPaper";
	private AlarmManager mManager;
	private Button mStartBtn, mStopBtn;
	
	private void initialize()
	{
		mStartBtn = (Button)findViewById(R.id.ten_alarm_change_wall_paper_main_start_btn);
		mStopBtn = (Button)findViewById(R.id.ten_alarm_change_wall_paper_main_stop_btn);
		mManager = (AlarmManager)getSystemService(Service.ALARM_SERVICE);
		Intent intent = new Intent(AlarmChangeWallPaper.this, ChangeWallPaperService.class);
		final PendingIntent pi = PendingIntent.getService(AlarmChangeWallPaper.this,
				0, intent, 0);
		if (mStartBtn != null) {
			mStartBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mStartBtn is onClice");
					mManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 5000, pi);
					mStartBtn.setEnabled(false);
					mStopBtn.setEnabled(true);
					Toast.makeText(AlarmChangeWallPaper.this,
							"alarmChangeWallPaper set sucessed.",
							Toast.LENGTH_LONG).show();
				}
			});
		}		
		if (mStopBtn != null) {
			mStopBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mStopBtn");
					mStartBtn.setEnabled(true);
					mStopBtn.setEnabled(false);
					mManager.cancel(pi);
				}
			});
		}
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_alarm_change_wall_paper_main);
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
