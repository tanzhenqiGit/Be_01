/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-9
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-9 下午5:08:40
* @class WeatherActivity.java
*/ 
package com.example.contents.thirteen.weather;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class WeatherActivity extends Activity {

	private final String TAG = "WebServiceUtil";
	private final int MSG_TYPE_GET_PROVICES = 0x01;
	private final int MSG_TYPE_GET_CITYS = 0x02;
	private final int MSG_TYPE_GET_WEATHER = 0x03;
    private Spinner mProvinceSpr, mCitySpr;
    private ImageView mTodayIcon1, mTodayIcon2, mTomorrowIcon1, mTomorrowIcon2, mAfterdayICon1, mAfterdayICon2;
    private TextView mTodayShow, mTomorrowShow, mAfterdayShow, mCurrentShow;
    
    private List<String> mProvinces , mCitys;
    private String mSelectProvince,mSelectCity;
    private SoapObject mWeather = null;
    
    private Handler mHandler = new Handler()
    {

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			Log.d(TAG, "Receiver msg id = " + msg.what);
			switch(msg.what) {
			case MSG_TYPE_GET_PROVICES:
				setProvincesSpinner();
				break;
			case MSG_TYPE_GET_CITYS:
				setCitysSpiner();
				break;
			case MSG_TYPE_GET_WEATHER:
				showWeather();
				break;
			default:
				
				break;
			}
		}
    	
    };
    
    private void HandlerOnCreate()
    {
    	Log.d(TAG, "HandlerOnCreate");
    	getProvincesList();
    }
    
    private int parseIcon(String strIcon)
    {
    	Log.d(TAG, "parseIncon strIcon=" + strIcon);
    	return 0;
    }
    
    private void showWeather()
    {
    	String todayWeather = null;
    	String tomorrowWeather = null;
    	String afterDayWeather = null;
    	String currentWeather = null;
    	
    	int todayIcon[] = new int[2];
    	int tomorrowIcon[] = new int [2];
    	int afterdayIcon[] = new int [2];
    	
    	if (mWeather == null) {
    		Log.d(TAG, "showWeather mWeather == null");
    		return;
    	}
    	SoapObject detail = mWeather;
    	currentWeather = detail.getProperty(4).toString();
    	Log.d(TAG, "showWeather::currentWeather=" + currentWeather);
    	
    	String date = detail.getProperty(7).toString();
    	todayWeather = "今天" + date.split(" ")[0];
    	todayWeather = todayWeather + "\n 天气：" + date.split(" ")[1];
    	todayWeather = todayWeather + "\n 气温：" + detail.getProperty(8).toString();
    	todayWeather = todayWeather + "\n 风力：" + detail.getProperty(9).toString() + "\n";
    	
    	todayIcon[0] = parseIcon(detail.getProperty(10).toString());
    	todayIcon[1] = parseIcon(detail.getProperty(11).toString());
    	
    	date = detail.getProperty(12).toString();
    	tomorrowWeather = "明天：" + date.split(" ")[0];
    	tomorrowWeather = tomorrowWeather + "\n 天气：" + date.split(" ")[1];
    	tomorrowWeather = tomorrowWeather + "\n 气温：" + detail.getProperty(13).toString();
    	tomorrowWeather = tomorrowWeather + "\n 风力：" + detail.getProperty(14).toString() + "\n";
    	
    	tomorrowIcon[0] = parseIcon(detail.getProperty(15).toString());
    	tomorrowIcon[1] = parseIcon(detail.getProperty(16).toString());
    	
    	
    	date = detail.getProperty(17).toString();
    	afterDayWeather = "后天：" + date.split(" ")[0];
    	afterDayWeather = afterDayWeather + "\n 天气：" + date.split(" ")[1];
    	afterDayWeather = afterDayWeather + "\n 气温：" + detail.getProperty(18).toString();
    	afterDayWeather = afterDayWeather + "\n 风力：" + detail.getProperty(19).toString() + "\n";
    
    	afterdayIcon[0] = parseIcon(detail.getProperty(20).toString());
    	afterdayIcon[1] = parseIcon(detail.getProperty(21).toString());
    	
    	
    	if (mCurrentShow != null) {
    		mCurrentShow.setText(currentWeather);
    	}
    	
    	if (mTodayShow != null) {
    		mTodayShow.setText(todayWeather);
    	}
    	
    	if (mTomorrowShow != null) {
    		mTomorrowShow.setText(tomorrowWeather);
    	}
    	
    	if (mAfterdayShow != null) {
    		mAfterdayShow.setText(afterDayWeather);
    	}
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
					getWeatherByCity(city);
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
					getCitysList(province);
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					
				}
    			
			});
			
    	}
    }
    
    private void printList(List<String> list)
    {
    	Log.d(TAG, "list size = " + mProvinces.size());
    	//for debug ....
    	for (int index = 0; index < list.size(); index ++)
    	{
    		Log.d(TAG, index + ":" + list.get(index));
    	}
    	//end for debug ...
    }
    
    private void getWeatherByCity(String City)
    {
    	Log.d(TAG, "getWeatherByCity(" + City + ") --start--");
    	mSelectCity = City;
    	new Thread()
    	{
			@Override
			public void run() {
				SoapObject detail = WebServiceUtil.getWeatherByCity(mSelectCity);
				if (detail != null && mHandler != null) {
					mWeather = detail;
					mHandler.sendEmptyMessage(MSG_TYPE_GET_WEATHER);
				}
			}
    		
    	}.start();
    }
    
    private void getCitysList(String province)
    {
    	Log.d(TAG, "getCitysList(" + province + ") --start--");
    	mSelectProvince = province;
    	new Thread()
    	{
			@Override
			public void run() {
				Log.d(TAG, "getCityList run()");
				mCitys = WebServiceUtil.getCityListByProvince(mSelectProvince);
				printList(mCitys);
				if (mCitys.size() > 0 && mHandler != null) {
					mHandler.sendEmptyMessage(MSG_TYPE_GET_CITYS);
				}
			}
    		
    	}.start();
        
    }
    
    
    
    private void getProvincesList()
    {
    	Log.d(TAG, "setProvincesSpinner --start--");
		new Thread()
		{
			@Override
			public void run() {
				Log.d(TAG, "getProvincesList run()");
		    	mProvinces = WebServiceUtil.getProvinceList();
		    	printList(mProvinces);
		    	if (mProvinces.size() > 0 && mHandler != null) {
		    		mHandler.sendEmptyMessage(MSG_TYPE_GET_PROVICES);
		    	}
			}
			
		}.start();
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
		setContentView(R.layout.thirteen_web_service_main);
		initialize();
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
