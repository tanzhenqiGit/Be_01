/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-2-2
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-2-2 下午3:01:28
* @class RecogniseGesture.java
*/ 
package com.example.contents.eight.gesture;

import java.util.ArrayList;

import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * @author free
 *
 */
public class RecogniseGesture extends Activity{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		setContentView(R.layout.eight_add_gesture_main);
		initialize();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	private void initialize()
	{
		mGestureLibrary = GestureLibraries.fromFile("GESTURE_PATH");
		if (mGestureLibrary.load()) {
			Toast.makeText(RecogniseGesture.this, "手势文件装载成功！", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(RecogniseGesture.this, "手势文件装载失败！", Toast.LENGTH_LONG).show();
		}
		
		mGestureOverlayView = (GestureOverlayView) findViewById(R.id.eight_add_gesture_view);
		mGestureOverlayView.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			
			@Override
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				Log.d(TAG, "onGesturePerformed");
				ArrayList<Prediction> predictions = mGestureLibrary.recognize(gesture);
				ArrayList<String> result = new ArrayList<String>();
				
				for (Prediction pred : predictions) {
					if (pred.score > 2.0) {
						result.add("与手势[" + pred.name + "]的相似度为：" + pred.score);
					}
				}
				
				if (result.size() > 0) {
					ArrayAdapter adapter = new ArrayAdapter(
							RecogniseGesture.this, 
							android.R.layout.simple_dropdown_item_1line, 
							result.toArray());
					
					new AlertDialog.Builder(RecogniseGesture.this)
					.setAdapter(adapter, null)
					.setPositiveButton("保存", null).show();
				} else {
					Toast.makeText(RecogniseGesture.this, "无法找到能匹配的手势", Toast.LENGTH_LONG).show();
				}
				
				
			}
		});
	}

	public final String GESTURE_PATH = "/sdcard/mygestures";
	private final String TAG = "RecogniseGesture";
	private GestureOverlayView mGestureOverlayView;
	private GestureLibrary mGestureLibrary;
	
	
	
	
}
