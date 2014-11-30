/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç3:23:46.
*/ 
package com.example.contents.four.lifecycle;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Administrator
 *
 */
public class LifeCycleActivity extends Activity {

	private final String TAG = "LifeCycleActivity";
	private Button mSkipBtn, mFinishBtn;
	
	private void initialize()
	{
		mSkipBtn = (Button)findViewById(
				R.id.four_life_cycle_activity_main_skip_btn);
		if (mSkipBtn != null) {
			mSkipBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(LifeCycleActivity.this,
							LifeCycleSecondActivity.class);
					startActivity(intent);
					
				}
			});
		}
		
		mFinishBtn = (Button)findViewById(
				R.id.four_life_cycle_activity_main_finish_btn);
		if (mFinishBtn != null) {
			mFinishBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "finish button is onclicked");
					LifeCycleActivity.this.finish();
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "-------------- onCreate --------------");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_life_cycle_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "-------------- onDestroy --------------");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "-------------- onPause --------------");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "-------------- onRestart --------------");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "-------------- onResume --------------");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "-------------- onStart --------------");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "-------------- onStop --------------");
		super.onStop();
	}

}
