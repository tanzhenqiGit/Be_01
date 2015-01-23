/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 上午11:51:18
* @class XmlExplainActivity.java
*/ 
package com.example.contents.six.xml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import com.example.dandan.R;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author free
 *
 */
public class XmlExplainActivity extends Activity {

	private final String TAG = "XmlExplainActivity";
	
	private Button mExplainBtn;
	private TextView mShowTxt;
	
	
	
	private void explainXml()
	{
		XmlResourceParser xrp = getResources().getXml(R.xml.mybooks);
		if (xrp == null) {
			Log.d(TAG, "explainXml get XmlResourceParser is null ,just return.");
			return;
		}
		StringBuilder sb = new StringBuilder("");
		try {
			while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
				if (xrp.getEventType() == XmlResourceParser.START_TAG) {
					String tagName = xrp.getName();
					Log.d(TAG, "tagName is " + tagName);
					if (tagName.equals("book")) {
						String bookPrice = xrp.getAttributeValue(null, "price");
						sb.append("价格：");
						sb.append(bookPrice);
						String bookData = xrp.getAttributeValue(1);
						sb.append("出版日期：");
						sb.append(bookData);
						sb.append("书名：");
						sb.append(xrp.nextText());
					}
					sb.append("\n");
				}
				xrp.next();
			}
			
			if (mShowTxt != null) {
				mShowTxt.setText(sb.toString());
			}
		} catch (XmlPullParserException e) {
			Log.d(TAG, "receiver exception XmlPullParserException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d(TAG, "receiver exception IOException");
			e.printStackTrace();
		}
	}
	private void initialize()
	{
		mShowTxt = (TextView) findViewById(R.id.six_xml_explain_main_txt);
		mExplainBtn = (Button) findViewById(R.id.six_xml_explain_main_btn);
		if (mExplainBtn != null) {
			
			mExplainBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mShowTxt != null) {
						mShowTxt.setText("");
						explainXml();
					}
					
				}
			});
		}
		
		
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.six_xml_explain_main);
		initialize();
	}

}
