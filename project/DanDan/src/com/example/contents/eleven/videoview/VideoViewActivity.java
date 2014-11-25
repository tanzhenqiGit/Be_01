package com.example.contents.eleven.videoview;

import java.io.File;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoViewActivity extends Activity {
	private final String TAG = "VideoViewActivity";
	private VideoView mVideoView;
	private MediaController mController;
	
	private void initialize()
	{
		mVideoView = (VideoView)findViewById(R.id.eleven_video_view_main_videoview);
		mController = new MediaController(this);
		File video = new File("/data/movie.mp4");
		if (video.exists()) {
			Log.d(TAG, "file /data/movie.mp4 Exists");
			mVideoView.setVideoPath(video.getAbsolutePath());
			mVideoView.setMediaController(mController);
			mController.setMediaPlayer(mVideoView);
			mVideoView.requestFocus();
		} else {
			Log.d(TAG, "file /data/movie.mp4 not Exists");
			Toast.makeText(VideoViewActivity.this, "file /data/movie.mp4 not Exists ", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.eleven_video_view_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	
}
