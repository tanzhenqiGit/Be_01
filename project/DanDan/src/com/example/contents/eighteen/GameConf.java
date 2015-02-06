package com.example.contents.eighteen;

import android.content.Context;

public class GameConf {

	/**
	 * every piece width and height
	 */
	public static final int PIECE_WIDHT = 60;
	public static final int PIECE_HEIGHT = 60;
	
	/**
	 * game time.
	 */
	public static int DEFAULT_TIME = 100;
	
	/**
	 * construct for gameconf.
	 * @param mXSize max number for x axis.
	 * @param mYSize max number for y axis.
	 * @param mBeginImageX first piece's x-coordinate.
	 * @param mBeginImageY first piece's y-coordinate.
	 * @param gameTime game time.
	 * @param mContext context for resource.
	 */
	public GameConf(int mXSize, int mYSize, int mBeginImageX, int mBeginImageY,
			long gameTime, Context mContext) {
		super();
		this.mXSize = mXSize;
		this.mYSize = mYSize;
		this.mBeginImageX = mBeginImageX;
		this.mBeginImageY = mBeginImageY;
		this.gameTime = gameTime;
		this.mContext = mContext;
	}
	
	public int getmXSize() {
		return mXSize;
	}
	public int getmYSize() {
		return mYSize;
	}
	public int getmBeginImageX() {
		return mBeginImageX;
	}
	public int getmBeginImageY() {
		return mBeginImageY;
	}
	public long getGameTime() {
		return gameTime;
	}
	public Context getmContext() {
		return mContext;
	}

	private int mXSize;
	private int mYSize;
	
	private int mBeginImageX;
	private int mBeginImageY;
	
	private long gameTime;
	private Context mContext;
}
