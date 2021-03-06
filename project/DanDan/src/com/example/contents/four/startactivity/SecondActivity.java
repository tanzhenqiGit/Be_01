package com.example.contents.four.startactivity;

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

public class SecondActivity extends Activity {
	private String TAG = "StartActivity";
	private Button mBackBtn;
	private Button mFinishBtn;
	private void initialize()
	{
		mBackBtn = (Button)findViewById(R.id.four_start_activity_2_back_btn);
		if (mBackBtn != null) {
			mBackBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent inent = new Intent(SecondActivity.this,StartActivity.class);
					startActivity(inent);
				}
			});
		}
		
		mFinishBtn = (Button)findViewById(R.id.four_start_activity_2_finish_btn);
		if (mFinishBtn != null) {
			mFinishBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "secondActivity finish button is called");
					Intent intent = new Intent(SecondActivity.this, StartActivity.class);
					startActivity(intent);
					finish();
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"Second onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_start_activity_2);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG,"Second onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"Second onDestroy");
		super.onDestroy();
	}
	
}
