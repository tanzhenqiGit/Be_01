package com.example.contents.ten.musicbox;

import com.example.dandan.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicBox extends Activity implements OnClickListener{

	private final String TAG = "MusicBox";
	public static final String MUSIC_UPDATE_ACTION = "ten.music.box.UPDATE_ACTION";
	public static final String MUSIC_CTL_ACTION = "ten.music.box.CTL_ACTION";
	
	public static final int MUSIC_STOP = 0x11;
	public static final int MUSIC_PLAY = 0x12;
	public static final int MUSIC_PAUSE = 0X13;
	public static final int MUSIC_BOX_PLAY_PAUSE_STOP_SWITCH = 1;
	public static final int MUSIC_BOX_STOP = 2;
	private int mMusicStatus = MUSIC_STOP;
	private ImageView mPlayImgBtn, mStopImgBtn;
	private TextView mTitleText, mAuthorText;
	
	private String[] mTitleStrs = new String[]{"ActionGo","INeedYou","NuMaiVreauSinguratate"};
	private String[] mAuthorStrs = new String[]{"LaSa","JuLi","Giulia"};
	
	private ActivityReceiver mReceiver;
	private void initialize()
	{
		mPlayImgBtn = (ImageView)findViewById(R.id.ten_music_box_mian_play_imgbtn);
		mStopImgBtn = (ImageView)findViewById(R.id.ten_music_box_main_stop_imgbtn);
		mTitleText = (TextView)findViewById(R.id.ten_music_box_main_title_text);
		mAuthorText = (TextView)findViewById(R.id.ten_music_box_main_author_text);
		
		if (mPlayImgBtn != null) {
			mPlayImgBtn.setOnClickListener(this);
		}
		
		if (mStopImgBtn != null) {
			mStopImgBtn.setOnClickListener(this);
		}
		
		mReceiver = new ActivityReceiver();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(MUSIC_UPDATE_ACTION);
		registerReceiver(mReceiver, filter);
		Intent intent = new Intent(MusicBox.this, MusicBoxService.class);
		startService(intent);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_music_box_main);
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
		super.onDestroy();
	}


	@Override
	public void onClick(View source) {
		Intent intent = new Intent(MUSIC_CTL_ACTION);
		switch(source.getId())
		{
		case R.id.ten_music_box_mian_play_imgbtn:
			Log.d(TAG, "MusicBox send MUSIC_BOX_PLAY_PAUSE_STOP_SWITCH");
			intent.putExtra("control", MUSIC_BOX_PLAY_PAUSE_STOP_SWITCH);
			break;
		case R.id.ten_music_box_main_stop_imgbtn:
			Log.d(TAG, "MusicBox send MUSIC_BOX_STOP");
			intent.putExtra("control", MUSIC_BOX_STOP);
			break;
		}
		sendBroadcast(intent);
	}
	
	public class ActivityReceiver extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d(TAG, "Music Box onReceive");
			int update = intent.getIntExtra("update", -1);
			int current = intent.getIntExtra("current", -1);
			Log.d(TAG, "MusicBox receiver update=" + update + ",current=" + current);
			
			if (current >= 0) {
				mTitleText.setText(mTitleStrs[current]);
				mAuthorText.setText(mAuthorStrs[current]);	
			}
			
			switch(update) {
			case MUSIC_STOP:
				mPlayImgBtn.setImageResource(R.drawable.stop);
				break;
			case MUSIC_PAUSE:
				mPlayImgBtn.setImageResource(R.drawable.pause);
				break;
			case MUSIC_PLAY:
				mPlayImgBtn.setImageResource(R.drawable.play);
				break;
			default:
				break;
			}
			
			mMusicStatus = update;
			Log.d(TAG, "mMusicStatus=" + mMusicStatus);
		}
		
	}

}
