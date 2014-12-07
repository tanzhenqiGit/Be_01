package com.example.contents.four.otheractivity;

import java.util.List;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class ArmsPreferenceActivity extends PreferenceActivity{

	final static String TAG = "ArmsPreferenceActivity";
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void initialize()
	{
		if (hasHeaders()) {
			Button button = new Button(this);
			button.setText("setting operation");
			setListFooter(button);
		}
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onBuildHeaders(List<Header> target) {
		Log.d(TAG, "onBuildHeaders");
		//super.onBuildHeaders(target);
		loadHeadersFromResource(R.xml.four_other_activity_preference_headers, target);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	
	@SuppressLint("NewApi")
	public static class PrefsFragment1 extends PreferenceFragment
	{

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			Log.d(TAG, "PrefsFragment1 onCreate");
			addPreferencesFromResource(R.xml.four_other_activity_preferences);
		}

		@Override
		public void onDestroy() {
			Log.d(TAG, "PrefsFragment1 onDestroy");
			super.onDestroy();
		}
		
	}
	
	@SuppressLint("NewApi")
	public static class PrefsFragment2 extends PreferenceFragment
	{

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.d(TAG, "PrefsFragment2 onCreate");
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.ten_other_activity_display_prefs);
			String websit = getArguments().getString("website");
			Toast.makeText(getActivity(), "website is :"+websit, Toast.LENGTH_LONG).show();
			Log.d(TAG,  "website is :"+websit);
		}

		@Override
		public void onDestroy() {
			Log.d(TAG, "PrefsFragment2 onDestroy");
			super.onDestroy();
		}
		
	}

}
