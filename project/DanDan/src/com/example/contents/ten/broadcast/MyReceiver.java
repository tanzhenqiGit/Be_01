package com.example.contents.ten.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	private final String TAG = "MyReceiver";
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "receiver Intent's Action is :" 
				+ intent.getAction()
				+"\n message content is :" + intent.getStringExtra("msg"));
		
		Toast.makeText(context, "receiver Intent's Action is :" 
				+ intent.getAction()
				+"\n message content is :" + intent.getStringExtra("msg"),
				Toast.LENGTH_LONG).show();
		
	}

}
