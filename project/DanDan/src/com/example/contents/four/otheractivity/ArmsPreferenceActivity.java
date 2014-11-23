package com.example.contents.four.otheractivity;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.Button;

public class ArmsPreferenceActivity extends PreferenceActivity{

	private final String TAG = "ArmsPreferenceActivity";
	@SuppressLint("NewApi")
	private void initialize()
	{
		if (hasHeaders()) {
			Button button = new Button(this);
			button.setText("setting");
			setListFooter(button);
		}
	}
	@SuppressLint("NewApi")
	@Override
	public void onBuildHeaders(List<Header> target) {
		Log.d(TAG, "onBuildHeaders");
		super.onBuildHeaders(target);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
