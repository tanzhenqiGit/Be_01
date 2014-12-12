/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 ÉÏÎç10:18:18
* @class MultiChoiceDialog.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class MultiChoiceDialog extends Activity {

	private final String TAG = "MultiChoiceDialog";
	private Button mShowBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		final Builder builder = new AlertDialog.Builder(this);
		final boolean[] checkSts = new boolean[] {false,true, true};
		final String [] colorNames = new String[]{"red","yellow","blue"};
		if (mShowBtn != null) {
			Log.d(TAG,"mShowBtn != null	");
			mShowBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (builder != null) {
						Log.d(TAG, "builder != null");
						builder.setMultiChoiceItems(colorNames,
								checkSts,
					    new OnMultiChoiceClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which, boolean isChecked) {
								String result = "you love color is:";
								for (int i = 0; i < checkSts.length; i++) {
									if (checkSts[i]) {
										result += colorNames[i]+"¡¢";
									}
								}
								mShowTxt.setText(result);
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
