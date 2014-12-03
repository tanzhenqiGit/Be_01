/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-3 ÏÂÎç10:56:44.
*/ 
package com.example.contents.two.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

/**
 * @author Administrator
 *
 */
public class GridViewTest extends Activity {

	private final String TAG = "GridViewTest";
	
	private GridView mGrid;
	private ImageView mImage;
	int [] mImageIds =  new int[]{
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
		List<Map<String,Object>> listItems 
			= new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < mImageIds.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", mImageIds[i]);
			listItems.add(listItem);
		}
		
		mImage = (ImageView)findViewById(R.id.two_gridview_main_imageview);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
				R.layout.two_gridview_cell,
				new String[]{"image"}, new int[]{R.id.two_gridview_cell_image});
		mGrid = (GridView)findViewById(R.id.two_gridview_main_grid);
		if (mGrid == null) {
			Log.d(TAG, "mGrid == null");
			return;
		}
		mGrid.setAdapter(simpleAdapter);
		
		mGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				if (mImage != null) {
					mImage.setImageResource(mImageIds[position]);
				}
				
			}
		});
		
		mGrid.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				if (mImage != null) {
					mImage.setImageResource(mImageIds[position]);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_gridview_main);
		initialize();
	}

}
