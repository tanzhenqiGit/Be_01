/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç8:04:55.
*/ 
package com.example.contents.four.fragment;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
@SuppressLint("NewApi")
public class BookDetailFragment extends Fragment {

	private final String TAG = "BookDetailFragment";
	public static final String ITEM_ID = "item_id";
	private BookContent.Book mBook;
	private void initialize()
	{
		if (getArguments().containsKey(ITEM_ID))
		{
			mBook = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView");
		
		View rootView = inflater.inflate(
				R.layout.four_book_detail_fragment, container, false);
		if (mBook != null) {
			((TextView)rootView.findViewById(
					R.id.four_book_detail_fragment_booktitle_txt))
					.setText(mBook.mTitle);
			((TextView)rootView.findViewById(
					R.id.four_book_detail_fragment_bookdesc_txt))
					.setText(mBook.mDesc);
			
		}
		return rootView;
	}

	@Override
	public void onPause() {
		Log.d(TAG,"onPause");
		super.onPause();
	}

}
