/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014����1:22:44
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time ��2014-12-2 ����1:22:44 
* class declare 
*/ 
package com.example.contents.two;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.contents.CommonListActivity;
import com.example.contents.two.adapterviewflpper.AdapterViewFliperActivity;
import com.example.contents.two.baseadapter.BaseAdapterTest;
import com.example.contents.two.chronometer.ChronometerActivity;
import com.example.contents.two.expandablelistview.ExpandableListViewActivity;
import com.example.contents.two.gallary.GallaryActivity;
import com.example.contents.two.gridview.GridViewTest;
import com.example.contents.two.imageview.ImageViewActivity;
import com.example.contents.two.listactivity.MyListActivity;
import com.example.contents.two.progressbar.ProgressBarActivity;
import com.example.contents.two.progressbar.RatingBarActivity;
import com.example.contents.two.progressbar.SeekBarActivity;
import com.example.contents.two.progressbar.TitleProgressBar;
import com.example.contents.two.simpleadapter.SimpleAdapterTest;
import com.example.contents.two.specialview.DialogActivity;
import com.example.contents.two.specialview.ListDialogActivity;
import com.example.contents.two.specialview.MultiChoiceDialog;
import com.example.contents.two.specialview.SingChoiceDialogActivity;
import com.example.contents.two.specialview.TabHostActivity;
import com.example.contents.two.spinner.SpinnerActivityTest;
import com.example.contents.two.stackview.StackViewActivity;
import com.example.contents.two.textview.AutoCompleteTextViewTest;
import com.example.contents.two.toggle.ToggleButtonActivity;
import com.example.contents.two.viewanimator.ImageSwitcherActivity;
import com.example.contents.two.viewanimator.TextSwitchActivity;
import com.example.contents.two.viewanimator.ViewFlipperActivity;
import com.example.contents.two.viewanimator.ViewSwitcherActivity;
import com.example.dandan.R;

/**
 * @author free
 *
 */
public class TwoContentsActivity extends CommonListActivity<String> {

