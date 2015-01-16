package com.example.contents;

import com.example.contents.eleven.ElevenContentsActivity;
import com.example.contents.fifteen.FifteenContentsActivity;
import com.example.contents.five.FiveContentsActivity;
import com.example.contents.four.FourContentsActivity;
import com.example.contents.fourteen.FourteenContentActivity;
import com.example.contents.nine.NineContentsActivity;
import com.example.contents.ten.TenContentsActivity;
import com.example.contents.thirteen.ThirteenContentsActivity;
import com.example.contents.three.ThreeContentsActivity;
import com.example.contents.two.TwoContentsActivity;
import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentsActivity extends Activity {
	private ListView mList;
	private String TAG = "MainInterface";
	private final int CHAPTER_ONE = -1;
	private final int CHAPTER_TWO = 0;
	private final int CHAPTER_THREE = 1;
	private final int CHAPTER_FOUR = 2;
	private final int CHAPTER_FIVE = 3;
	private final int CHAPTER_SIX = 4;
	private final int CHAPTER_SEVEN = 5;
	private final int CHAPTER_EIGHT = 6;
	private final int CHAPTER_NINE = 7;
	private final int CHAPTER_TEN = 8;
	private final int CHAPTER_ELEVEN = 9;
	private final int CHAPTER_TWELVE = 10;
	private final int CHAPTER_THRITEEN = 11;
	private final int CHAPTER_FOURTEEN = 12;
	private final int CHAPTER_FIFTEEN = 13;
	private final int CHAPTER_SIXTEEN = 14;
	private final int CHAPTER_SEVENTEEN = 15;
	private final int CHAPTER_EIGHTEEN = 16;
	private final int CHAPTER_NINETEEN = 17;
	
	private void initializeConpoment()
	{
		mList = (ListView)findViewById(R.id.listView);
		if (mList == null) {
			Log.d(TAG,"initializeConpoment can't find ListView");
			return;
		}
		String[] Contents = getResources().getStringArray(R.array.Contents);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,
				Contents);
		mList.setAdapter(adapter);
	}
	
	private void setListViewOnClickListener()
	{
		if(mList != null) {
			mList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View source,
						int position, long id) {
					Log.d(TAG, "onItemClick position:" + position + "id:" + id);
					switch(position) {
					case CHAPTER_ONE:
						break;
					case CHAPTER_TWO:
						Intent two_chapter_intent =
						new Intent(ContentsActivity.this, TwoContentsActivity.class);
					startActivity(two_chapter_intent);
						break;
					case CHAPTER_THREE:
						Intent three_chapter_intent =
							new Intent(ContentsActivity.this, ThreeContentsActivity.class);
						startActivity(three_chapter_intent);
						break;
					case CHAPTER_FOUR:
						Intent four_chapter_intent = 
							new Intent(ContentsActivity.this, FourContentsActivity.class);
						startActivity(four_chapter_intent);
						break;
					case CHAPTER_FIVE:
						Intent five_chapter_intent = 
							new Intent(ContentsActivity.this, FiveContentsActivity.class);
						startActivity(five_chapter_intent);
						break;
					case CHAPTER_SIX:
						break;
					case CHAPTER_SEVEN:
						break;
					case CHAPTER_EIGHT:
					
						break;
					case CHAPTER_NINE:
						Log.d(TAG, "goto nine chapter contents");
						Intent intent = new Intent(ContentsActivity.this, NineContentsActivity.class);
						startActivity(intent);
						break;
					case CHAPTER_TEN:	
						Intent intentTen = new Intent(ContentsActivity.this, TenContentsActivity.class);
						startActivity(intentTen);
						break;
					case CHAPTER_ELEVEN:
						Intent eleven_intent 
						= new Intent(ContentsActivity.this, ElevenContentsActivity.class);
						startActivity(eleven_intent);
						break;
					case CHAPTER_TWELVE:
						break;
					case CHAPTER_THRITEEN:
						Intent thirteen_intent 
							= new Intent(ContentsActivity.this, ThirteenContentsActivity.class);
						startActivity(thirteen_intent);
						break;
					case CHAPTER_FOURTEEN:
						Intent fourteen_intent 
							= new Intent(ContentsActivity.this, FourteenContentActivity.class);
						startActivity(fourteen_intent);
						break;
					case CHAPTER_FIFTEEN:
						Intent fifteen_intent 
							= new Intent(ContentsActivity.this, FifteenContentsActivity.class);
						startActivity(fifteen_intent);
						break;
					case CHAPTER_SIXTEEN:
						
						break;
					case CHAPTER_SEVENTEEN:
						
						break;
					case CHAPTER_EIGHTEEN:
						
						break;
					case CHAPTER_NINETEEN:
						
						break;
				    default:
				    	break;
					}
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents_activity);
		initializeConpoment();
		setListViewOnClickListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_interface, menu);
		return true;
	}
}
