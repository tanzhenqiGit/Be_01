/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-2-2
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-2-2 ÉÏÎç11:13:09
* @class PageTurningActivity.java
*/ 
package com.example.contents.eight.gesture;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * @author free
 *
 */
public class PageTurningActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_page_turning_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "onTouchEvent");
		if (mGD != null) {
			mGD.onTouchEvent(event);
		}
		return super.onTouchEvent(event);
	}

	
	private void initialize()
	{
		mViewFlipper = (ViewFlipper) findViewById(R.id.eight_page_turning_main_flipper);
		if (mViewFlipper != null) {
			mViewFlipper.addView(addImageView(R.drawable.bomb10));
			mViewFlipper.addView(addImageView(R.drawable.bomb11));
			mViewFlipper.addView(addImageView(R.drawable.bomb12));
			mViewFlipper.addView(addImageView(R.drawable.bomb13));
			mViewFlipper.addView(addImageView(R.drawable.bomb14));
			
			if (mAnim != null) {
				mAnim[0] = AnimationUtils.loadAnimation(this, R.anim.left_in);
				mAnim[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
				mAnim[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
				mAnim[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);
			}
			
		}
		
		mGD = new GestureDetector(PageTurningActivity.this, new GestureDetector.OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {

				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {

				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {

				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {

				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				Log.d(TAG, " onFling ");
				if (e1.getX() - e2.getX() > FLIP_DISTENCE)
				{
					mViewFlipper.setInAnimation(mAnim[0]);
					mViewFlipper.setOutAnimation(mAnim[1]);
					mViewFlipper.showPrevious();
				} else if (e2.getX() - e1.getX() > FLIP_DISTENCE)
				{	
					mViewFlipper.setInAnimation(mAnim[2]);
				    mViewFlipper.setOutAnimation(mAnim[3]);
				    mViewFlipper.showNext();
				}
				return true;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {

				return false;
			}
		});
	}
	
	private View addImageView(int resId)
	{
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(resId);
		imageView.setScaleType(ImageView.ScaleType.CENTER);
		return imageView;
	}
	
	private final String TAG = "PageTurningActivity";
	private final int FLIP_DISTENCE = 50;
	private Animation[] mAnim = new Animation[4];
	private ViewFlipper mViewFlipper;
	private GestureDetector mGD;
}