	private final String TAG = "TwoContentsActivity";
	private final int TOGGLE_BUTTON = 0;
	private final int CHRONOMETER = 1;
	private final int IMAGEVIEW = 2;
	private final int LIST_ACTIVITY = 3;
	private final int SIMPLE_ADAPTER = 4;
	private final int BASE_ADAPTER = 5;
	private final int AUTO_COMPLETE_TEXT = 6;
	private final int GRID_VIEW = 7;
	private final int SPINNER_ACTIVITY = 8;
	private final int EXPANDABLE_LIST_VIEW = 9;
	private final int GALLARY_ACTIVITY = 10;
	private final int ADAPTER_VIEW_FLIPPER = 11;
	private final int STACK_VIEW = 12;
	private final int PROGRESS_BAR = 13;
	private final int TITLE_PROGRESS_BAR = 14;
	private final int SEEK_BAR = 15;
	private final int RATING_BAR = 16;
	private final int VIEW_SWITCHER = 17;
	private final int IMAGE_SWITCHER = 18;
	private final int TEXT_SWITCHER = 19;
	private final int VIEW_FLIPPER = 20;
	private final int TAB_HOST = 21;
	private final int DIALOG = 22;
	private final int LIST_DIALOG = 23;
	private final int SINGLE_CHOICE_DIALOG = 24;
	private final int MULTI_CHOICE_DIALOG = 25;
	@Override
	public void handlerOnItemListClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch(position) {
		case TOGGLE_BUTTON:
			Intent toggle_button_intent 
				= new Intent(TwoContentsActivity.this, ToggleButtonActivity.class);
			startActivity(toggle_button_intent);
			break;
		case CHRONOMETER:
			Intent chronometer_intent 
				= new Intent(TwoContentsActivity.this, ChronometerActivity.class);
			startActivity(chronometer_intent);
			break;
		case IMAGEVIEW:
			Intent imageview_intent 
				= new Intent(TwoContentsActivity.this, ImageViewActivity.class);
			startActivity(imageview_intent);
			break;
		case LIST_ACTIVITY:
			Intent list_activity_intent 
				= new Intent(TwoContentsActivity.this, MyListActivity.class);
			startActivity(list_activity_intent);
			break;
		case SIMPLE_ADAPTER:
			Intent simple_adapter_intent 
				= new Intent(TwoContentsActivity.this, SimpleAdapterTest.class);
			startActivity(simple_adapter_intent);
			break;
		case BASE_ADAPTER:
			Intent base_adapter_intent 
				= new Intent(TwoContentsActivity.this, BaseAdapterTest.class);
			startActivity(base_adapter_intent);
			break;
		case AUTO_COMPLETE_TEXT:
			Intent auto_complete_intent 
				= new Intent(TwoContentsActivity.this, AutoCompleteTextViewTest.class);
			startActivity(auto_complete_intent);
			break;
		case GRID_VIEW:
			Intent gridview_intent 
				= new Intent(TwoContentsActivity.this, GridViewTest.class);
			startActivity(gridview_intent);
			break;
		case SPINNER_ACTIVITY:
			Intent spinner_intent 
				= new Intent(TwoContentsActivity.this, SpinnerActivityTest.class);
			startActivity(spinner_intent);
			break;
		case EXPANDABLE_LIST_VIEW:
			Intent expandablelistview_intent
				= new Intent(TwoContentsActivity.this, ExpandableListViewActivity.class);
			startActivity(expandablelistview_intent);
			break;
		case GALLARY_ACTIVITY:
			Intent gallary_intent
				= new Intent(TwoContentsActivity.this, GallaryActivity.class);
			startActivity(gallary_intent);
			break;
		case ADAPTER_VIEW_FLIPPER:
			Intent adapter_view_flipper_intent
				= new Intent(TwoContentsActivity.this, AdapterViewFliperActivity.class);
			startActivity(adapter_view_flipper_intent);
			break;
		case STACK_VIEW:
			Intent stack_view_intent
				= new Intent(TwoContentsActivity.this, StackViewActivity.class);
			startActivity(stack_view_intent);
			break;
		case PROGRESS_BAR:
			Intent progress_bar_intent
				= new Intent(TwoContentsActivity.this, ProgressBarActivity.class);
			startActivity(progress_bar_intent);
			break;
		case TITLE_PROGRESS_BAR:
			Intent title_progress_bar_intent
				= new Intent(TwoContentsActivity.this, TitleProgressBar.class);
			startActivity(title_progress_bar_intent);
			break;
		case SEEK_BAR:
			Intent seek_bar_intent
				= new Intent(TwoContentsActivity.this, SeekBarActivity.class);
			startActivity(seek_bar_intent);
			break;
		case RATING_BAR:
			Intent rating_bar_intent
				= new Intent(TwoContentsActivity.this, RatingBarActivity.class);
			startActivity(rating_bar_intent);
			break;
		case VIEW_SWITCHER:
			Intent view_switch_intent
				= new Intent(TwoContentsActivity.this, ViewSwitcherActivity.class);
			startActivity(view_switch_intent);
			break;
		case IMAGE_SWITCHER:
			Intent image_switch_intent
				= new Intent(TwoContentsActivity.this, ImageSwitcherActivity.class);
			startActivity(image_switch_intent);
			break;
		case TEXT_SWITCHER:
			Intent text_switch_intent
				= new Intent(TwoContentsActivity.this, TextSwitchActivity.class);
			startActivity(text_switch_intent);
			break;
		case VIEW_FLIPPER:
			Intent view_flipper_intent
				= new Intent(TwoContentsActivity.this, ViewFlipperActivity.class);
			startActivity(view_flipper_intent);
			break;
		case TAB_HOST:
			Intent tab_host_intent
				= new Intent(TwoContentsActivity.this, TabHostActivity.class);
			startActivity(tab_host_intent);
			break;
		case DIALOG:
			Intent dialog_intent
				= new Intent(TwoContentsActivity.this, DialogActivity.class);
			startActivity(dialog_intent);
			break;
		case LIST_DIALOG:
			Intent list_dialog_intent
				= new Intent(TwoContentsActivity.this, ListDialogActivity.class);
			startActivity(list_dialog_intent);
			break;
		case SINGLE_CHOICE_DIALOG:
			Intent single_choice_dialog_intent
				= new Intent(TwoContentsActivity.this, SingChoiceDialogActivity.class);
			startActivity(single_choice_dialog_intent);
			break;
		case MULTI_CHOICE_DIALOG:
			Intent multi_choice_dialog_intent
				= new Intent(TwoContentsActivity.this, MultiChoiceDialog.class);
			startActivity(multi_choice_dialog_intent);
			break;
		default:
			Log.d(TAG, "default position="+position);
			break;
		}
		
	}

	@Override
	public void onPrepareContents() {
		String[] contents = getResources().getStringArray(R.array.chapterTwoContents);
		super.prepareContents(contents);
	}

}
