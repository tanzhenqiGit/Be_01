/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014����4:09:05
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time ��2014-12-1 ����4:09:05 
* class declare 
*/ 
package com.example.contents.three.configuration;

import com.example.dandan.R;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class ConfigurationActivity extends Activity {

	private final String TAG = "ConfigurationActivity";
	private EditText mOrientationText, mNavigationText, mTouchStsText, mMNCStsText;
	private Button mGetPhoneStsBtn;
	
	
	private void initialize()
	{
		mOrientationText = (EditText)findViewById(R.id.three_configuration_activity_main_orientation_text);
		mNavigationText = (EditText)findViewById(R.id.three_configuration_activity_main_navigation_text);
		mTouchStsText = (EditText)findViewById(R.id.three_configuration_activity_main_touchsts_text);
		mMNCStsText = (EditText)findViewById(R.id.three_configuration_activity_main_mncsts_text);
		
		mGetPhoneStsBtn = (Button)findViewById(R.id.three_configuration_activity_main_getphonests_btn);
		if (mGetPhoneStsBtn != null) {
			mGetPhoneStsBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG,"mGetPhoneSts is clicked.");
					Configuration cfg = getResources().getConfiguration();
					String screen = cfg.orientation ==
							Configuration.ORIENTATION_LANDSCAPE ? "����" : "����";
					
					String nmCode = cfg.mnc + "";
					String navigationName = cfg.orientation == Configuration.NAVIGATION_NONAV ?
							"û�з���"
							: cfg.orientation == Configuration.NAVIGATION_WHEEL ?
								 "���ֿ��Ʒ���" :
									cfg.orientation == Configuration.NAVIGATION_DPAD ?
											"��������Ʒ���" : "�켣���Ʒ���";
					String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ?
							"�޴�����" : cfg.touchscreen == Configuration.TOUCHSCREEN_STYLUS ?
									"������Ļ" : "������ָ�Ĵ�����";
					
					if (mNavigationText != null) {
						mNavigationText.setText(navigationName);
					}
					
					if (mMNCStsText != null) {
						mMNCStsText.setText(nmCode);
					}
					
					if (mOrientationText != null) {
						mOrientationText.setText(screen);
					}
					
					if (mTouchStsText != null) {
						mTouchStsText.setText(touchName);
					}
					
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	
}
