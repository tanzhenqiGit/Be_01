package com.example.contents.two.spinner;

import com.example.dandan.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivityTest extends Activity {

	private final String TAG = "SpinnerActivityTest";
	private Spinner mSpinner;
	
	
	private void initialize()
	{
		mSpinner = (Spinner)findViewById(R.id.two_spinner_activity_main_spinner);
		
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(SpinnerActivityTest.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				TextView textview = new TextView(SpinnerActivityTest.this);
				textview.setText("number"+ position +"th");
				textview.setTextSize(20);
				textview.setTextColor(Color.GREEN);

				ImageView image = new ImageView(SpinnerActivityTest.this);
				image.setImageResource(R.drawable.t);
				ll.addView(image);
				ll.addView(textview);
				return ll;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
			@Override
			public int getCount() {
				return 15;
			}
		};
		
		if (mSpinner != null) {
			mSpinner.setAdapter(adapter);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_spinner_activity_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
	
}
