package com.example.contents.ten.sortedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MySortReceiver2 extends BroadcastReceiver {
	
	private final String TAG = "MySortReceiver2";
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceive");
		Bundle bundle = getResultExtras(true);
		String first = bundle.getString("first");
		Log.d(TAG, "receiver Intent's Action:" + intent.getAction()
				+ "\n message content:" + intent.getStringExtra("msg"));
		Log.d(TAG, "first broadcast save message:"
				+ first);
		
		Toast.makeText(context, "first broadcast save message:"
				+ first, Toast.LENGTH_LONG).show();
	}

}
