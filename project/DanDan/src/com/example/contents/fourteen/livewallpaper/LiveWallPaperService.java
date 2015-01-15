/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-15 ÏÂÎç2:09:24
* @class LiveWallPaperService.java
*/ 
package com.example.contents.fourteen.livewallpaper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * @author free
 *
 */
public class LiveWallPaperService extends WallpaperService {
	
	private final String TAG = "LiveWallPaperService";

	class MyEngine extends Engine
	{
		private boolean mVisible;
		private float mTouchX = -1;
		private float mTouchY = -1;
		
		private float mCx = 15;
		private float mCy = 20;
		
		
		private Paint mPaint = new Paint();
		
		private Handler mHandler = new Handler();
		private final Runnable mDrawTarget = new Runnable() {
			
			@Override
			public void run() {
				drawFrame();
				
			}
		};
		
		private void drawTouchPoint(Canvas c)
		{
			Log.d(TAG,"drawTouchPoint");
			if (mTouchX >= 0 && mTouchY >= 0)
			{
				c.drawCircle(mTouchX, mTouchY, 40, mPaint);
			}
		}
		
		private void drawFrame()
		{
			Log.d(TAG, "drawFrame --start--");
			final SurfaceHolder holder = getSurfaceHolder();
			Canvas c = null;
			try {
				if (holder != null)
				{
					c = holder.lockCanvas();
					if (c != null) {
						c.save();
						c.drawColor(0xff000000);
						drawTouchPoint(c);
						c.drawCircle(mCx, mCy, 80, mPaint);
						c.restore();
					}
				}
			} finally {
				
				if (c != null) {
					Log.d(TAG, "--exception is ocurred.");
					holder.unlockCanvasAndPost(c);
				}
			}
			
			mHandler.removeCallbacks(mDrawTarget);
			
			if (mVisible) {
				mCx += 15;
				mCy += 20;
				if (mCx > 320) {
					mCx = 15;
				}
				if (mCy > 400) {
					mCy = 20;
				}
				
				mHandler.postDelayed(mDrawTarget, 100);
			}
			
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onCreate(android.view.SurfaceHolder)
		 */
		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			Log.d(TAG, "MyEngine OnCreate");
			mPaint.setColor(0xffffffff);
			mPaint.setAntiAlias(true);
			mPaint.setStrokeWidth(2);
			mPaint.setStyle(Paint.Style.STROKE);
			setTouchEventsEnabled(true);
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onDestroy()
		 */
		@Override
		public void onDestroy() {
			super.onDestroy();
			Log.d(TAG, "MyEngine onDestroy");
			mHandler.removeCallbacks(mDrawTarget);
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onVisibilityChanged(boolean)
		 */
		@Override
		public void onVisibilityChanged(boolean visible) {
			Log.d(TAG, "MyEngine onVisibilityChanged visible=" + visible);
			mVisible = visible;
			if (visible) {
				drawFrame();
			} else {
				mHandler.removeCallbacks(mDrawTarget);
			}
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onTouchEvent(android.view.MotionEvent)
		 */
		@Override
		public void onTouchEvent(MotionEvent event) {
			Log.d(TAG, "MyEngine onTouchEvent");
			
			if (event.getAction() == MotionEvent.ACTION_MOVE) {
				mTouchX = event.getX();
				mTouchY = event.getY();
			} else {
				mTouchX = -1;
				mTouchY = -1;
			}
			super.onTouchEvent(event);
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onOffsetsChanged(float, float, float, float, int, int)
		 */
		@Override
		public void onOffsetsChanged(float xOffset, float yOffset,
				float xOffsetStep, float yOffsetStep, int xPixelOffset,
				int yPixelOffset) {
			Log.d(TAG, "MyEngine onOffsetsChanged");
			drawFrame();
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onSurfaceChanged(android.view.SurfaceHolder, int, int, int)
		 */
		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			// TODO Auto-generated method stub
			super.onSurfaceChanged(holder, format, width, height);
			Log.d(TAG,"onCreateChanged");
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onSurfaceCreated(android.view.SurfaceHolder)
		 */
		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			super.onSurfaceCreated(holder);
			Log.d(TAG,"onSurfaceCreated");
		}

		/* (non-Javadoc)
		 * @see android.service.wallpaper.WallpaperService.Engine#onSurfaceDestroyed(android.view.SurfaceHolder)
		 */
		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			super.onSurfaceDestroyed(holder);
			Log.d(TAG,"onSurfaceCreated");
		}
		
		
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see android.service.wallpaper.WallpaperService#onCreateEngine()
	 */
	@Override
	public Engine onCreateEngine() {
		Log.d(TAG, "onCreateEngine");
		return new MyEngine();
	}



	/* (non-Javadoc)
	 * @see android.service.wallpaper.WallpaperService#onCreate()
	 */
	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
	}



	/* (non-Javadoc)
	 * @see android.service.wallpaper.WallpaperService#onDestroy()
	 */
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	
	

}
