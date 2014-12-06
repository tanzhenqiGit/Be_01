/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç7:56:44.
*/ 
package com.example.contents.two.stackview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.StackView;

/**
 * @author Administrator
 *
 */
public class StackViewActivity extends Activity {

	private final String TAG = "StackViewActivity";
	private Button mPrevBtn, mNextBtn;
	private StackView mStackView;
	private int[] mImages = new int [] {
			R.drawable.android,
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.shui,
			R.drawable.android,
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.shui
	};
			
	
	@SuppressLint("NewApi")
	private void setStackView()
	{
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < mImages.length; i++) {
			Map<String,Object> item = new HashMap<String, Object>();
			item.put("image", mImages[i]);
			listItems.add(item);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(
				StackViewActivity.this, 
				listItems, 
				R.layout.two_stackview_activity_cell, 
				new String[] {"image"}, 
				new int[]{R.id.two_stackview_cell_image});
		
		if (mStackView != null) {
			mStackView.setAdapter(adapter);
		}
	}
	
	@SuppressLint("NewApi")
	private void initialize()
	{
		mPrevBtn = (Button)findViewById(R.id.two_stackview_activity_main_prev);
		if (mPrevBtn != null) {
			mPrevBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mPrevBtn is onclicked");
					if (mStackView != null) {
						mStackView.showPrevious();
					} else {
						Log.d(TAG, "mStackView == null");
					}
				}
			});
		}
		mNextBtn = (Button)findViewById(R.id.two_stackview_actvity_main_next);
		if (mNextBtn != null) {
			mNextBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "mNextBtn is onClicked");
					if (mStackView != null) {
						mStackView.showNext();
					} else {
						Log.d(TAG, "mStackView == null");
					}
				}
			});
		}
		
		mStackView = (StackView)findViewById(R.id.two_stackview_activity_main_stackview);
		setStackView();
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_stackview_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

}
