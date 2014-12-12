/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 上午10:40:34
* @class CustomListDialog.java
*/ 
package com.example.contents.two.specialview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

/**
 * @author free
 *
 */
public class CustomListDialog extends Activity {

	private final String TAG = "CustomListDialog";
	private final int LIST_DIALOG = 0x113;
	private String[] mNames = new String[]{
		"神族","虫族","人族"	
	};
	private String[] mLifeValue = new String[] {
		"100","120","80"	
	};
	private int[] mImages = new int[] {
		R.drawable.p,R.drawable.z, R.drawable.t
	};
	private Button mShowBtn;
	private EditText mShowTxt;
	
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		
		if (mShowBtn != null) {
			mShowBtn.setOnClickListener(new View.OnClickListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					showDialog(LIST_DIALOG);
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
		case LIST_DIALOG:
			Builder b = new AlertDialog.Builder(this);
			if (b != null) {
				b.setIcon(R.drawable.tools);
				b.setTitle("custom List Dialog");
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < mNames.length; i++) {
					Map<String, Object> list = new HashMap<String, Object>();
					list.put("headerImage", mImages[i]);
					list.put("personName",mNames[i]);
					list.put("lifeValue", mLifeValue[i]);
					listItems.add(list);
				}
				
				SimpleAdapter simpleAdapter = new SimpleAdapter(this, 
						listItems, 
						R.layout.two_simpleadapter_item, new String[]{
							"headerImage","personName","lifeValue"
						}, new int[]{R.id.two_simpleadapter_item_header,
							R.id.two_simpleadapter_item_name,
							R.id.two_simpleadapter_item_desc,});
				
				b.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (mShowTxt != null) {
							mShowTxt.setText("you good at:" + mNames[which]);
						}
						
					}
				});
				return b.create();
			}

		}
		
		return null;
	}
	
	
}
