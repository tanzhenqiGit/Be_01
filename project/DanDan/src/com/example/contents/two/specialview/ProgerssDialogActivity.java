/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 下午3:26:47
* @class ProgerssDialogActivity.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class ProgerssDialogActivity extends Activity {

	private final String TAG = "ProgerssDialogActivity";
	private int[] mData = new int [100];
	private final int PROGRESS_DIALOG = 0x12;
	private final int MSG_UPDATE_PROGRESS = 0x13;
	private int mProgressSts = 0;
	private ProgressDialog mProgressDlg;
	private Handler mHandler;
	private Button mShowBtn;
	private EditText mShowTxt;
	private int mHasData = 0;
	
	
	@SuppressLint("HandlerLeak")
	private void initialize()
	{
		
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowTxt != null) {
			mShowTxt.setVisibility(View.INVISIBLE);
		}
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
	
		if (mShowBtn != null) {
			mShowBtn.setText("显示进度");
			mShowBtn.setOnClickListener(new View.OnClickListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					showDialog(PROGRESS_DIALOG);
					
				}
			});
		}
		
		mHandler = new Handler() {

			/* (non-Javadoc)
			 * @see android.os.Handler#handleMessage(android.os.Message)
			 */
			@Override
			public void handleMessage(Message msg) {
				Log.d(TAG,"reciever message for handler id = " + msg.what);
				if (msg.what == MSG_UPDATE_PROGRESS) {
					if (mProgressDlg != null) {
						mProgressDlg.setProgress(mProgressSts);
					}
				}
			}
			
		};
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestory");
		super.onDestroy();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateDialog(int, android.os.Bundle)
	 */
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) {
		if (id == PROGRESS_DIALOG) {
			mProgressDlg = new ProgressDialog(this);
			mProgressDlg.setMax(100);
			mProgressDlg.setMessage("消耗任务的完成百分比");
			mProgressDlg.setCancelable(true);
			mProgressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgressDlg.setIndeterminate(false);
		}
		return mProgressDlg;
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onPrepareDialog(int, android.app.Dialog, android.os.Bundle)
	 */
	@Override
	@Deprecated
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		Log.d(TAG, "onPrepareDialog is called");
		if (id == PROGRESS_DIALOG) {
			if (mProgressDlg != null) {
				mProgressDlg.incrementProgressBy(-mProgressDlg.getProgress());
			}
			new Thread()
			{

				/* (non-Javadoc)
				 * @see java.lang.Thread#run()
				 */
				@Override
				public void run() {
					while(mProgressSts < 100) {
						mProgressSts = doWork();
						Log.d(TAG, "mProgressSts=" + mProgressSts);
						Message m = new Message();
						m.what = MSG_UPDATE_PROGRESS;
						if (mHandler != null) {
							mHandler.sendMessage(m);
						}
					} 
					
					if (mProgressSts >= 100) {
						mProgressSts = 0;
						mHasData = 0;
						mProgressDlg.dismiss();
					}
					super.run();
				}
				
			}.start();
		}
	}
	
	
	public int doWork()
	{
		mData[mHasData++] = (int)(Math.random() * 100);
		Log.d(TAG, "doWork mHasData=" + mHasData + "==> " + mData[mHasData-1]);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mHasData;
	}
	

	
	
}
