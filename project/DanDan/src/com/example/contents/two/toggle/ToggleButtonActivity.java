/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014ÏÂÎç8:44:38
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time £º2014-12-2 ÏÂÎç8:44:38 
* class declare 
*/ 
package com.example.contents.two.toggle;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * @author free
 *
 */
public class ToggleButtonActivity extends Activity {

	private final String TAG = "ToggleButtonActivity";
	private ToggleButton mToggleButton;
	private LinearLayout mLayout;
	
	private void initialzie()
	{
		mToggleButton = (ToggleButton)findViewById(R.id.two_toggle_button_main_toggle_btn);
		mLayout = (LinearLayout)findViewById(R.id.two_toggle_button_main_layout);
		
		if (mToggleButton != null) {
			mToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {
						if (mLayout != null) {
							mLayout.setOrientation(LinearLayout.VERTICAL);
						} 
					} else {
						if (mLayout != null) {
							mLayout.setOrientation(LinearLayout.HORIZONTAL);
						} 
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_toggle_button_main);
		initialzie();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
