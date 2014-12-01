package com.example.contents.eleven.recordvideo;

import java.io.File;
import java.io.IOException;

import com.example.dandan.R;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class RecordVideoActivity extends Activity implements OnClickListener {
	private String TAG = "RecordVideoActivity";
	
	private SurfaceView mSurfaceView;
	private ImageButton mRecordBtn;
	private ImageButton mStopBtn;
	private File mVideoFile;
	private boolean mIsRecording = false;
	private MediaRecorder mMRecorder;
	@SuppressWarnings("deprecation")
	private void initialzie()
	{
		mRecordBtn = (ImageButton)findViewById(R.id.eleven_record_video_main_record);
		if (mRecordBtn != null) {
			mRecordBtn.setOnClickListener(this);
		} else {
			Log.d(TAG, "mRecordBtn == null");
		}
		
		mStopBtn = (ImageButton)findViewById(R.id.eleven_record_video_main_stop);
		if (mStopBtn != null) {
			mStopBtn.setOnClickListener(this);
		} else {
			Log.d(TAG, "mStopBtn == null");
		}
		
		mSurfaceView = (SurfaceView)findViewById(R.id.eleven_record_video_main_surface);
		if (mSurfaceView != null) {
			mSurfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			mSurfaceView.getHolder().setFixedSize(320, 320);
			mSurfaceView.getHolder().setKeepScreenOn(true);
			Log.d(TAG, "surface set param succeed");
		} else {
			Log.d(TAG, "mSurfaceView == null");
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleven_record_video_main);
		initialzie();
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
		super.onDestroy();
	}

	private void handleOnRecordVideo()
	{
		if (!Environment.getExternalStorageState()
			.equals(android.os.Environment.MEDIA_MOUNTED))
		{
			Toast.makeText(RecordVideoActivity.this, 
					"sd card is not exist,please insert you sd card",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		try {
			mVideoFile = new File(Environment
				.getExternalStorageDirectory().getCanonicalFile()
				+"/myvideo.mp4");
			Log.d(TAG,"voidefile:"+mVideoFile.getPath());
			mMRecorder = new MediaRecorder();
			if (mMRecorder == null) {
				Log.d(TAG, "mMRecorder == null");
				return ;
			}
			mMRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			mMRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
			mMRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			mMRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
			mMRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
			mMRecorder.setVideoSize(320, 320);
			mMRecorder.setVideoFrameRate(4);
			mMRecorder.setOutputFile(mVideoFile.getAbsolutePath());
			mMRecorder.setPreviewDisplay(mSurfaceView.getHolder().getSurface());
			mMRecorder.prepare();
			mMRecorder.start();
			mRecordBtn.setEnabled(false);
			mStopBtn.setEnabled(true);
			mIsRecording = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handleOFFRecordVider()
	{
		if (mIsRecording) {
			if (mMRecorder != null) {
				mMRecorder.stop();
				mMRecorder.release();
				mRecordBtn.setEnabled(true);
				mStopBtn.setEnabled(false);
			}
		}
	}
	@Override
	public void onClick(View source) {
		switch(source.getId()) {
		case R.id.eleven_record_video_main_record:
			handleOnRecordVideo();
			break;
		case R.id.eleven_record_video_main_stop:
			handleOFFRecordVider();
			break;
		default:
			Log.d(TAG,"onclicked in other case");
			break;
		}
		
	}

}
