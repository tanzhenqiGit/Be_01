package com.example.contents.eleven;

import com.example.contents.eleven.captureimage.CaptureImageActivity;
import com.example.contents.eleven.recordsound.RecordSoundActivity;
import com.example.contents.eleven.recordvideo.RecordVideoActivity;
import com.example.contents.eleven.soundpool.SoundPoolActivity;
import com.example.contents.eleven.surfaceview.SurfaceViewPlayVideo;
import com.example.contents.eleven.videoview.VideoViewActivity;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ElevenContentsActivity extends Activity {

	private final String TAG = "ElevenContentsActivity";
	private String[] mContents;
	private ListView mListView;
	private final int SOUND_POOL = 0;
	private final int VOIDE_VIEW = 1;
	private final int SURFACE_VIEW = 2;
	private final int RECORD_SOUND = 3;
	private final int CAPTURE_IMAGE = 4;
	private final int RECORD_VIDEO = 5;
	private void setListCallBack()
	{
		if (mListView != null) {
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position) {
					case SOUND_POOL:
						Intent sound_pool_intent = new Intent(ElevenContentsActivity.this,
								SoundPoolActivity.class);
						startActivity(sound_pool_intent);
						break;
					case VOIDE_VIEW:
						Intent video_view_intent = new Intent(ElevenContentsActivity.this,
								VideoViewActivity.class);
						startActivity(video_view_intent);
						break;
					case SURFACE_VIEW:
						Intent surface_view_intent = new Intent(ElevenContentsActivity.this,
								SurfaceViewPlayVideo.class);
						startActivity(surface_view_intent);
						break;
					case RECORD_SOUND:
						Intent record_sound_intent = new Intent(ElevenContentsActivity.this,
								RecordSoundActivity.class);
						startActivity(record_sound_intent);
						break;
					case CAPTURE_IMAGE:
						Intent capture_image_intend = new Intent(ElevenContentsActivity.this,
								CaptureImageActivity.class);
						startActivity(capture_image_intend);
						break;
					case RECORD_VIDEO:
						Intent record_video_intent = new Intent(ElevenContentsActivity.this,
								RecordVideoActivity.class);
						startActivity(record_video_intent);
						break;
					default:
						break;
					}
					
				}
			});
		}
	}
	private void initialize()
	{
		mContents = getResources().getStringArray(R.array.chapterElevenContents);
		mListView = (ListView)findViewById(R.id.listView);
		ArrayAdapter<String> adapter 
			= new ArrayAdapter<String>(
					ElevenContentsActivity.this,
					android.R.layout.simple_list_item_1,
					mContents);
		if(mListView != null) {
			mListView.setAdapter(adapter);
			setListCallBack();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
