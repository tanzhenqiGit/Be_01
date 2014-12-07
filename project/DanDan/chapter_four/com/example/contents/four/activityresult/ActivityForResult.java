/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç1:06:05.
*/ 
package com.example.contents.four.activityresult;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Administrator
 *
 */
public class ActivityForResult extends Activity {

	private final String TAG = "ActivityForResult";
	private Button mChoiceCityBtn;
	private EditText mChoiceCityTxt;
	public static final int REQUEST_CODE = 0;
	private void initialize()
	{
		mChoiceCityTxt = (EditText)findViewById(
				R.id.four_activity_for_result_main_choice_city_text);
		mChoiceCityBtn = (Button)findViewById(
				R.id.four_activity_for_result_main_choice_city_btn);
		if (mChoiceCityBtn != null) {
			mChoiceCityBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mChoiceCityBtn is clicked");
					Intent intent = new Intent(ActivityForResult.this, SelectCityActivity.class);
					startActivityForResult(intent, REQUEST_CODE);
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_activity_for_result_main);
		initialize();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Log.d(TAG, "onActivityResult requestCode="
				+requestCode+",resultCode="+resultCode);
		if (REQUEST_CODE == requestCode && REQUEST_CODE == resultCode) {
			Bundle data = intent.getExtras();
			String resultCity = data.getString("city");
			if (mChoiceCityTxt != null) {
				mChoiceCityTxt.setText(resultCity);
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);
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
