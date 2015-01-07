/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-7
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-7 ÉÏÎç10:06:57
* @class MultiThreadDownActivity.java
*/ 
package com.example.contents.thirteen.http;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * @author free
 *
 */
public class MultiThreadDownActivity extends Activity {

	public final int MSG_GROGRESS_UPDATE = 0X123;
	private final String TAG = "MultiThreadDownActivity";
	private EditText mPathTxt,mNameTxt;
	private Button mDownload;
	private ProgressBar mProgressBar;
	private DownUtil mDownUtil;
	private int mDownStatus;
	
	@SuppressLint("HandlerLeak")
	final Handler mhandler = new Handler()
	{

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_GROGRESS_UPDATE) {
				if (mProgressBar != null && mDownStatus >= 0) {
					mProgressBar.setProgress(mDownStatus);
				}
			}
		}
		
	};
	
	
	private void SetDownloadCallBack()
	{
		if (mDownload == null || mPathTxt == null || mNameTxt == null) {
			Log.d(TAG, "mDownload == null do nothing return.");
			return ;
		}
		
		mDownload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mDownUtil = new DownUtil(mPathTxt.getText().toString(), 
						mNameTxt.getText().toString(), 4);
				
				if (mDownUtil != null) {
					try {
						mDownUtil.download();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mDownload.setEnabled(false);
				final Timer timer = new Timer();
				timer.schedule(new TimerTask()
				{

					/* (non-Javadoc)
					 * @see java.util.TimerTask#run()
					 */
					@Override
					public void run() {
						double completeRate = mDownUtil.getCompleteRate();
						mDownStatus = (int) (completeRate * 100);
						mhandler.sendEmptyMessage(MSG_GROGRESS_UPDATE);
						if (mDownStatus >= 100) {
							timer.cancel();
							mDownload.setEnabled(true);
						}
					}
					
				}, 0, 100);
			}
			
		});
	}
	
	@SuppressLint("HandlerLeak")
	private void initialize()
	{
		mPathTxt = (EditText) findViewById(R.id.thirteen_multi_thread_main_text_path);
		mNameTxt = (EditText) findViewById(R.id.thirteen_multi_thread_main_text_name);
		mDownload = (Button) findViewById(R.id.thirteen_multi_thread_main_down_btn);
		SetDownloadCallBack();
		mProgressBar = (ProgressBar) findViewById(R.id.thirteen_multi_thread_main_progress);
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen_multi_thread_down_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
	
}
