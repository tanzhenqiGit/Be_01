/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç9:16:30.
*/ 
package com.example.contents.four.fragment;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Administrator
 *
 */
public class SelectBookActivity extends Activity 
	implements BookListFragment.Callbacks{

	private final String TAG = "BookDetailFragment";
	/* (non-Javadoc)
	 * @see com.example.contents.four.fragment.BookListFragment.Callbacks#onItemSelected(java.lang.Integer)
	 */
	@SuppressLint("NewApi")
	@Override
	public void onItemSelected(Integer id) {
		Log.d(TAG,"SelectBookActivity onItemSelected ");
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		BookDetailFragment fragment = new BookDetailFragment();
		fragment.setArguments(arguments);
		getFragmentManager().beginTransaction()
			.replace(
					R.id.four_book_detail_fragment_twopane_book_container,
					fragment).commit();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_book_detail_fragment_twopane);
	}
	
	

}
