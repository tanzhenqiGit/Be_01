/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-19
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-19 ÏÂÎç4:23:43
* @class MyView.java
*/ 
package com.example.contents.fifteen.Gradienter;

import com.example.dandan.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author free
 *
 */
public class MyView extends View {

	private final String TAG = "MyView";
	Bitmap mBackground, mBubble;
	int mBubbleY,mBubbleX;
	/**
	 * @param context
	 * @param attrs
	 */
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mBackground = BitmapFactory.decodeResource(getResources(), R.drawable.background);
		mBubble = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
	}
	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		Log.d(TAG, "onDraw");
		super.onDraw(canvas);
		canvas.drawBitmap(mBackground, 0, 0, null);
		canvas.drawBitmap(mBubble, mBubbleX, mBubbleY, null);
	}
	
	

}
