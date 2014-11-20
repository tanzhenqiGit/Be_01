package com.example.contents.ten.alarmmanger;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class AlarmActivity extends Activity {

	private final String TAG = "AlarmActivity";
	private MediaPlayer mAlarmMusic;
	
	private void initialize()
	{
		mAlarmMusic = MediaPlayer.create(this, R.raw.music);
		mAlarmMusic.setLooping(true);
		mAlarmMusic.start();
		
		new AlertDialog.Builder(AlarmActivity.this)
		.setTitle("闹钟")
		.setMessage("时间到了 wake up!!!")
		.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.d(TAG, "AlarmActivity onClice");
				if (mAlarmMusic != null) {
					mAlarmMusic.stop();
					AlarmActivity.this.finish();
				}
				
			}
		}).show();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
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
