package com.example.contents.three.callback;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class CallBackHandler extends Activity {

	private final String TAG = "CallBackButton";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_callback_handler_main);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "CallBackHandler onTouchEvent is called ");
		return super.onTouchEvent(event);
	}

	
}
