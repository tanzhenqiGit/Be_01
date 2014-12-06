/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-6 下午3:34:05.
*/ 
package com.example.contents.two.expandablelistview;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class ExpandableListViewActivity extends Activity {

	private final String TAG = "ExpandableListViewActivity";
	private ExpandableListView mExpandList;
	private int[] mLogos = new int [] {
			R.drawable.p,
			R.drawable.z,
			R.drawable.t
	};
	
	private String[] mArmTypes = new String[] {
			"神族兵种",
			"虫族兵种",
			"人族兵种"
	};
	
	private String[][] mArms = new String[][] {
			{"狂战士","龙骑士","黑暗圣堂","电兵"},
			{"小狗","刺蛇","飞龙","自爆飞机"},
			{"机枪兵","护士MM","幽灵","僵尸"}
	};
	
	
	private void initialize()
	{
		mExpandList = (ExpandableListView)findViewById(
				R.id.two_expandable_list_view_main_list);
		if (mExpandList == null) {
			Log.e(TAG, "mExpandList == null");
			return ;
		}
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			
			private TextView getTextView()
			{
				TextView textview = new TextView(ExpandableListViewActivity.this);
				if (textview != null) {
					AbsListView.LayoutParams lp = 
							new AbsListView.LayoutParams(
									ViewGroup.LayoutParams.MATCH_PARENT, 64);
					textview.setLayoutParams(lp);
					textview.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
					textview.setPadding(36, 0, 0, 0);
					textview.setTextSize(20);
				}
				return textview;
			}
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(ExpandableListViewActivity.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ImageView loge = new ImageView(ExpandableListViewActivity.this);
				loge.setImageResource(mLogos[groupPosition]);
				TextView tv = getTextView();
				tv.setText(getGroup(groupPosition).toString());
				ll.addView(loge);
				ll.addView(tv);
				return ll;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				return mArmTypes.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				return mArmTypes[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				return mArms[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView text = getTextView();
				text.setText(getChild(groupPosition, childPosition).toString());
				return text;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				
				return mArms[groupPosition][childPosition];
			}
		};
		
		if (mExpandList != null) {
			mExpandList.setAdapter(adapter);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_expandable_list_view_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}


	
}
