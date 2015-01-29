/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-29
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-29 ÏÂÎç2:05:19
* @class FileTest.java
*/ 
package com.example.contents.eight.file;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.dandan.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * @author free
 *
 */
public class FileActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_view_main_2);
		initialize();
	}
	
	private void initialize()
	{
		mReadBtn = (Button) findViewById(R.id.common_view_main_2_read_btn);
		if (mReadBtn != null) {
			mReadBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String content = read();
					if (mReadTxt != null) {
						mReadTxt.setText(content);
					}
					
				}
			});
		}
		mWriteBtn = (Button) findViewById(R.id.common_view_main_2_write_btn);
		if (mWriteBtn != null) {
			mWriteBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mWriteTxt != null) {
						write(mWriteTxt.getText().toString());
					}
					
				}
			});
		}
		
		
		mReadTxt = (EditText) findViewById(R.id.common_view_main_2_read_txt);
		mWriteTxt = (EditText) findViewById(R.id.common_view_main_2_write_txt);
		
	}
	
	private String read()
	{
		StringBuilder sb = new StringBuilder();
		byte[] bytes = new byte [10];
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			int readNum = 0;
			try {
				while ((readNum = fis.read(bytes)) > 0) {
					sb.append(new String(bytes, 0, readNum));
					Log.d(TAG, sb.toString());
				}
				return sb.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void write(String value)
	{
		if (value == null) {
			Log.d(TAG, "write function , but value is null do nothing.");
			return;
		}
		try {
			FileOutputStream pos = openFileOutput(FILE_NAME, MODE_PRIVATE);
			try {
				pos.write(value.getBytes());
				Log.d(TAG, "write succeed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * @param fILE_NAME2
	 * @return
	 */
	private Object File(String fILE_NAME2) {
		// TODO Auto-generated method stub
		return null;
	}
	private final String TAG = "FileActivity";
	private final String FILE_NAME = "com.example.dandan.file.text.txt";
	private Button mReadBtn, mWriteBtn;
	private EditText mReadTxt, mWriteTxt;

}
