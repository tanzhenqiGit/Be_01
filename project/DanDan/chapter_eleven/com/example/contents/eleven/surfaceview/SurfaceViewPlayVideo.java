package com.example.contents.eleven.surfaceview;

import java.io.IOException;

import com.example.dandan.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class SurfaceViewPlayVideo extends Activity implements OnClickListener {
    private String TAG = "SurfaceViewPlayVideo";
    private ImageButton mPlayBtn, mPauseBtn, mStopBtn;
    private SurfaceView mSurfaceView;
    private MediaPlayer mMediaPlayer;
    private int mPosition = 0;
    
    private void play() throws IOException
    {
    	if (mMediaPlayer != null) {
    	
    		mMediaPlayer.reset();
    		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    		mMediaPlayer.setDataSource("/mnt/sdcard/video.mp4");
    		mMediaPlayer.setDisplay(mSurfaceView.getHolder());
    		mMediaPlayer.prepare();
    		WindowManager wManager = getWindowManager();
    		DisplayMetrics metric = new DisplayMetrics();
    		wManager.getDefaultDisplay().getMetrics(metric);
    		int width = metric.widthPixels;
    		int height = metric.widthPixels * (mMediaPlayer.getVideoHeight() / (mMediaPlayer.getVideoWidth()+1));
    		Log.d(TAG,"width="+width + ",height="+height);
    		Toast.makeText(SurfaceViewPlayVideo.this, "width="+width+",height="+height, Toast.LENGTH_LONG).show();
    		if (width > 0 && height > 0) {
    		 //   mSurfaceView.setLayoutParams(new LayoutParams(width, height));
    		}
    		mMediaPlayer.start();
    	}
    }
    private void initialize()
    {
    	mPlayBtn = (ImageButton)findViewById(R.id.eleven_surfaceview_play_video_main_play_btn);
    	if (mPlayBtn != null) {
    		mPlayBtn.setOnClickListener(this);
    	}
    	
    	mPauseBtn = (ImageButton)findViewById(R.id.eleven_surfaceview_play_video_main_pause);
    	if (mPauseBtn != null) {
    		mPauseBtn.setOnClickListener(this);
    	}
    	mStopBtn = (ImageButton)findViewById(R.id.eleven_surfaceview_play_video_main_stop_btn);
    	if(mStopBtn != null) {
    		mStopBtn.setOnClickListener(this);
    	}
    	mMediaPlayer = new MediaPlayer();
    	
    	mSurfaceView = (SurfaceView)findViewById(R.id.eleven_surfaceview_play_video_main_surface);
    	if (mSurfaceView != null) {
    		mSurfaceView.getHolder().setKeepScreenOn(true);
    		mSurfaceView.getHolder().addCallback(new SurfaceListener());
    	}
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleven_surfaceview_play_video_main);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		if (mMediaPlayer != null) {
			if (mMediaPlayer.isPlaying()) {
				mMediaPlayer.stop();
			}
			mMediaPlayer.release();
		}
		super.onDestroy();
		
	}
	@Override
	public void onClick(View source) {
		switch(source.getId())
		{
		case R.id.eleven_surfaceview_play_video_main_play_btn:
			try {
				Log.d(TAG,"paly button is clicked ,action pause");
				play();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.eleven_surfaceview_play_video_main_pause:
			if (mMediaPlayer != null) {
				
				if (mMediaPlayer.isPlaying()) {
					mMediaPlayer.pause();
					Log.d(TAG,"pause button is clicked ,action pause");
				} else {
					mMediaPlayer.start();
					Log.d(TAG,"pause button is clicked ,action start");
				}
			}
			break;
		case R.id.eleven_surfaceview_play_video_main_stop_btn:
			if (mMediaPlayer != null) {
				Log.d(TAG,"stop button is clicked ,action pause");
				if (mMediaPlayer.isPlaying()){
					mMediaPlayer.stop();
				}
			}
			break;
		default:
			
			break;
		}
		
	}

	
	private class SurfaceListener implements SurfaceHolder.Callback
	{

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			Log.d(TAG, "surfacechanged");
			
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			Log.d(TAG, "surfaceCreated");
			if (mPosition > 0) {
				try {
					play();
					mMediaPlayer.seekTo(mPosition);
					mPosition = 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			Log.d(TAG, "surfaceDestroyed");
			
		}
		
	}


	@Override
	protected void onPause() {
		Log.d(TAG, "onPause");
		if (mMediaPlayer != null) {
			if (mMediaPlayer.isPlaying()) {
				mPosition = mMediaPlayer.getCurrentPosition();
				mMediaPlayer.stop();
			}
		}
		super.onPause();
	}
	
}
