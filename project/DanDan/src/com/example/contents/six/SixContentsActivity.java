/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-1-19 ����9:27:01.
*/ 
package com.example.contents.six;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.six.attr.AttrActivity;
import com.example.contents.six.menu.MenuResActivity;
import com.example.contents.six.statelist.AnimationDrawableActivity;
import com.example.contents.six.statelist.ClipDrawableActivity;
import com.example.contents.six.statelist.LayerDrawablerActivity;
import com.example.contents.six.statelist.ShapeDrawableActivity;
import com.example.contents.six.statelist.StateListDrawbleActivity;
import com.example.contents.six.string.StringValue;
import com.example.contents.six.style.StyleResActivity;
import com.example.contents.six.xml.XmlExplainActivity;
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
	private final int EXPLAIN_XML = 5;
	private final int MENU_XML = 6;
	private final int STYLE = 7;
	private final int ATTR = 8;
	private final int STRING_VALUE = 9;
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
		case EXPLAIN_XML:
			Intent explain_xml = new Intent(SixContentsActivity.this,
					XmlExplainActivity.class);
			startActivity(explain_xml);
			break;
		case MENU_XML:
			Intent menu_xml = new Intent(SixContentsActivity.this,
					MenuResActivity.class);
			startActivity(menu_xml);
			break;
		case STYLE:
			Intent style_intent = new Intent(SixContentsActivity.this,
					StyleResActivity.class);
			startActivity(style_intent);
			break;
		case ATTR:	
			Intent attr_intent = new Intent(SixContentsActivity.this,
				AttrActivity.class);
			startActivity(attr_intent);
			break;
		case STRING_VALUE:
			Intent string_value = new Intent(SixContentsActivity.this,
					StringValue.class);
		    startActivity(string_value);
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
