package com.example.contents.eleven.soundpool;

import java.util.HashMap;

import com.example.dandan.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundPoolActivity extends Activity implements OnClickListener{

	private final String TAG = "SoundPoolActivity";
	private Button mArrowBtn, mBombBtn, mShotBtn;
	private SoundPool mSoundPool;
	private HashMap<Integer,Integer> mSoundMap = new HashMap<Integer, Integer>();
	private void initialize()
	{
		mArrowBtn = (Button) findViewById(R.id.eleven_sound_pool_main_arrow_btn);
		mBombBtn = (Button) findViewById(R.id.eleven_sound_pool_main_bomb_btn);
		mShotBtn = (Button) findViewById(R.id.eleven_sound_pool_main_shot_btn);
		
		mSoundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
		mSoundMap.put(1, mSoundPool.load(this, R.raw.bomb,1));
		mSoundMap.put(2, mSoundPool.load(this, R.raw.shot, 1));
		mSoundMap.put(3, mSoundPool.load(this, R.raw.arrow, 1));
		mArrowBtn.setOnClickListener(this);
		mBombBtn.setOnClickListener(this);
		mShotBtn.setOnClickListener(this);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleven_sound_pool_main);
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

	@Override
	public void onClick(View source) {
		switch(source.getId())
		{
		case R.id.eleven_sound_pool_main_bomb_btn:
			Log.d(TAG,"bomb");
			mSoundPool.play(mSoundMap.get(1), 1, 1, 0, 0, 1);
			break;
		case R.id.eleven_sound_pool_main_shot_btn:
			Log.d(TAG,"shot");
			mSoundPool.play(mSoundMap.get(2), 1, 1, 0, 0, 1);
			break;
		case R.id.eleven_sound_pool_main_arrow_btn:
			Log.d(TAG,"arrow");
			mSoundPool.play(mSoundMap.get(3), 1, 1, 0, 0, 1);
			break;
		default:
			Log.d(TAG,"");
			break;
		}
		
	}

}
