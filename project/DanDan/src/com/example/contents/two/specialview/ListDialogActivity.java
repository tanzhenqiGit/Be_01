/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-11
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-11 ÏÂÎç6:05:25
* @class ListDialogActivity.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class ListDialogActivity extends Activity {

	private final String TAG = "ListDialogActivity";
	private EditText mShowText;
	private Button	mShowBtn;
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowText = (EditText)findViewById(R.id.two_special_dialog_main_text);
		final Builder builder = new AlertDialog.Builder(this);
		
		if (mShowBtn != null) {
			mShowBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (builder != null) {
						builder.setIcon(R.drawable.tools);
						builder.setTitle("simple list dialog");
						builder.setItems(new String[]{
							"red",
							"yellow",
							"blue"
						}, new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								switch(which) {
								case 0:
									mShowText.setBackgroundColor(Color.RED);
									break;
								case 1:
									mShowText.setBackgroundColor(Color.YELLOW);
									break;
								case 2:
									mShowText.setBackgroundColor(Color.BLUE);
									break;
								}
								mShowText.setText("AlertListDialog +" + which +"th");
							}
						});
						
						builder.create().show();
					}
					
				}
			});
			
		}
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
