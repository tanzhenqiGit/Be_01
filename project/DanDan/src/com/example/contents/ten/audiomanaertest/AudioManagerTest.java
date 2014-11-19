package com.example.contents.ten.audiomanaertest;

import com.example.dandan.R;

import android.app.Activity;
import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class AudioManagerTest extends Activity {

	private Button mPlayBtn, mUpBtn, mDownBtn;
	private ToggleButton mToglleBtn;
	private AudioManager mAudioManager;
	
	private final String TAG = "AudioManagerTest";
	
	
	
	private void playBtnCallBack()
	{
		MediaPlayer player = MediaPlayer.create(AudioManagerTest.this, R.raw.music);
		if (player != null) {
			player.setLooping(true);
			player.start();
		}
	}
	
	private void upBtnCallBack()
	{
		if (mAudioManager != null) {
			mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, 
					AudioManager.ADJUST_RAISE,
					AudioManager.FLAG_SHOW_UI);
		}
		
	}
	
	private void downBtnCallBack()
	{
		if (mAudioManager != null) {
			mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
					AudioManager.ADJUST_LOWER, 
					AudioManager.FLAG_SHOW_UI);
		}
	}
	
	private void initialize()
	{
		mAudioManager = (AudioManager)getSystemService(Service.AUDIO_SERVICE);
		
		mPlayBtn = (Button)findViewById(R.id.ten_audio_manager_main_play);
		mUpBtn = (Button)findViewById(R.id.ten_audio_manager_main_up);
		mDownBtn = (Button)findViewById(R.id.ten_audio_manager_main_down);
		mToglleBtn = (ToggleButton)findViewById(R.id.ten_audio_manager_main_toggle_btn);
		
		if (mPlayBtn != null) {
			mPlayBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mplayBtn is onClicked");
					playBtnCallBack();
				}
			});
		}
		
		if (mDownBtn != null) {
			mDownBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mDownBtn is onClicked");
					downBtnCallBack();
				}
			});
		}
		
		if (mUpBtn != null) {
			mUpBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mUpBtn is onClicked");
					upBtnCallBack();
				}
			});
		}
		if (mToglleBtn != null) {
			mToglleBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Log.d(TAG, "mToglleBtn is onclicked isChecked=" + isChecked);
					if (mAudioManager != null) {
						mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, isChecked);
					}
				}
			});
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_audio_manager_main);
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
