package com.example.contents.ten.broadcast;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BroadcastMain extends Activity {
	private final String TAG = "BroadcastMain";
	private Button mSendBroadCast;
	
	private void initialize()
	{
		mSendBroadCast = (Button)findViewById(R.id.ten_broad_cast_main_send_btn);
		if (mSendBroadCast != null) {
			mSendBroadCast.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mSendBroadCast onClick");
					Intent intent = new Intent();
					intent.setAction("first.broadcast.action.SEND_BROADCAST");
					intent.putExtra("msg", "simple message!!");
					sendBroadcast(intent);
				}
			});
		}

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_broad_cast_main);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreatecontextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
