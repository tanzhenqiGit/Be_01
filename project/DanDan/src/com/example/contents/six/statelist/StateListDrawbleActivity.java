/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-19 обнГ10:00:57.
*/ 
package com.example.contents.six.statelist;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Administrator
 *
 */
public class StateListDrawbleActivity extends Activity {

	private final String TAG = "StateListDrawbleActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.six_state_list_drawable_main);
	}

}
