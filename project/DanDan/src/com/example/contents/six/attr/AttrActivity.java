/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 ����5:32:51
* @class AttrActivity.java
*/ 
package com.example.contents.six.attr;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author free
 *
 */
public class AttrActivity extends Activity {

	private final String TAG = "AttrActivity";
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.six_attr_main);
	}

}
