package com.example.contents.ten.sortedbroadcast;

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

public class SortedBroadCastActivity extends Activity {

	private final String TAG = "SortedBroadCastActivity";
	private Button mSendSortedBroadCast;
	
	private void initialize()
	{
		mSendSortedBroadCast = (Button)findViewById(R.id.ten_broad_cast_main_send_btn);
		if (mSendSortedBroadCast != null) {
			mSendSortedBroadCast.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mSendSortedBroadCast is OnClicked");
					Intent intent = new Intent();
					intent.setAction("sortedBroadCast.action.SEND_BRAOADCAST");
					intent.putExtra("msg", "SortedBroadCastActivity:send sorted msg!!");
					sendOrderedBroadcast(intent, null);
				}
			});
		} else {
			Log.d(TAG, "mSendSortedBroadCast == null");
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
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
