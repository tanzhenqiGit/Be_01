package com.example.contents.three.drawview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	public float mCurX = 40;
	public float mCurY = 50;
	
	
	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint p = new Paint();
		p.setColor(Color.RED);
		canvas.drawCircle(mCurX, mCurY, 15, p);
	}


	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.mCurX = event.getX();
		this.mCurY = event.getY();
		this.invalidate();
		return true;
	}
	

	
	
	
}
