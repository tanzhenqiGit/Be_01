/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 ÉÏÎç11:34:11
* @class PopupWindowActivity.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

/**
 * @author free
 *
 */
public class PopupWindowActivity extends Activity {
	
	private final String TAG = "PopupWindowActivity";
	private Button mShowBtn;
	private EditText mShowText;
	

	@SuppressLint("InflateParams")
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowText = (EditText)findViewById(R.id.two_special_dialog_main_text);
		View root = this.getLayoutInflater().inflate(R.layout.two_popup_window_layout, null);
		final PopupWindow ppWindow = new PopupWindow(root,280,360);

		if (mShowText != null) {
			mShowText.setVisibility(View.INVISIBLE);
		}
		if (mShowBtn != null) {
		    mShowBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (ppWindow != null) {
						//ppWindow.showAsDropDown(v);
						ppWindow.showAtLocation(findViewById(R.id.two_special_dialog_main_btn),
								Gravity.CENTER, 0, 0);
						
					}
					
				}
		    });
		}
		
		root.findViewById(R.id.two_popup_window_layout_close).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (ppWindow != null) {
					ppWindow.dismiss();
				}
				
			}
		});
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
}
