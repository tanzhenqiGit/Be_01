/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-12
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-12 下午2:25:11
* @class DateDialogActivity.java
*/ 
package com.example.contents.two.specialview;

import java.util.Calendar;

import com.example.dandan.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * @author free
 *
 */
public class DateDialogActivity extends Activity {

	private final String TAG = "DateDialogActivity";
	private Button mDatePickBtn, mTimePickBtn;
	private EditText mShowText;
	
	
	private void setTimePickCallBack()
	{
		Calendar c = Calendar.getInstance();
		new TimePickerDialog(DateDialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				Log.d(TAG, "onTimeSet in called");
				if (mShowText != null) {
					mShowText.setText("你选择了：" + hourOfDay + "时" + hourOfDay + "分");
				}
				
			}
		}, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
	}
	
	private void setDatePickCallBack()
	{
		Calendar c = Calendar.getInstance();
		new DatePickerDialog(DateDialogActivity.this, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				if (mShowText != null) {
					mShowText.setText("你选择了：" + year + "年" + monthOfYear + "月" + dayOfMonth + "日");
				}
				
			}
		}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
	}
	private void initialize()
	{
		mShowText = (EditText)findViewById(R.id.two_special_datedialog_main_text);
		mDatePickBtn = (Button)findViewById(R.id.two_special_datedialog_main_date_btn);
		mTimePickBtn = (Button)findViewById(R.id.two_special_datedialog_main_time_btn);
		
		if (mDatePickBtn != null) {
			mDatePickBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setDatePickCallBack();
					
				}
			});
		}
		
		mTimePickBtn = (Button)findViewById(R.id.two_special_datedialog_main_time_btn);
		if (mTimePickBtn != null) {
			mTimePickBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setTimePickCallBack();
					
				}
			});
		} else {
			Log.d(TAG, "mTimePickBtn == null");
		}
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_special_datedialog_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

}
