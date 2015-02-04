package com.example.contents.eighteen;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class LinkMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		initialize();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	private void initialize()
	{
		Log.d(TAG, "initialize()");
		setContentView(R.layout.eighteen_link_main);
		mGameView = (GameView) findViewById(R.id.eighteen_link_main_gameview);
		if (mGameView != null) {
			
		}
		mStartBtn = (Button) findViewById(R.id.eighteen_link_main_start_btn);
		if (mStartBtn != null) {
			
		}
		mShowTime = (TextView) findViewById(R.id.eighteen_link_main_time_txt);
		if (mShowTime != null) {
			
		}
		
	}
	
	private final String TAG = "LinkMainActivity";
	private Button mStartBtn;
	private TextView mShowTime;
	private GameView mGameView;
}
