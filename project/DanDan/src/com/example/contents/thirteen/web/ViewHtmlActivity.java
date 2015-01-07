/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-7
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-7 ÉÏÎç11:41:11
* @class ViewHtmlActivity.java
*/ 
package com.example.contents.thirteen.web;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * @author free
 *
 */
public class ViewHtmlActivity extends Activity {

	public final String TAG = "ViewHtmlActivity";
	private EditText mURLTxt;
	private WebView mWebShow;
	
	
	private void initialize()
	{
		mURLTxt = (EditText) findViewById(R.id.thirteen_minibrowser_main_txt);
		if (mURLTxt != null) {
			mURLTxt.setVisibility(View.INVISIBLE);
		}
		
		mWebShow = (WebView) findViewById(R.id.thirteen_minibrowser_main_show);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> »¶Ó­Äú </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h2> »¶Ó­Äú·ÃÎÊ <a href=\"http://www.baidu.com\"> °Ù¶È </a> </h2>");
		sb.append("</body>");
		sb.append("</html>");
		/* case 1 */
		if (mWebShow != null) {
			//mWebShow.loadData(sb.toString(), "text/html", "utf-8");
			
			mWebShow.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen_minibrowser_main);
		initialize();
	}

	
}
