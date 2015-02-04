package com.example.contents.eighteen;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameView extends View {

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "GameView Constructor");
		initialize(context);
	}
	
	public void setmLinkInfo(LinkInfo mLinkInfo) {
		this.mLinkInfo = mLinkInfo;
	}

	public LinkInfo getmLinkInfo() {
		return mLinkInfo;
	}
	
	public Piece getmSelectPiece() {
		return mSelectPiece;
	}

	public void setmSelectPiece(Piece mSelectPiece) {
		this.mSelectPiece = mSelectPiece;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}

	
	private void initialize(Context context)
	{
		mPaint = new Paint();
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth((float) 3.0);
		mSelectImage = ImageUtil.getSelectImage(context);
	}
	
	private void drawLine(LinkInfo linkInfo, Canvas canvas)
	{
		if (linkInfo == null || canvas == null) {
			Log.e(TAG, "(linkInfo == null || canvas == null case is ture");
			return;
		}
		List<Point> points = linkInfo.getLinkPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point currentPoint = points.get(i);
			Point nextPoint = points.get(i + 1);
			if (canvas != null) {
				canvas.drawLine(currentPoint.x, 
						currentPoint.y, 
						nextPoint.x, 
						nextPoint.y,
						mPaint);
			}
		}
	}
	
	private final String TAG = "GameView";
	private Piece mSelectPiece;
	private LinkInfo mLinkInfo;
	private Bitmap mSelectImage;
	private Paint mPaint;
	
}
