/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-15
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-15 下午2:35:02
* @class SecondActivity.java
*/ 
package com.example.contents.five.intent;

import java.util.Set;

import com.example.dandan.R;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class SecondActivity extends Activity {

	private final String TAG = "ComponentAttrActivity";
	private Button mSkipBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mSkipBtn = (Button)findViewById(R.id.five_common_activity_main_btn);
		if (mSkipBtn != null) {
			mSkipBtn.setVisibility(View.INVISIBLE);
		}
		
		mShowTxt = (EditText)findViewById(R.id.five_common_activity_main_txt);
		if (mShowTxt != null) {
			ComponentName comp = null;
			comp = getIntent().getComponent();
			String action = getIntent().getAction();
			Set<String> cates = getIntent().getCategories();
			if (action != null) {
				mShowTxt.setText("action is :"+ action +"cates:" +cates);
			} else {
				mShowTxt.setText("组件包名：" + comp.getPackageName() + "\n" 
						+"类名：" + comp.getClassName());
			}
		}
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_common_activity_main);
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
