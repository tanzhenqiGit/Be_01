/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-7
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-7 ÏÂÎç1:45:07
* @class WebServiceUtil.java
*/ 
package com.example.contents.thirteen.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

/**
 * @author free
 *
 */
public class WebServiceUtil {
	
	public static final String TAG = "WebServiceUtil ";
	public static final String  SERVICE_NS = "http://WebXml.com.cn/";
	public static final String SERVICE_URL = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx";

	
	private static List<String> parseProvinceOrCity(SoapObject detail)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < detail.getPropertyCount(); i++) {
			result.add(detail.getProperty(i).toString().split(",")[0]);
		}
		
		return result;
	}
	
	public static List<String> getProvinceList()
	{
		Log.d(TAG, "getProvinceList.");
		String methodName = "getRegionProvince";
		HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
		ht.debug = true;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;
		
		try {
			ht.call(SERVICE_NS + methodName, envelope);
			if (envelope.getResponse() != null) {
				SoapObject result = (SoapObject) envelope.bodyIn;
				SoapObject detail = (SoapObject) result.getProperty(methodName + "Result");
				
				return parseProvinceOrCity(detail);
			}
		} catch (HttpResponseException e) {
			Log.d(TAG, "getProvinceList::HttpResponseException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "getProvinceList::IOException");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			Log.d(TAG, "getProvinceList::XmlPullParserException");
			e.printStackTrace();
		}
		
		
		return null;
		
		
	}

	public static List<String> getCityListByProvince(String province)
	{
		Log.d(TAG, "getCityListByProvince province="+province);
		String methodName = "getSupportCityString";
		HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
		ht.debug = true;
		
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("theRegionCode", province);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;
		
		try {
			ht.call(SERVICE_NS + methodName, envelope);
			if (envelope.getResponse() != null) {
				SoapObject result = (SoapObject) envelope.bodyIn;
				SoapObject detail = (SoapObject) result.getProperty(methodName + "Result");
				return parseProvinceOrCity(detail);
			}
		} catch (HttpResponseException e) {
			Log.d(TAG, "getCityListByProvince::HttpResponseException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "getCityListByProvince::IOException");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			Log.d(TAG, "getCityListByProvince::XmlPullParserException");
			e.printStackTrace();
		}
		return null;
	}

	public static SoapObject getWeatherByCity(String cityName)
	{
		Log.d(TAG, "getWeatherByCity cityName=" + cityName);
		String methodName = "getWeather";
		HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
		
		ht.debug = true;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		SoapObject soapObject = new SoapObject(SERVICE_NS,methodName);
		soapObject.addProperty("theCityCode",cityName);
		envelope.bodyOut = soapObject;
		
		try {
			ht.call(SERVICE_NS + methodName, envelope);
			SoapObject result = (SoapObject) envelope.bodyIn;
			SoapObject detail = (SoapObject) result.getProperty(methodName + "Result");
			return detail;
		} catch (HttpResponseException e) {
			Log.d(TAG, "getWeatherByCity::HttpResponseException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "getWeatherByCity::printStackTrace");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			Log.d(TAG, "getWeatherByCity::XmlPullParserException");
			e.printStackTrace();
		}
		
		return null;
	}
}
