/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-13 上午9:28:24.
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Administrator
 *
 */
public class ToastActivity extends Activity {

	private final String TAG = "ToastActivity";
	private Button mShowBtn;
	private EditText mShowtxt;
	
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowtxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		
		if (mShowtxt != null) {
			mShowtxt.setVisibility(View.INVISIBLE);
		}
		if (mShowBtn != null) {
			mShowBtn.setText("弹出消息框");
			mShowBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast toast = new Toast(ToastActivity.this);
					toast.setGravity(Gravity.CENTER, 0, 0);
					ImageView image = new ImageView(ToastActivity.this);
					image.setImageResource(R.drawable.tools);
					TextView tv = new TextView(ToastActivity.this);
					tv.setText("测试Toast");
					tv.setTextSize(30);
					tv.setTextColor(Color.MAGENTA);
					LinearLayout ll = new LinearLayout(ToastActivity.this);
					ll.setOrientation(LinearLayout.HORIZONTAL);
					ll.addView(image);
					ll.addView(tv);
					toast.setView(ll);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.show();
					
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
