/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç7:31:48.
*/ 
package com.example.contents.four.singletask;

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
public class SingTaskSecondActivity extends Activity {
	private final String TAG = "SingleTaskActivity";
	private void initialize()
	{
		LinearLayout ll = new LinearLayout(SingTaskSecondActivity.this);
		ll.setOrientation(LinearLayout.VERTICAL);
		this.setContentView(ll);
		TextView tv = new TextView(SingTaskSecondActivity.this);
		tv.setText("Activity is:" + SingTaskSecondActivity.this.toString() + "\n"
				+ "Task Id:" + this.getTaskId());
		Button button = new Button(SingTaskSecondActivity.this);
		button.setText("lunch Activity");
		ll.addView(tv);
		ll.addView(button);
		
		if (button != null) {
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SingTaskSecondActivity.this,
							SingleTaskActivity.class);
					startActivity(intent);
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}
	
}
