/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç4:27:34.
*/ 
package com.example.contents.two.gallary;

import com.example.dandan.R;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class GallaryActivity extends Activity {
	private final String TAG = "GallaryActivity";
	private Gallery mGallery;
	private ImageView mImageView;
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
	
	private void initialize()
	{
		mImageView = (ImageView)findViewById(R.id.two_gallary_activity_imageview);
		mGallery = (Gallery)findViewById(R.id.two_gallart_activity_gallery);
		
		BaseAdapter  adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView iv = new ImageView(GallaryActivity.this);
				iv.setImageResource(mImages[position]);
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
				iv.setLayoutParams(new Gallery.LayoutParams(150,200));
				TypedArray typeArray = obtainStyledAttributes(R.styleable.Gallery);
				iv.setBackgroundResource(typeArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0));
				return iv;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return position;
			}
			
			@Override
			public int getCount() {
				return mImages.length;
			}
		};
		if (mGallery != null) {
			mGallery.setAdapter(adapter);
		}
		
		mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View source,
					int position, long id) {
				if (mImageView != null) {
					mImageView.setImageResource(mImages[position]);
				} else {
					Log.d(TAG,"mImageView == null");
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.d(TAG,"onNothingSelected");
				
			}
	
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_gallary_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
