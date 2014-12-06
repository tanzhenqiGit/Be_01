/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 ÏÂÎç7:04:43.
*/ 
package com.example.contents.two.adapterviewflpper;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Administrator
 *
 */
@SuppressLint("NewApi")
public class AdapterViewFliperActivity extends Activity {

	private final String TAG = "AdapterViewFliperActivity";
	private Button mPrevBtn, mNextBtn, mAutoPlayBtn;
	private AdapterViewFlipper mAdapterViewFlipper;
	private int [] mImageIds =  new int[]{
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
	private void setFilpper()
	{
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView iv = new ImageView(AdapterViewFliperActivity.this);
				iv.setImageResource(mImageIds[position]);
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
				iv.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
				
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
				return mImageIds.length;
			}
		};
		if (mAdapterViewFlipper != null) {
			mAdapterViewFlipper.setAdapter(adapter);
		} else {
			Log.e(TAG,"mAdapterViewFlipper == null");
		}
	}
	private void initialize()
	{
		mAdapterViewFlipper = (AdapterViewFlipper)findViewById(
				R.id.two_adapterviewfliper_activity_main_fliper);
		setFilpper();
		mPrevBtn = (Button)findViewById(
				R.id.two_adapterviewfliper_activity_main_prev);
		if (mPrevBtn != null) {
			mPrevBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mAdapterViewFlipper != null) {
						mAdapterViewFlipper.showPrevious();
						mAdapterViewFlipper.stopFlipping();
					}
					
				}
			});
		} else {
			Log.e(TAG,"mPrevBtn == null");
		}
		mNextBtn = (Button)findViewById(
				R.id.two_adapterviewfliper_activity_main_next);
		if (mNextBtn != null) {
			mNextBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mAdapterViewFlipper != null) {
						mAdapterViewFlipper.showNext();
						mAdapterViewFlipper.stopFlipping();
					}
					
				}
			});
		} else {
			Log.e(TAG,"mNextbtn == null");
		}
		mAutoPlayBtn =  (Button)findViewById(
				R.id.two_adapterviewfliper_activity_main_auto);
		if (mAutoPlayBtn != null) {
			mAutoPlayBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mAdapterViewFlipper != null) {
						mAdapterViewFlipper.startFlipping();
					}
					
				}
			});
		} else {
			Log.d(TAG, "mAutoPlayBtn == null");
		}
			
		
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_adapterviewfliper_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
