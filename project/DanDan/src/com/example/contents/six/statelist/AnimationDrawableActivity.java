/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-23
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-23 ÉÏÎç11:27:38
* @class AnimationDrawableActivity.java
*/ 
package com.example.contents.six.statelist;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author free
 *
 */
public class AnimationDrawableActivity extends Activity {

	private final String TAG = "AnimationDrawableActivity";
	
	private Button mStartBtn;
	private ImageView mShowImg;
	private Animation mAnim;
	
	private void initialize()
	{
		mAnim = AnimationUtils.loadAnimation(this, R.anim.my_anim);
		if (mAnim != null) {
			mAnim.setFillAfter(true);
		}

		mShowImg = (ImageView) findViewById(R.id.common_view_main_img);
		if (mShowImg != null) {
			mShowImg.setBackgroundResource(R.drawable.bomb10);
		}
		
		mStartBtn = (Button) findViewById(R.id.common_view_main_btn);
		if (mStartBtn != null) {
			mStartBtn.setVisibility(View.VISIBLE);
			mStartBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "button is onclicked");
					if (mShowImg != null && mAnim != null) {
						mShowImg.startAnimation(mAnim);
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
		setContentView(R.layout.common_view_main);
		initialize();
	}
	

}
