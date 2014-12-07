package com.example.contents.four.otheractivity;

import com.example.dandan.R;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ArmsExpandableListActivity extends ExpandableListActivity {

	private final String TAG = "ArmsExpandableListActivity";
	private int [] mLogos = new int []
	{
		R.drawable.p,
		R.drawable.z,
		R.drawable.t
	};
	
	private String[] mArmTypes = {
		"Divine Arms",
		"Insect Arms",
		"Person Arms"
	};
	
	private String[][] mArms = {
		{"Berserker", "Dragoon", "BlackTemplar", "HighTemplar"},
		{"Puppy","Hydralisk", "Pterosaur","SelfDistructionAirCraft"},
		{"Marine","Nurse","Ghost"}
	};
	private void initialize()
	{
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			
			private TextView getTextView()
			{
				AbsListView.LayoutParams lp 
					= new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 64);
				TextView textView = new TextView(ArmsExpandableListActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(ArmsExpandableListActivity.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ImageView logo = new ImageView(ArmsExpandableListActivity.this);
				logo.setImageResource(mLogos[groupPosition]);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
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
				// TODO Auto-generated method stub
				return mArmTypes[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				
				return mArms[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition,childPosition).toString());
				return textView;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				Log.d(TAG,"getChildId groupPosition="+ groupPosition +
						",childPosition="+childPosition);
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				Log.d(TAG,"getChild groupPosition="+ groupPosition +
						",childPosition="+childPosition);
				return mArms[groupPosition][childPosition];
			}
		};
		setListAdapter(adapter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}



}
