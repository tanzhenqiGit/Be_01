/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014上午9:20:50
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time ：2014-12-2 上午9:20:50 
* class declare 
*/ 
package com.example.contents.three.configurationchange;

import com.example.dandan.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author free
 *
 */
public class ConfigurationChange extends Activity {

	private final String TAG = "ConfigurationChange";
	private EditText mOrientationText;
	private Button mChageOrientationBtn;

	private void initialize()
	{
		mOrientationText = (EditText)findViewById(R.id.three_configuration_change_main_screen_text);
		if (mOrientationText != null) {
			Configuration initConfig = getResources().getConfiguration();
			String screen = initConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ?
					"横屏显示" : "竖屏显示";
			mOrientationText.setText(screen);
		}
		mChageOrientationBtn = (Button)findViewById(
				R.id.three_configuration_change_main_change_screen_btn);		
		if (mChageOrientationBtn != null) {
			mChageOrientationBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Configuration config = getResources().getConfiguration();
					if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
						ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
					} else if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
						ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_configuration_change_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ?
				"横屏显示" : "竖屏显示";
		Toast.makeText(this, "系统屏幕方向发生变化\n修改后为：" + screen, Toast.LENGTH_LONG).show();
		mOrientationText.setText(screen);
		
	}
	

}
