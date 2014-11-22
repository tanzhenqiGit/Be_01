package com.example.contents.ten.musicbox;

import java.io.IOException;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.util.Log;

public class MusicBoxService extends Service {

	private final String TAG = "MusicBoxService";
	private MyReceiver mServiceReceiver;
	private AssetManager mAm;
	private String[] mMusics = new String[]{"ActionGo.mp3","INeedYou.mp3","NuMaiVreauSinguratate.mp3"};
	private MediaPlayer mMediaPlayer;
	private int mMusicStatus = MusicBox.MUSIC_STOP;
	private int mCurrent = 0;
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(TAG, "onBind");
		return null;
	}
	
	private void prepareAndPlay(String music)
	{
		AssetFileDescriptor afd;
		try {
			afd = mAm.openFd(music);
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			mMediaPlayer.prepare();
			mMediaPlayer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void initalize()
	{
		mAm = getAssets();
		mServiceReceiver = new MyReceiver();
		IntentFilter fliter = new IntentFilter();
		fliter.addAction(MusicBox.MUSIC_CTL_ACTION);
		registerReceiver(mServiceReceiver, fliter);
		
		mMediaPlayer = new MediaPlayer();
		if (mMediaPlayer != null) {
			mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					Log.d(TAG, "music onCompletion");
					mCurrent++;
					if (mCurrent >= 3) {
						mCurrent = 0;
					}
					
					Intent sendIntent = new Intent(MusicBox.MUSIC_UPDATE_ACTION);
					sendIntent.putExtra("current", mCurrent);
					sendBroadcast(sendIntent);
					prepareAndPlay(mMusics[mCurrent]);
				}
			});
		}
		
	}
	@Override
	public void onCreate() {
		Log.d(TAG,"onCreate");
		super.onCreate();
		initalize();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	public class MyReceiver extends BroadcastReceiver 
	{
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d(TAG,"MyReceiver onReceive");
			int control = intent.getIntExtra("control", -1);
			switch(control) {
			case MusicBox.MUSIC_BOX_PLAY_PAUSE_STOP_SWITCH:
				Log.d(TAG, "MusicBoxService receiver MUSIC_BOX_PLAY_PAUSE_STOP_SWITCH");
				if (mMusicStatus == MusicBox.MUSIC_STOP){
					prepareAndPlay(mMusics[control]);
					mMusicStatus = MusicBox.MUSIC_PLAY;
				} else if (mMusicStatus == MusicBox.MUSIC_PLAY) {
					mMediaPlayer.pause();
					mMusicStatus = MusicBox.MUSIC_PAUSE;
				} else if (mMusicStatus == MusicBox.MUSIC_PAUSE) {
					
					mMediaPlayer.stop();
					mMusicStatus = MusicBox.MUSIC_STOP;
				}
			break;
			case MusicBox.MUSIC_BOX_STOP:
				Log.d(TAG, "MusicBoxService receiver MUSIC_BOX_STOP");
				if ((mMusicStatus == MusicBox.MUSIC_PAUSE)
						|| (mMusicStatus == MusicBox.MUSIC_PLAY)) {
					mMediaPlayer.stop();
					mMusicStatus = MusicBox.MUSIC_STOP;
				}
				break;
			}
			Intent sendIntent = new Intent(MusicBox.MUSIC_UPDATE_ACTION);
			sendIntent.putExtra("update", mMusicStatus);
			sendIntent.putExtra("current",mCurrent);
			Log.d(TAG, "MusicBoxService send update=" + mMusicStatus +",current:" + mCurrent);
			sendBroadcast(sendIntent);
		}
		
	}

}
