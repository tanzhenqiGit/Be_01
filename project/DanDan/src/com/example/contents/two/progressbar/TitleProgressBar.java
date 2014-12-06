/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç9:56:16.
*/ 
package com.example.contents.two.progressbar;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

/**
 * @author Administrator
 *
 */
public class TitleProgressBar extends Activity {
	private final String TAG = "TitleProgressBar";
	private Button mShowBtn, mHideBtn;
	
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_titleprogressbar_main_show_btn);
		if (mShowBtn != null) {
			mShowBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setProgressBarIndeterminateVisibility(true);
					setProgressBarVisibility(true);
					setProgress(4500);
					
					
					
				}
			});
		}
		mHideBtn = (Button)findViewById(R.id.two_titleprogressbar_main_hide_btn);
		if (mHideBtn != null) {
			mHideBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setProgressBarIndeterminateVisibility(false);
					setProgressBarVisibility(false);
					
				}
			});
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.two_titleprogressbar_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
