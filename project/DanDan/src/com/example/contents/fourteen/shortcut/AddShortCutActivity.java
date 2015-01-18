/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-15 下午3:17:23
* @class AddShortCutActivity.java
*/ 
package com.example.contents.fourteen.shortcut;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author free
 *
 */
@SuppressLint("HandlerLeak")
public class AddShortCutActivity extends Activity {

	private final String TAG = "AddShortCutActivity";
	public final int MSG_TYPE_START_ANIMATION = 0x12;
	public final int MSG_TYPE_SEND_BROAD_CAST = 0x13;
	private ImageView mFlowerImg;
	private Animation mAnim, mReverse;
	private Button mButton;
	final Handler mHandler = new Handler()
	{

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_TYPE_START_ANIMATION) {
				if (mFlowerImg != null) {
					Log.d(TAG,"receiver msg MSG_TYPE_START_ANIMATION");
					mFlowerImg.startAnimation(mReverse);
				}
			} else if (msg.what == MSG_TYPE_SEND_BROAD_CAST) {
				new Thread()
				{
					@Override
					public void run() {
						addShortCut();
					}
					
				}.start();
			}
		}
		
		
	};
	
	private void addShortCut()
	{
		Log.d(TAG, "addShortCut is called");
		
		Intent addIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		String title = getResources().getString(R.string.app_name);
		
		//加载快捷方式图标
		Parcelable icon = Intent.ShortcutIconResource.fromContext(
				AddShortCutActivity.this, R.drawable.box);
		
		Intent myIntent = new Intent(AddShortCutActivity.this,
				AddShortCutActivity.class);
		
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);
		
		sendBroadcast(addIntent);
		
	}
	
	private void initialize()
	{
		mButton = (Button) findViewById(R.id.common_view_main_btn);
		if (mButton != null) {
			mButton.setVisibility(View.VISIBLE);
			mButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mHandler != null) {
						mHandler.sendEmptyMessage(MSG_TYPE_SEND_BROAD_CAST);
					}
				}
			});
		}
		mFlowerImg = (ImageView) findViewById(R.id.common_view_main_img);
		if (mFlowerImg != null) {
			mFlowerImg.setImageResource(R.drawable.lijiang);
		}
		
		mAnim = AnimationUtils.loadAnimation(this, R.animator.anim);
		if (mAnim != null) {
			//设置动画结束后的保留状态
			mAnim.setFillAfter(true);
		}
		
		mReverse = AnimationUtils.loadAnimation(this, R.animator.reverse);
		if (mReverse != null) {
			mReverse.setFillAfter(true);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main);
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
		
		if (mFlowerImg != null) {
			mFlowerImg.startAnimation(mAnim);
		}
		
		new Timer().schedule(new TimerTask()
		{

			@Override
			public void run() {
				if (mHandler != null) {
					mHandler.sendEmptyMessage(MSG_TYPE_START_ANIMATION);
				}
				
			}
			
		}, 3500);
	}
	
	
	
	

}
