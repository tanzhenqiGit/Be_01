/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-29
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-29 ÏÂÎç3:03:22
* @class SDCardActivity.java
*/ 
package com.example.contents.eight.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class SDCardActivity extends Activity {

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
		Log.d(TAG, "initialize");
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
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			File file = Environment.getExternalStorageDirectory();
			StringBuilder sb = new StringBuilder();
			byte [] bytes = new byte [10];
			try {
				FileInputStream fis = new FileInputStream(file.getCanonicalPath() + FILE_NAME);
				int readNum = 0;
				try {
					while ((readNum = fis.read(bytes)) > 0) {
						sb.append(new String(bytes, 0, readNum));
						Log.d(TAG, sb.toString());
					}
					fis.close();
					return sb.toString();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
		}
		return null;
	}
	
	private void write(String value)
	{
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			Log.d(TAG, "SDCard is existed");
			File storageDiratory = Environment.getExternalStorageDirectory();

			try {	
				String path = storageDiratory.getCanonicalPath() + FILE_NAME;
				Log.d(TAG, path);
				//File target = new File(path);
				//RandomAccessFile fos = new RandomAccessFile(target, "rw");
				FileOutputStream fos = new FileOutputStream(path);			
				try {
					fos.write(value.getBytes());
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			
			Log.e(TAG, "SDCard is not existed");
		}
	}
	
	private final String TAG = "SDCardActivity";
	public final String FILE_NAME = "/SDCardTest.bin";
	
	private Button mReadBtn, mWriteBtn;
	private EditText mReadTxt, mWriteTxt;

}
