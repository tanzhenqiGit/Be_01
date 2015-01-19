/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-19 обнГ10:37:18.
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
public class LayerDrawablerActivity extends Activity {

	private final String TAG = "LayerDrawablerActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.six_layer_drawable_main);
	}

}
