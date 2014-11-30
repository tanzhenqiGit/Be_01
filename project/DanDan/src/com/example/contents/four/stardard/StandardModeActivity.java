/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç7:01:25.
*/ 
package com.example.contents.four.stardard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class StandardModeActivity extends Activity {

	private final String TAG = "StandardModeActivity";
	
	private void initialize()
	{
		LinearLayout ll = new LinearLayout(StandardModeActivity.this);
		ll.setOrientation(LinearLayout.VERTICAL);
		this.setContentView(ll);
		
		TextView tv = new TextView(StandardModeActivity.this);
		tv.setText("Activity is:" + this.toString() + "\n"
				+ "Task ID is:" + this.getTaskId());
		ll.addView(tv);
		
		Button button = new Button(StandardModeActivity.this);
		button.setText("LunchActivity");
		ll.addView(button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "lunch current Activity is onclicked");
				Intent intent = new Intent(StandardModeActivity.this,
						StandardModeActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	
	
}
