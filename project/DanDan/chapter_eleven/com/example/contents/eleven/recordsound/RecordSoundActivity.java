package com.example.contents.eleven.recordsound;

import java.io.File;
import java.io.IOException;

import com.example.dandan.R;

import android.app.Activity;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioEncoder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class RecordSoundActivity extends Activity implements OnClickListener {

	private final String TAG = "RecordSoundActivity";
	private ImageButton mRecordBtn, mStopBtn;
	private File mSoundFile;
	private MediaRecorder mMRecorder;
	
	
	private void initialize()
	{
		mRecordBtn = (ImageButton)findViewById(R.id.eleven_record_sound_main_record_btn);
		if (mRecordBtn != null) {
			mRecordBtn.setOnClickListener(this);
		}
		mStopBtn = (ImageButton)findViewById(R.id.eleven_record_sound_main_stop_btn);
		if (mStopBtn != null) {
			mStopBtn.setOnClickListener(this);
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleven_record_sound_main);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "RecodeSound");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onClick(View source) {
		
		switch(source.getId())
		{
		case R.id.eleven_record_sound_main_record_btn:
			Log.d(TAG, "record button is onClick");
			if (!Environment.getExternalStorageState()
					.equals(android.os.Environment.MEDIA_MOUNTED)){
				Log.d(TAG,"sd card is not exist, please insert or mount you sd card");
				Toast.makeText(RecordSoundActivity.this, 
						"sd card is not exist, please insert or mount you sd card",
						Toast.LENGTH_LONG).show();
				return;
			}
			
			try {
				mSoundFile = new File(Environment
						.getExternalStorageDirectory()
						.getCanonicalFile()+"/sound.amr");
				if (mSoundFile == null) {
					Log.d(TAG, "mSoundFile == null just return");
					return;
				}
				mMRecorder = new MediaRecorder();
				if (mMRecorder == null) {
					Log.d(TAG, "mMRcorder == null");
					return ;
				}
				
				mMRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				mMRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				mMRecorder.setAudioEncoder(AudioEncoder.AMR_NB);
				mMRecorder.setOutputFile(mSoundFile.getAbsolutePath());
				mMRecorder.prepare();
				mMRecorder.start();
			} catch (IOException e) {
				Log.d(TAG, "IOException is occured");
				e.printStackTrace();
			}
			break;
		case R.id.eleven_record_sound_main_stop_btn:
			Log.d(TAG, "record stop button is onClick");
			if (mMRecorder != null && mSoundFile != null && mSoundFile.exists()) {
				mMRecorder.stop();
				mMRecorder.release();
				mMRecorder = null;
			}
			break;
		default:
			
			break;
		}
		
	}
	

}
