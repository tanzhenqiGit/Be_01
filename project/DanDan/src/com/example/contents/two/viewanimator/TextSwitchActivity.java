/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-7 下午7:56:52.
*/ 
package com.example.contents.two.viewanimator;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * @author Administrator
 *
 */
public class TextSwitchActivity extends Activity {
 
	private final String TAG = "TextSwitchActivity";
	private String[] mStrs = new String[] {
			"疯狂 Java 讲义",
			"轻量级 Java EE 企业应用实战",
			"疯狂 Android 讲义",
			"疯狂 Ajax 讲义"
	};
	
	private TextSwitcher mTextSwitcher;
	private int mCurStr;
	
	
	
	private void initialize()
	{
		mTextSwitcher = (TextSwitcher)findViewById(R.id.two_textswitcher_main_text);
		if (mTextSwitcher != null) {
			mTextSwitcher.setFactory(new ViewFactory() {
				
				@Override
				public View makeView() {
					TextView tv = new TextView(TextSwitchActivity.this);
					tv.setTextSize(40);
					tv.setTextColor(Color.MAGENTA);
					
					return tv;
				}
			});
			mTextSwitcher.setText(mStrs[mCurStr++ % mStrs.length]);
			
			mTextSwitcher.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mTextSwitcher.setText(mStrs[mCurStr++ % mStrs.length]);
				}
			});
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_textswitcher_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
