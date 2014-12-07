/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-7 ÏÂÎç3:45:31.
*/ 
package com.example.contents.two.viewanimator;

import java.util.ArrayList;
import java.util.List;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * @author Administrator
 *
 */
public class ViewSwitcherActivity extends Activity {

	private final String TAG = "ViewSwitcherActivity";
	private static final int NUMBER_PER_SCREEN = 15;
	private static final int MAX_ITEM = 40;
	private Button mPrevBtn, mNextBtn;
	private ViewSwitcher mViewSwitcher;
	private int mScreenCount;
	private int mCurScreen = -1;
	private List<DataItem> mListItems = new ArrayList<DataItem>();
	private LayoutInflater mInflater;
	
	private enum SHOW_TYPE {
		TYPE_NEXT,
		TYPE_PREV,
	};
	
	public static class DataItem
	{
		public String   mDataName;
		public Drawable mDrawable;
	}
	private class ButtonListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			switch(v.getId())
			{
			case R.id.two_viewswitch_main_next_btn:
				ButtonCallback(SHOW_TYPE.TYPE_NEXT);
				break;
			case R.id.two_viewswitch_main_prev_btn:
				ButtonCallback(SHOW_TYPE.TYPE_PREV);
				break;
			default:
				Log.d(TAG, "onclick default");
				break;
			}
			
		}
		
	}
	
	private BaseAdapter mAdapter = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertview, ViewGroup parent) {
			View view = convertview;
			if (convertview == null) {
				Log.d(TAG, "convertview == null");
			} else {
				Log.d(TAG, "convertview != null");
			}
			
			if (mInflater != null) {
				view = mInflater.inflate(R.layout.two_viewswitcher_gridview_cell, null);
			}
			ImageView iv = (ImageView)view.findViewById(R.id.two_viewswitcher_cell_image);
			if (iv != null) {
				iv.setImageDrawable(getItem(position).mDrawable);
			}
			TextView tv = (TextView)view.findViewById(R.id.two_viewswitcher_cell_text);
			if (tv != null) {
				tv.setText(getItem(position).mDataName);
			}
			return view;
		}
		
		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public DataItem getItem(int position) {
			return mListItems.get(position);
		}
		
		@Override
		public int getCount() {
			if (mListItems.size() % NUMBER_PER_SCREEN != 0
					&& mCurScreen == mScreenCount - 1) {
				return mListItems.size() % NUMBER_PER_SCREEN;
			} else {
				return NUMBER_PER_SCREEN;
			}
		}
	};
	
	private void ButtonCallback(SHOW_TYPE type)
	{
		
		if (mViewSwitcher != null) {
			mViewSwitcher.setInAnimation(this, R.animator.slide_in_right);
			mViewSwitcher.setOutAnimation(this, R.animator.slide_out_left);
			((GridView)mViewSwitcher.getNextView()
					.findViewById(R.id.two_viewswitcher_gridview_grid))
					.setAdapter(mAdapter);
		} else {
			Log.d(TAG,"mViewSwitcher == null");
			return;
		}
		if (type == SHOW_TYPE.TYPE_NEXT) {
			if (mCurScreen < mScreenCount - 1) {
				mCurScreen++;
				mViewSwitcher.showNext();
			}
		} else if (type == SHOW_TYPE.TYPE_PREV) {
			if (mCurScreen > 0) {
				mCurScreen--;
				mViewSwitcher.showPrevious();
			}
		} else {
			Log.d(TAG, "type error");
		}
	}
	
	
	private void initializeList()
	{
		if (mListItems != null) {
			for (int i = 0; i < MAX_ITEM; i++) {
				String lable = i + "th Icon";
				Drawable drawable = getResources().getDrawable(R.drawable.music);
				DataItem item = new DataItem();
				item.mDataName = lable;
				item.mDrawable = drawable;
				mListItems.add(item);
			}
		} else {
			Log.d(TAG, "mListItems == null");
		}
	}
	
	private void initialize()
	{
		initializeList();
		mInflater = LayoutInflater.from(ViewSwitcherActivity.this);
		mScreenCount = mListItems.size() % NUMBER_PER_SCREEN == 0
				? mListItems.size() / NUMBER_PER_SCREEN 
				: mListItems.size() / NUMBER_PER_SCREEN + 1;
				
		mViewSwitcher = (ViewSwitcher)findViewById(R.id.two_viewswitcher_main_switcher);
		if (mViewSwitcher != null) {
			mViewSwitcher.setFactory(new ViewFactory() {
				
				@Override
				public View makeView() {
					if (mInflater != null) {
						return mInflater.inflate(R.layout.two_viewswithcer_gridview, null);
					}
					Log.d(TAG, "mInflater == null");
					return null;
				}
			});
			ButtonCallback(SHOW_TYPE.TYPE_NEXT);
		}
		mPrevBtn = (Button)findViewById(R.id.two_viewswitch_main_prev_btn);
		if (mPrevBtn != null) {
			mPrevBtn.setOnClickListener(new ButtonListener());
		}
		mNextBtn = (Button)findViewById(R.id.two_viewswitch_main_next_btn);
		if (mNextBtn != null) {
			mNextBtn.setOnClickListener(new ButtonListener());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_viewswither_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
