/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-12-28 ����7:25:22.
*/ 
package com.example.contents.thirteen.postutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


import android.util.Log;

/**
 * @author Administrator
 *
 */
public class GetPostUtil {

	public static final String TAG = "GetPostUtil";
	public static String sendGet(String url, String params)
	{
		System.out.print("url:" + url + "params:" + params);
		String result = "";
		BufferedReader in = null;
		
		

		try {
			String urlName = url + "?" + params;
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.connect();
			
			Map<String, List<String>> map = conn.getHeaderFields();
			
			for (String key : map.keySet())
			{
				System.out.println(key + "--->" + map.get(key));
				
			}
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		
		} catch (Exception e) {
			Log.d(TAG, "GetPostUtil get Exception");
			e.printStackTrace();
		} finally {
			
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return result;
	}

	public static String sendPost(String url, String params) 
	{
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		
		URL realUrl;
		try {
			realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());
			out.print(params);
			out.flush();
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		
		
		} catch (Exception e) {
			System.out.println("send MSG exception");
			e.printStackTrace();
		} finally {
			
			try {
				if (out != null) {
					out.close();
				}
				
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return result;
	}
}
