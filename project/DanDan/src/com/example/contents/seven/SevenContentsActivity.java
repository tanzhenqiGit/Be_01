package com.example.contents.seven;


import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.dandan.R;

public class SevenContentsActivity extends CommonListActivity<String>{

	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position)
		{
		case 0:
			
			break;
		default:
			
			break;
		
		}
		
	}

	@Override
	public void onPrepareContents() {
		String[] contents = getResources().getStringArray(R.array.chapterSevenContents);
		prepareContents(contents);
	}

}
