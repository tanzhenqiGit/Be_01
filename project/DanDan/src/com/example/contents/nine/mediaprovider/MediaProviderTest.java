package com.example.contents.nine.mediaprovider;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MediaProviderTest extends Activity {


	private String TAG = "MediaProviderTest";
	private Button mAddButton = null;
	private Button mQueryButton = null;
	private ListView mListView = null;
	private ArrayList<String> mNames;
	private ArrayList<String> mDescs;
	private ArrayList<String> mFileNames;
	private void AddSetOnClickListener()
	{
		if (mAddButton != null) {
			mAddButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ContentValues values = new ContentValues();
					values.put(Media.DISPLAY_NAME, "icon_dan");
					values.put(Media.DESCRIPTION, "½ðËþ");
					values.put(Media.MIME_TYPE, "image/jpeg");
					Uri uri = getContentResolver().insert(
						Media.EXTERNAL_CONTENT_URI,values
					);
					
					Bitmap bitmap = BitmapFactory.decodeResource(MediaProviderTest.this.getResources(), R.drawable.android);
					OutputStream os = null;
				
					try {
						os = getContentResolver().openOutputStream(uri);
						bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	private void QuerySetOnClickListener()
	{
		if (mQueryButton != null) {
			mQueryButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					mNames.clear();
					mDescs.clear();
					mFileNames.clear();
					Cursor cursor = getContentResolver()
							.query(Media.EXTERNAL_CONTENT_URI, null, null, null, null);
					while(cursor.moveToNext()) {
						String name = cursor.getString(cursor.getColumnIndex(Media.DISPLAY_NAME));
						String desc = cursor.getString(cursor.getColumnIndex(Media.DESCRIPTION));
						byte[] data = cursor.getBlob(cursor.getColumnIndex(Media.DATA));
						mNames.add(name);
						mDescs.add(desc);
						mFileNames.add(new String(data, 0, data.length - 1));
					}
					List<Map<String , Object>> listItems =
							new ArrayList<Map<String, Object>>();
					for (int i=0; i<mNames.size(); i++) {
						Map<String, Object> listItem =
								new HashMap<String, Object>();
						listItem.put("name", mNames.get(i));
						listItem.put("desc", mDescs.get(i));
						listItems.add(listItem);
					}
						
					SimpleAdapter simpleAdapter = new SimpleAdapter(
							MediaProviderTest.this, 
							listItems,
							R.layout.nine_media_provider_list_line, 
							new String[] {"name","desc"},
							new int [] {R.id.nine_media_provider_name_text,
									R.id.nine_media_provider_desc_text}
							);
						mListView.setAdapter(simpleAdapter);
					}
				
			});
		}
	}
	private void ListViewSetOnItemOnClickListener()
	{
		if (mListView != null) {
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View source,
						int position, long id) {
					View viewDialog = getLayoutInflater()
							.inflate(R.layout.nine_media_provider_view, null);
					ImageView image = (ImageView) viewDialog.findViewById(
							R.id.nine_media_provider_view_imageview);
					image.setImageBitmap(BitmapFactory.decodeFile(mFileNames.get(position)));
					Log.d(TAG,"file:" + mFileNames.get(position));
					new AlertDialog.Builder(MediaProviderTest.this)
						.setView(viewDialog)
						.setPositiveButton("È·¶¨", null)
						.show();					
					
				}
			});
		}
	}
	private void initializeComponent()
	{
		mAddButton = (Button)findViewById(R.id.nine_media_provider_main_add_btn);
		mQueryButton = (Button)findViewById(R.id.nine_media_provider_main_query_btn);
		mListView = (ListView) findViewById(R.id.nine_media_provider_main_list);
		mNames = new ArrayList<String>();
		mDescs = new ArrayList<String>();
		mFileNames = new ArrayList<String>();
		QuerySetOnClickListener();
		AddSetOnClickListener();
		ListViewSetOnItemOnClickListener();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nine_media_provider_main);
		Log.d(TAG, "oncreste");
		initializeComponent();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
