package com.example.contents.ten.sortedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MySortReceiver extends BroadcastReceiver{

	private final String TAG = "MySortReceiver";
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG,"onReceive");
		Toast.makeText(context, "receiver Intent's Action:" + intent.getAction()
				+ "\nmessage content:" + intent.getStringExtra("msg"),
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "receiver Intent's Action:" + intent.getAction()
				+ "\nmessage content:"+ intent.getStringExtra("msg"));
		
		Bundle bundle = new Bundle();
		bundle.putString("first", "first broadcastReceiver save message.");
		setResultExtras(bundle);
		//abortBroadcast();
		
	}

}
