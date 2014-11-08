package com.example.dandan;

import com.example.contents.ContentsActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.app.Activity;
import android.content.Intent;


public class MainInterface extends Activity implements OnGestureListener{

	private String TAG = "Interface";
    private GestureDetector mGesture;
    private void initialize()
    {
    	Log.d(TAG, "initialize");
    	mGesture = new GestureDetector(this, this);
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_interface);
		initialize();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_interface, menu);
		return true;
	}
	@Override
	public boolean onDown(MotionEvent arg0) {
		Log.d(TAG, "onDown.");
		Intent intent = new Intent(MainInterface.this, ContentsActivity.class);
		startActivity(intent);
		return false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGesture.onTouchEvent(event);
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
        Log.d(TAG, "onFling.");
        Log.d(TAG,"first:" + e1.getX() +",second:"+ e1.getX());
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		Log.d(TAG, "onLongPress.");

		
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.d(TAG, "onScroll.");
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		Log.d(TAG, "onShowPress.");
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
