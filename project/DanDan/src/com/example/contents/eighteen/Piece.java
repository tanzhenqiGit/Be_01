package com.example.contents.eighteen;

import android.graphics.Point;
import android.util.Log;

public class Piece {

	public Piece(int mIndexX, int mIndexY) {
		super();
		this.mIndexX = mIndexX;
		this.mIndexY = mIndexY;
	}
	
	
	public int getmBeginX() {
		return mBeginX;
	}
	public void setmBeginX(int mBeginX) {
		this.mBeginX = mBeginX;
	}
	public int getmBeginY() {
		return mBeginY;
	}
	public void setmBeginY(int mBeginY) {
		this.mBeginY = mBeginY;
	}
	public int getmIndexX() {
		return mIndexX;
	}
	public void setmIndexX(int mIndexX) {
		this.mIndexX = mIndexX;
	}
	public int getmIndexY() {
		return mIndexY;
	}
	public void setmIndexY(int mIndexY) {
		this.mIndexY = mIndexY;
	}
	
	public PieceImage getmImage() {
		return mImage;
	}


	public void setmImage(PieceImage mImage) {
		this.mImage = mImage;
	}
	
	public Point getCenter()
	{
		return new Point(mBeginX + getmImage().getmImage().getWidth() / 2,
				mBeginY + getmImage().getmImage().getHeight() / 2);
	}
	
	
	public boolean isSameImage(Piece other)
	{
		if (other == null) {
			Log.e(TAG, "isSameImage parem other == null, do nothing.");
			return false;
		} else {
			if (other.getmImage() == null) {
				Log.e(TAG, "isSameImage parem other.mImage == null, do nothing.");
				return false;
			}
		}
		
		if (mImage == null) {
			Log.e(TAG, "isSameImage  mImage == null, do nothing.");
			return false;
		}
		
		return mImage.getmImageId() == other.getmImage().getmImageId(); 
	}


	public final String TAG = "Piece";
	private int mBeginX;
	private int mBeginY;
	private int mIndexX;
	private int mIndexY;
	private PieceImage mImage;

}
