package com.example.contents.three.callback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint("ClickableViewAccessibility")
public class CallBackButton extends Button {

	private final String TAG = "CallBackButton";
	public CallBackButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "Button CallBackButton");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.onKeyDown(keyCode, event);
		Log.d(TAG, "Button onKeyDown is called in  CallBackButton");
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "Button onTouchEvent is called in  CallBackButton");
		super.onTouchEvent(event);
		return true;
	}
	
	

}
