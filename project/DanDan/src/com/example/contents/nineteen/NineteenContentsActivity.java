package com.example.contents.nineteen;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.nineteen.ringprofile.RingProfile;
import com.example.dandan.R;

public class NineteenContentsActivity extends CommonListActivity<String>{

	private final int RING_PROFILE = 0;
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
	switch(position)
	{
	case RING_PROFILE:
		Intent ring_profile = new Intent(NineteenContentsActivity.this, RingProfile.class);
		startActivity(ring_profile);
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
