/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 下午1:34:02.
*/ 
package com.example.contents.four.activityresult;

import com.example.dandan.R;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class SelectCityActivity extends ExpandableListActivity {

	private String TAG = "SelectCityActivity";
	private String[][] mCitys = new String[][] {
			{"广州","深圳","珠海","中山"},
			{"桂林","柳州","南宁","北海"},
			{"长沙","岳阳","衡阳","株洲"}
	};
	private String[] mProvinces = null;
	
	private void initialize()
	{
		mProvinces = getResources().getStringArray(R.array.provinces);
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			
			private TextView getTextView()
			{
				AbsListView.LayoutParams lp 
					= new AbsListView.LayoutParams(
							ViewGroup.LayoutParams.MATCH_PARENT, 64);
				TextView textView = new TextView(SelectCityActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				Log.d(TAG,"isChildSelectable");
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				Log.d(TAG,"hasStableIds");
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(SelectCityActivity.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ImageView logo = new ImageView(SelectCityActivity.this);
				logo.setImageResource(R.drawable.bookmark);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				Log.d(TAG, "getGroupId");
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				Log.d(TAG, "getGroupCount");
				return mProvinces.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				Log.d(TAG, "getGroup groupPosition="+groupPosition);
				return mProvinces[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				Log.d(TAG, "getChildId groupPosition="+groupPosition);
				return mCitys[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				Log.d(TAG, "getChildView groupPosition="
						+groupPosition+",childPosition="+childPosition);
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				Log.d(TAG, "getChildId groupPosition="
						+groupPosition+",childPosition="+childPosition);
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				Log.d(TAG, "getChild groupPosition="
						+groupPosition+",childPosition="+childPosition);
				return mCitys[groupPosition][childPosition];
			}
		};
		setListAdapter(adapter);
		
		getExpandableListView().setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Intent intent = getIntent();
				intent.putExtra("city", mCitys[groupPosition][childPosition]);
				SelectCityActivity.this.setResult(ActivityForResult.REQUEST_CODE,
						intent);
				SelectCityActivity.this.finish();
				return false;
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

}
