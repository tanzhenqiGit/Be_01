/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç8:52:25.
*/ 
package com.example.contents.four.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Administrator
 *
 */
@SuppressLint("NewApi")
public class BookListFragment extends ListFragment {

	private Callbacks mCallbacks;
	private final String TAG = "BookDetailFragment";
	public interface Callbacks
	{
		public void onItemSelected(Integer id);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "bookListFragment onCreate");
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<BookContent.Book>(
				getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1,
				BookContent.ITEMS));
	}
	@Override
	public void onAttach(Activity activity) 
	{
		Log.d(TAG, "bookListFragment onAttach");
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activiy contain " +
					"BookListFragment must implementation Callback");
		}
		mCallbacks = (Callbacks)activity;
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		Log.d(TAG, "bookListFragment onListItemClick");
		super.onListItemClick(l, v, position, id);
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).mId);
	}
	@Override
	public void onDetach() {
		Log.d(TAG, "bookListFragment onDetach");
		super.onDetach();
		mCallbacks = null;
	}
	
	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		getListView().setChoiceMode(
				activateOnItemClick ? 
						ListView.CHOICE_MODE_SINGLE 
						: ListView.CHOICE_MODE_NONE);
	}

}
