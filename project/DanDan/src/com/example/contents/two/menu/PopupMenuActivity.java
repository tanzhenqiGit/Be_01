/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-14 下午8:45:42.
*/ 
package com.example.contents.two.menu;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

/**
 * @author Administrator
 *
 */
public class PopupMenuActivity extends Activity {

	private final String TAG = "PopupMenuActivity";
	private Button mShowBtn;
	private EditText mShowTxt;
	private PopupMenu mPopMenu;
	
	@SuppressLint("NewApi")
	private void initialize()
	{
		mShowBtn = (Button)findViewById(R.id.two_special_dialog_main_btn);
		if (mShowBtn != null) {
			mShowBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View view) {
					Log.d(TAG, "mShowBtn is onClicked");
					mPopMenu = new PopupMenu(PopupMenuActivity.this, view);
					getMenuInflater().inflate(R.menu.popup_menu_main,
							mPopMenu.getMenu());
					mPopMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
						
						@Override
						public boolean onMenuItemClick(MenuItem item) {
							switch(item.getItemId()) {
							case R.id.popup_menu_main_add:
							case R.id.popup_menu_main_edit:
							case R.id.popup_menu_main_search:
								Toast.makeText(PopupMenuActivity.this,
										"你选中了【"+item.getTitle() +"】菜单项",
										Toast.LENGTH_LONG).show();
								break;
							case R.id.popup_menu_main_exit:
								mPopMenu.dismiss();
								break;
							default:
								
								break;
							}
							return false;
						}
					});
					mPopMenu.show();
				}
			});
		}
		mShowTxt = (EditText)findViewById(R.id.two_special_dialog_main_text);
		if (mShowTxt != null) {
			mShowTxt.setVisibility(View.INVISIBLE);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_dialog_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	
	
}
