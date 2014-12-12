/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 ÉÏÎç9:27:34
* @class SingChoiceDialogActivity.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class SingChoiceDialogActivity extends Activity {

	private final String TAG = "SingChoiceDialog";
	private final int SINGLE_DIALOG = 0x13;
	private Button mShowBtn;
	private EditText mShowText;
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowText = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowBtn != null) {
			mShowBtn.setOnClickListener(new OnClickListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					showDialog(SINGLE_DIALOG);
					
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
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateDialog(int, android.os.Bundle)
	 */
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch(id) {
		case SINGLE_DIALOG:
			Builder b = new AlertDialog.Builder(this);
			if (b != null) {
				b.setIcon(R.drawable.tools);
				b.setTitle("single choice list");
				b.setSingleChoiceItems(new String[]{
					"rad","yellow","blue"
				}, 1, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch(which) {
						case 0:
							if (mShowText != null) {
								mShowText.setBackgroundColor(Color.RED);
							}
							break;
						case 1:
							if (mShowText != null) {
								mShowText.setBackgroundColor(Color.YELLOW);
							}
							break;
						case 2:
							if (mShowText != null) {
								mShowText.setBackgroundColor(Color.BLUE);
							}
							break;
						default:
							break;
						}
						mShowText.setText("you chioce is "+which +"th");
					}
				});
				b.setPositiveButton("sure", null);
				return b.create();
			}
		default:
			
			break;
		}
		return null;
	}

	
}
