package com.example.contents.eighteen;

import android.graphics.Bitmap;

public class PieceImage {

	public Bitmap getmImage() {
		return mImage;
	}
	public void setmImage(Bitmap mImage) {
		this.mImage = mImage;
	}
	public int getmImageId() {
		return mImageId;
	}
	public void setmImageId(int mImageId) {
		this.mImageId = mImageId;
	}
	public PieceImage(Bitmap mImage, int mImageId) {
		super();
		this.mImage = mImage;
		this.mImageId = mImageId;
	}
	private Bitmap mImage;
	private int mImageId;
	
}
