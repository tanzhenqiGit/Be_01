/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-7 ÏÂÎç4:59:42.
*/ 
package com.example.contents.two.viewanimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * @author Administrator
 *
 */
public class ImageSwitcherActivity extends Activity {

	private final String TAG = "ImageSwitchActivity";
	private ImageSwitcher mImageSwitcher;
	
	private int [] mImageIds =  new int[]{
			R.drawable.bomb5,
			R.drawable.bomb6,
			R.drawable.bomb7,
			R.drawable.bomb8,
			
			R.drawable.bomb9,
			R.drawable.bomb10,
			R.drawable.bomb11,
			R.drawable.bomb12,
			
			R.drawable.bomb13,
			R.drawable.bomb14,
			R.drawable.bomb15,
			R.drawable.bomb16
	};
	
	
	private void initialize()
	{
		mImageSwitcher = (ImageSwitcher)findViewById(R.id.two_imageswitcher_main_switcher);
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < mImageIds.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image",mImageIds[i]);
			lists.add(item);
		}
		
		if (mImageSwitcher != null) {
			mImageSwitcher.setFactory(new ViewFactory() {
				
				@Override
				public View makeView() {
					Log.d(TAG, "makeview");
					ImageView iv = new ImageView(ImageSwitcherActivity.this);
					iv.setScaleType(ImageView.ScaleType.FIT_XY);
					iv.setLayoutParams(new ImageSwitcher.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
					
					return iv;
				}
			});
		}
		
		SimpleAdapter adapter = new SimpleAdapter(
				this, 
				lists, 
				R.layout.two_gridview_cell, 
				new String[]{"image"}, 
				new int[]{R.id.two_gridview_cell_image});
		GridView grid = (GridView)findViewById(R.id.two_imageswitcher_main_grid);
		
		if (grid != null) {
			grid.setAdapter(adapter);
			Log.d(TAG, "setAdapter");
			grid.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View source,
						int position, long id) {
					// TODO Auto-generated method stub
					Log.d(TAG,"onItemClick position=" + position);
					if (mImageSwitcher != null) {
						mImageSwitcher.setImageResource(mImageIds[position]);
					} else {
						Log.d(TAG, "onItemClick mImageSwitcher == null");
					}
				}
			});
			
			grid.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int position, long id) {
					Log.d(TAG,"onItemSelected position=" + position);
					if (mImageSwitcher != null) {
						mImageSwitcher.setImageResource(mImageIds[position]);
					} else {
						Log.d(TAG, "setOnItemSelectedListener mImageSwitcher == null");
					}
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					Log.d(TAG, "onNothingSelected");
					
				}
			});
		} else {
			Log.d(TAG, "grid == null");
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_imageswitcher_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
