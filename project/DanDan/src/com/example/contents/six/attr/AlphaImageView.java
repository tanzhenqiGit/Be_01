/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 ÏÂÎç5:05:12
* @class AlphaImageView.java
*/ 
package com.example.contents.six.attr;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * @author free
 *
 */

@SuppressLint({ "HandlerLeak", "Recycle", "DrawAllocation" })
public class AlphaImageView extends ImageView {

	private final String TAG = "AlphaImageView";
	private final int MSG_TYPE_UPDATE = 0x01;
	private final int MAX_ALPHA = 255;
	private int mAlphaDelta = 0;
	private int mCurAlpha = 0;
	
	private final int SPEED = 300;
	private Handler mHandler = new Handler()
	{

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@SuppressWarnings("deprecation")
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_TYPE_UPDATE) {
				Log.d(TAG, "receiver msg mCurAlpha =" + mCurAlpha + 
						",mAlphaDelta =" + mAlphaDelta);
				mCurAlpha += mAlphaDelta;
				if (mCurAlpha > MAX_ALPHA) {
					mCurAlpha = MAX_ALPHA;
				}
				AlphaImageView.this.setAlpha(mCurAlpha);
				
			}
		}
		
	};
	/**
	 * @param context
	 * @param attrs
	 */
	public AlphaImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "AlphaImageView");
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.AlphaImageView);
		
		int duration = typedArray.getInt(R.styleable.AlphaImageView_duration, 0);
		Log.d(TAG, "duration =" + duration);
		mAlphaDelta = 255 * SPEED / duration;
		
	}
	/* (non-Javadoc)
	 * @see android.widget.ImageView#onDraw(android.graphics.Canvas)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void onDraw(Canvas canvas) {
		this.setAlpha(mCurAlpha);
		super.onDraw(canvas);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = MSG_TYPE_UPDATE;
				if (mCurAlpha >= MAX_ALPHA) {
					timer.cancel();
				} else {
					if (mHandler != null) {
						mHandler.sendMessage(msg);
					}
				}
			}
		}, 0, SPEED);
	}

	
}
