/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-2-3
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-2-3 上午10:15:01
* @class SpeechActivity.java
*/ 
package com.example.contents.eight.speech;

import java.util.Locale;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author free
 *
 */
public class SpeechActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		if (mTTS != null) {
			mTTS.shutdown();
		}
		super.onDestroy();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eight_speech_main);
		initialize();
	}
	
	private void initialize()
	{
		Log.d(TAG,"initialize()");
		mShowTxt = (EditText) findViewById(R.id.eight_speech_main_text);
		mSpeech = (Button) findViewById(R.id.eight_speech_main_speech_btn);
		if (mSpeech != null) {
			mSpeech.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mTTS != null && mShowTxt != null) {
						mTTS.speak(mShowTxt.getText().toString(), TextToSpeech.QUEUE_ADD, null);
					}
				}
			});
		}
		mRecord = (Button) findViewById(R.id.eight_speech_main_record_btn);
		if (mRecord != null) {
			mRecord.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mTTS != null && mShowTxt != null) {
						mTTS.synthesizeToFile(mShowTxt.getText().toString(), 
								null,
								"/mnt/sdcard/sound.wav");
						Toast.makeText(SpeechActivity.this, 
								"声音记录成功", 
								Toast.LENGTH_LONG).show();
					}
				}
			});
		}
		
		mTTS = new TextToSpeech(this, new OnInitListener() {
			
			@Override
			public void onInit(int status) {
				Log.d(TAG, "onInit is called");
				int result = mTTS.setLanguage(Locale.US);
				if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
						&& result != TextToSpeech.LANG_AVAILABLE) {
					Toast.makeText(SpeechActivity.this, "TTS暂时不支持这种语言的朗读。",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	public final String TAG = "SpeechActivity";
	private EditText mShowTxt;
	private Button mSpeech, mRecord;
	private TextToSpeech mTTS;

}
