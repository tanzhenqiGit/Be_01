package com.example.contents.ten.intentservicetest;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class IntentServiceTest extends Activity {

	private final String TAG = "IntentServiceTest";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_intent_service_main);
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		Log.d(TAG, "onCreateContentMenu");
	}

	public void startService(View source)
	{
		Log.d(TAG, "startService is called");
		Intent intent = new Intent(IntentServiceTest.this, MyService.class);
		startService(intent);
	}
	
	public void startIntentService(View source)
	{
		Log.d(TAG, "startIntentService is called");
		Intent intent = new Intent(IntentServiceTest.this, MyIntentService.class);
		startService(intent);
	}
}
