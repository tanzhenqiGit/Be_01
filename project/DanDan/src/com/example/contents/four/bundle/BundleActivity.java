package com.example.contents.four.bundle;

import com.example.dandan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BundleActivity extends Activity 
{
	private final String TAG = "BundleActivity";
	private Button mRegisterBtn;
	private EditText mName, mPasswd;
	private RadioButton mMaleRadio;
	private String mGender;
	private void initialize()
	{
		mName = (EditText)findViewById(R.id.four_bundle_activity_main_username_text);
		mPasswd = (EditText)findViewById(R.id.four_bundle_activity_main_userpasswd_text);
		mMaleRadio = (RadioButton)findViewById(R.id.four_bundle_activity_main_male_radiobutton);
		mGender = mMaleRadio.isChecked() ? "male" : "female";

		mRegisterBtn = (Button)findViewById(R.id.four_bundle_activity_main_registe_btn);
		if (mRegisterBtn != null) {
			mRegisterBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "register button is called");
					PersonInfo personinfo = new PersonInfo(mName.getText().toString(),
							mPasswd.getText().toString(), mGender);
					Bundle data = new Bundle();
					data.putSerializable("personinfo", personinfo);
					Intent intent = new Intent(BundleActivity.this, BundleResultActivity.class);
					intent.putExtras(data);
					startActivity(intent);
				}
			});
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four_bundle_activity_main);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
