package com.example.contents.nineteen;

import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.dandan.R;

public class NineteenContentsActivity extends CommonListActivity<String>{

	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
	switch(position)
	{
	case 1:
		
		break;
	default:
		
	}
		
	}

	@Override
	public void onPrepareContents() {
		String[] content = getResources().getStringArray(R.array.chapterNineteenContents);
		prepareContents(content);
	}

}
