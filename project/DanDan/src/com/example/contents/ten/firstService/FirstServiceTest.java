package com.example.contents.ten.firstService;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstServiceTest extends Activity {

	private Button mStartBtn = null;
	private Button mStopBtn = null;

	private String TAG = "FirstServiceTest";
	private void initializeComponent()
	{
		mStartBtn = (Button)findViewById(R.id.ten_first_service_main_startBtn);
		mStopBtn = (Button)findViewById(R.id.ten_first_service_main_stopBtn);
		final Intent intent = new Intent();
		intent.setAction("com.example.contents.ten.firstService.FirstService");
		
		mStartBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "startBtn is onClicked");
				startService(intent);
				
			}
		});
		
		mStopBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "mStopBtn is onClicked");
				stopService(intent);
				
			}
		});
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_first_service_main);
		Log.d(TAG, "onCreate");
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
