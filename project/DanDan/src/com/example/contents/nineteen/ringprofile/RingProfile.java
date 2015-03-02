package com.example.contents.nineteen.ringprofile;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RingProfile extends FragmentActivity{


	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.ring_profile_main);
		initialize();
	}
	
	private void initialize()
	{
		mTabHost = (FragmentTabHost)findViewById(R.id.ring_profile_main_tabhost);
		mTabContents = new String []
		{
		    "普通模式",
			"定时模式",
			"自定义模式"
		};
		
		mTabImages = new int[] 
		{
			R.drawable.normal,
			R.drawable.timeprofile,
			R.drawable.addprofile
		};
		
		mTabHost.setup(this, getSupportFragmentManager(),R.id.ring_profile_main_real_tabcontents);
	    
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getTabView(0)),
                FragmentPage1.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getTabView(1)),
                FragmentPage2.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getTabView(2)),
                FragmentPage3.class, null);
		
		mTabHost.setBackgroundResource(R.drawable.bg);
		mTabHost.setCurrentTab(0);
		mTab = 0;
		
		
	}
	
	@SuppressLint("InflateParams")
	private View getTabView(int index)
	{
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View view = layoutInflater.inflate(R.layout.ring_profile_tab_item_view, null);
		
		TextView tv = (TextView)view.findViewById(R.id.ring_profile_item_textview);
		if (tv != null) {
			Log.d(TAG, "getTabView tv != null");
			tv.setText(mTabContents[index]);
		} else {
			Log.d(TAG, "getTabView tv == null");
		}
		
		ImageView ig = (ImageView)view.findViewById(R.id.ring_profile_item_imageview);
		if (ig != null)
			ig.setImageResource(mTabImages[index]);
		return view;
	}
	
	private final String TAG = "RingProfile";
	private FragmentTabHost mTabHost;
	private String[] mTabContents;
	private int[] mTabImages;
	private int mTab;
}
