/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-11
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-11 下午5:35:21
* @class DialogActivity.java
*/ 
package com.example.contents.two.specialview;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
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
public class DialogActivity extends Activity {

	private final String TAG = "DialogActivity";
	private Button mButton;
	private void initialize()
	{
		mButton = (Button)findViewById(R.id.two_special_dialog_main_btn);
		final Builder buidler = new AlertDialog.Builder(this);
		if (mButton != null) {
			mButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (buidler != null) {
						buidler.setIcon(R.drawable.tools);
						buidler.setTitle("自定义普通对话框");
						buidler.setMessage("一个简单的提示对话框");
						
						buidler.setPositiveButton("确定",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText show = (EditText)findViewById(R.id.two_special_dialog_main_text);
								if (show != null) {
									show.setText("user clicked the sure button.");
								}
								
							}
						});
					 
						buidler.setNegativeButton("取消", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText show = (EditText)findViewById(R.id.two_special_dialog_main_text);
								if (show != null) {
									show.setText("user clicked the cancel button.");
								}
							}
						});
						
						buidler.create().show();
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
		Log.d(TAG, "oDestroy");
		super.onDestroy();
	}

}
