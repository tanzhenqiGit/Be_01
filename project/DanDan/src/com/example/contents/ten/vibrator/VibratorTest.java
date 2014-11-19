package com.example.contents.ten.vibrator;

import com.example.dandan.R;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class VibratorTest extends Activity {
	
	private final String TAG = "VibratorTest";
	private Vibrator mVibrator;
	
	private void initialize()
	{
		mVibrator = (Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
		if (mVibrator == null) {
			Log.d(TAG, "initialize mVibrator == null");
		}
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Toast.makeText(this, "ÊÖ»úÕñ¶¯", Toast.LENGTH_LONG).show();
		if (mVibrator != null) {
			mVibrator.vibrate(2000);
		}
		return super.onTouchEvent(event);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_vibrator_test_main);
		initialize();
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
