package com.example.contents.eleven.mediaplayer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.LinearLayout;

public class MediaPlayerTest extends Activity {

	private String TAG = "MediaPlayerTest";
	private MediaPlayer mPlayer;
	private Visualizer mVirsualizer;
	private Equalizer mEqualizer;
	private BassBoost mBassBoost;
	private PresetReverb mPresetReverb;
	private LinearLayout mLayout;
	private List<Short> mReverbNames = new ArrayList<Short>();
	private List<String> mReverbVals = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
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

	
}
