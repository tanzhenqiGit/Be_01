package com.example.contents.eighteen;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;
import android.util.Log;

public class LinkInfo {

	public LinkInfo(Point p1, Point p2)
	{
		if (mPoints != null) {
			mPoints.add(p1);
			mPoints.add(p2);
		}
	}
	
	public LinkInfo(Point p1, Point p2, Point p3)
	{
		if (mPoints != null) {
			mPoints.add(p1);
			mPoints.add(p2);
			mPoints.add(p3);
		}
	}
	
	public LinkInfo(Point p1, Point p2, Point p3, Point p4)
	{
		if (mPoints != null) {
			mPoints.add(p1);
			mPoints.add(p2);
			mPoints.add(p3);
			mPoints.add(p4);
		}
	}
	
	public List<Point> getLinkPoints()
	{
		return mPoints;
	}

	public void print()
	{
		for (int i = 0; i < mPoints.size(); i++) {
			Point p = mPoints.get(i);
			Log.d(TAG, "Point:" + i + "(" + p.x + "," + p.y + ")");
		}
	}
	private List<Point> mPoints = new ArrayList<Point>();
	public final String TAG = "LinkInfo";
}
