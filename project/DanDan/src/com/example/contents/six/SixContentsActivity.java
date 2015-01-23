/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-19 ÏÂÎç9:27:01.
*/ 
package com.example.contents.six;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.six.statelist.AnimationDrawableActivity;
import com.example.contents.six.statelist.ClipDrawableActivity;
import com.example.contents.six.statelist.LayerDrawablerActivity;
import com.example.contents.six.statelist.ShapeDrawableActivity;
import com.example.contents.six.statelist.StateListDrawbleActivity;
import com.example.dandan.R;

/**
 * @author Administrator
 *
 */
public class SixContentsActivity extends CommonListActivity<String> {

	private final int STATE_LIST_DRAWABLE = 0;
	private final int LAYER_DRAWABLER = 1;
	private final int SHAPE_DRAWABLE_TEST = 2;
	private final int CLIP_DRAWABLE = 3;
	private final int ANIMATION_DRAWABLE = 4;
	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#handlerOnItemListClicked(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch (position) {
		case STATE_LIST_DRAWABLE:
			Intent state_list_drawable = new Intent(SixContentsActivity.this, 
					StateListDrawbleActivity.class);
			startActivity(state_list_drawable);
			break;
		case LAYER_DRAWABLER:
			Intent layer_drawabler = new Intent(SixContentsActivity.this, 
					LayerDrawablerActivity.class);
			startActivity(layer_drawabler);
			break;
		case SHAPE_DRAWABLE_TEST:
			Intent shape_drawabler = new Intent(SixContentsActivity.this, 
					ShapeDrawableActivity.class);
			startActivity(shape_drawabler);
			break;
		case CLIP_DRAWABLE:
			Intent clip_drawabler = new Intent(SixContentsActivity.this, 
				ClipDrawableActivity.class);
			startActivity(clip_drawabler);
			break;
		case ANIMATION_DRAWABLE:
			Intent animation_drawable = new Intent(SixContentsActivity.this,
				AnimationDrawableActivity.class);
			startActivity(animation_drawable);
			break;
		default:
			
			break;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.example.contents.CommonListActivity#onPrepareContents()
	 */
	@Override
	public void onPrepareContents() {
		String[] contents = getResources().getStringArray(R.array.chapterSixContents);
		prepareContents(contents);
		
	}

}
