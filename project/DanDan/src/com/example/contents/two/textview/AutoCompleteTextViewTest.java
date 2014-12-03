/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-3 ÏÂÎç10:24:39.
*/ 
package com.example.contents.two.textview;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * @author Administrator
 *
 */
public class AutoCompleteTextViewTest extends Activity {
	
	private final String TAG = "AutoCompleteTextView";
	private AutoCompleteTextView mAutotext;
	private MultiAutoCompleteTextView mMult;
	private String[] mBooks = new String[]{
			"a·è¿ñJava½²Òå",
			"a·è¿ñAndroid½²Òå",
			"a·è¿ñXML½²Òå",
			"a·è¿ñworkflow½²Òå"
	};
	
	private void initialize()
	{
		mAutotext = (AutoCompleteTextView)findViewById(
				R.id.two_audocomplete_textview_main_auto);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(
				this, android.R.layout.simple_dropdown_item_1line,mBooks);
		if (mAutotext != null) {
			mAutotext.setAdapter(aa);
		}
		
		mMult = (MultiAutoCompleteTextView)findViewById(
				R.id.two_audocomplete_textview_main_mult);
		if (mMult != null) {
			mMult.setAdapter(aa);
			mMult.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		}
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_autocomplete_textview_main);
		initialize();
	}

	
}
