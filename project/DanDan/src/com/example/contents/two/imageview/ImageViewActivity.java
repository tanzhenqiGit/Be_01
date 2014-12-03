/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÉÏÎç10:01:32
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-3 ÉÏÎç10:01:32 
* class declare 
*/ 
package com.example.contents.two.imageview;

import com.example.dandan.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author free
 *
 */
public class ImageViewActivity extends Activity {

	private final String TAG = "ImageViewActivity";
	
	private Button mInscreaseBtn, mDescreaseBtn, mNextBtn;
	private ImageView mImage1, mImage2;
	private int mCurrentImage = 2;
	private int mAlpha = 255;
	private int[] mImages = new int[] {
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.shui,
	};
	
	
	private OnClickListener mListener = new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View source) {
			switch(source.getId()) {
			case R.id.two_imageview_activity_main_increase_btn:
				mAlpha += 20;
				break;
			case R.id.two_imageview_activity_main_decrease_btn:
				mAlpha -= 20;
				break;
			default:
				
				return;
			}
			if (mAlpha >= 255) {
				mAlpha = 255;
			}
			if (mAlpha <= 0) {
				mAlpha = 0;
			}
			if (mImage1 != null) {
				mImage1.setAlpha(mAlpha);
			}
		}
	};
	private void initialize()
	{
		mInscreaseBtn = (Button)findViewById(R.id.two_imageview_activity_main_increase_btn);
		if (mInscreaseBtn != null) {
			mInscreaseBtn.setOnClickListener(mListener);
		}
		mDescreaseBtn = (Button)findViewById(R.id.two_imageview_activity_main_decrease_btn);
		if (mDescreaseBtn != null) {
			mDescreaseBtn.setOnClickListener(mListener);
		}
		mNextBtn = (Button)findViewById(R.id.two_imageview_activity_main_next_btn);
		if (mNextBtn != null) {
			mNextBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mImage1 != null) {
						BitmapDrawable bitmapDrawable = (BitmapDrawable)mImage1.getDrawable();
						if (!bitmapDrawable.getBitmap().isRecycled()) {
							bitmapDrawable.getBitmap().recycle();
						}
						mCurrentImage++;
						if (mCurrentImage >=  mImages.length) {
							mCurrentImage = 0;
						}
						mImage1.setImageBitmap(BitmapFactory.decodeResource(getResources(), 
								mImages[mCurrentImage]));
						
					}
					
				}
			});
		}
		mImage1 = (ImageView)findViewById(R.id.two_imageview_activity_main_image1);
		if (mImage1 != null) {
			mImage1.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					BitmapDrawable bitmapDrawable = (BitmapDrawable)mImage1.getDrawable();
					Bitmap bitmap = bitmapDrawable.getBitmap();
					
					double scale = bitmap.getWidth() / 320.0;
					
					int x = (int)((event.getX()) * scale);
					int y = (int)((event.getY()) * scale);

					return false;
				}
			});
		}
		mImage2 = (ImageView)findViewById(R.id.two_imageview_activity_main_image2);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

}
