/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-9
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-9 ÏÂÎç5:08:40
* @class WeatherActivity.java
*/ 
package com.example.contents.thirteen.weather;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class WeatherActivity extends Activity {

	private final String TAG = "WebServiceUtil";
    private Spinner mProvinceSpr, mCitySpr;
    private ImageView mTodayIcon1, mTodayIcon2, mTomorrowIcon1, mTomorrowIcon2, mAfterdayICon1, mAfterdayICon2;
    private TextView mTodayShow, mTomorrowShow, mAfterdayShow, mCurrentShow;
    
    private List<String> mProvinces , mCitys;
    
    
    private void HandlerOnCreate()
    {
    	Log.d(TAG, "HandlerOnCreate");
		setContentView(R.layout.thirteen_web_service_main);
		initialize();
		setProvincesSpinner();
    }
    
    private void showWeather(String City)
    {
    	String todayWeather = null;
    	String tommorrowWeather = null;
    	String afterDayWeather = null;
    	String currentWeather = null;
    	
    	int todayIcon[] = new int[2];
    	int tomorrowIcon[] = new int [2];
    	int afterdayIcon[] = new int [2];
    	
    	SoapObject detail = WebServiceUtil.getWeatherByCity(City);
    	
    	currentWeather = detail.getProperty(4).toString();
    	Log.d(TAG, "showWeather::currentWeather=" + currentWeather);
    	
    }
    
    private void setCitysSpiner()
    {
    	Log.d(TAG, "setCitysSpiner --start--");
    	if (mCitys == null)
    	{
    		Log.d(TAG, "setCitysSpiner mCitys == null ");
    		return;
    	}
    	
    	ArrayAdapter<String> adapter 
		   = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item ,mCitys);
    	if ((adapter != null) && (mCitySpr != null)) {
    		mCitySpr.setAdapter(adapter);
    		mCitySpr.setOnItemSelectedListener(new OnItemSelectedListener()
    		{

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					String city = mCitySpr.getSelectedItem().toString();
					Log.d(TAG, "onItemSelected city" + city);
					showWeather(city);
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
    			
    		});
    	}
    	
    }
    
    private void setProvincesSpinner()
    {
    	Log.d(TAG, "setProvincesSpinner --start--");
    	mProvinces = WebServiceUtil.getProvinceList();
    	if (mProvinces == null) {
    		Log.d(TAG, "setProvincesSpinner mProvinces == null");
    		return;
    	}
    	
    	ArrayAdapter<String> adapter 
    		= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item ,mProvinces);
    	
    	if ((adapter != null) && (mProvinceSpr != null)) {
    		mProvinceSpr.setAdapter(adapter);
    		mProvinceSpr.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					String province = mProvinceSpr.getSelectedItem().toString();
					Log.d(TAG, "setOnItemSelectedListener:province = " + province);
					mCitys = WebServiceUtil.getCityListByProvince(province);
					setCitysSpiner();
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
    			
			});
    	}
    	
    	
    	
    }
    
    private void initialize()
    {
    	Log.d(TAG, "initialize --start--");
    	mProvinceSpr = (Spinner) findViewById(R.id.thirteen_web_service_main_province_spinner);
    	mCitySpr = (Spinner) findViewById(R.id.thirteen_web_service_main_city_spinner);
    	
    	mTodayIcon1 = (ImageView) findViewById(R.id.thirteen_web_service_main_today_icon_1);
    	mTodayIcon2 = (ImageView) findViewById(R.id.thirteen_web_service_main_today_icon_2);
    	mTodayShow = (TextView) findViewById(R.id.thirteen_web_service_main_today_show_txt);
    	
    	mTomorrowIcon1 = (ImageView) findViewById(R.id.thirteen_web_service_main_tommorrow_icon_1);
    	mTomorrowIcon2 = (ImageView) findViewById(R.id.thirteen_web_service_main_tommorrow_icon_2);
    	mTomorrowShow = (TextView) findViewById(R.id.thirteen_web_service_main_tommorrow_show_txt);
    	
    	
    	mAfterdayICon1 = (ImageView) findViewById(R.id.thirteen_web_service_main_afterday_icon_1);
    	mAfterdayICon2 = (ImageView) findViewById(R.id.thirteen_web_service_main_afterday_icon_2);
    	mAfterdayShow = (TextView) findViewById(R.id.thirteen_web_service_main_afterday_show_txt);
    	
    	mCurrentShow = (TextView) findViewById(R.id.thirteen_web_service_main_current_txt);
    }
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HandlerOnCreate();
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
