package com.example.contents.eighteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.graphics.Point;
import android.util.Log;

public class GameServiceImpl implements GameService {

	
	public GameServiceImpl(GameConf mGameConf) {
		super();
		this.mGameConf = mGameConf;
	}
	
	@Override
	public void start() {
		Log.d(TAG, "start");
		AbstractBoard board = null;
		Random random = new Random();
		int index = random.nextInt(4);
		switch (index)
		{
		case VERTICAL_BOARD:
			board = new VerticalBoard();
			break;
		case HORIZONTAL_BOARD:
			board = new HorizontalBoard();
			break;
		case FULL_BOARD:
			board = new FullBoard();
			break;
		default:
			board = new FullBoard();	
			break;
		}
		mPieces = board.create(mGameConf);

	}

	@Override
	public Piece[][] getPieces() {
		Log.d(TAG, "getPieces");
		return mPieces;
	}

	@Override
	public boolean hasPieces() {
		Log.d(TAG, "hasPieces");
		for (int i = 0; i < mPieces.length; i++) {
			for (int j = 0; j < mPieces[i].length; j++) {
				if (mPieces[i][j] != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Piece findPiece(float touchX, float touchY) {
		Log.d(TAG, "findPiece touch:" + touchX + " touchY:" + touchY);
		int relativeX = (int) touchX - mGameConf.getmBeginImageX();
		int relativeY = (int) touchY - mGameConf.getmBeginImageY();
		if ( relativeX < 0 || relativeY < 0 ) {
			Log.e(TAG, "findPiece relativeX=" + relativeX + ",relativeY=" + relativeY);
			return null;
		}
		int indexX = getIndex(relativeX, GameConf.PIECE_WIDHT);
		int indexY = getIndex(relativeY, GameConf.PIECE_HEIGHT);
		
		if (indexX < 0 || indexY < 0) {
			Log.e(TAG, "indexX = " + indexX + ", indexY=" + indexY);
			return null;
		}
		
		if (indexX > mGameConf.getmXSize() || indexY > mGameConf.getmYSize())
		{
			Log.e(TAG, "indexX = " + indexX 
					+ ",MaxX:" + mGameConf.getmXSize() 
					+ ", indexY=" + indexY
					+ ",MaxY" + mGameConf.getmYSize());
			return null;
		}
		
		return mPieces[indexX][indexY];
	}

	@Override
	public LinkInfo link(Piece p1, Piece p2) {
		Log.d(TAG,"link");
		if (p1.equals(p2)) {
			Log.d(TAG, "p1 is equals p2, do nothing.");
			return null;
		}
		
		if (!p1.isSameImage(p2)) {
			Log.d(TAG,"p1 is imageId is not equal p2, do nothing.");
			return null;
		}
		
		Point p1Point = p1.getCenter();
		Point p2Point = p2.getCenter();
		// case 1 in same y
		if (p1.getmIndexY() == p2.getmBeginY()) {
			Log.d(TAG, "p1 and p2 is in same Y");
			if ( !isXblock(p1Point, p2Point, GameConf.PIECE_WIDHT) ) {
				Log.d(TAG, "link x is not block.");
				return new LinkInfo(p1Point, p2Point);
			}
		}
		// case in same x
		if (p1.getmIndexX() == p1.getmIndexX()) {
			Log.d(TAG, "p1 and p2 is in same X");
			if ( !isYblock(p1Point, p2Point, GameConf.PIECE_HEIGHT) ) {
				Log.d(TAG, "link y is not  block");
				return new LinkInfo(p1Point, p2Point);
			}
		}
		
		// case in has a corner point
		Point cornerPoint = getCornerPoint(p1Point, p2Point, GameConf.PIECE_WIDHT, GameConf.PIECE_HEIGHT);
		if (cornerPoint != null) {
			return new LinkInfo(p1Point, cornerPoint, p2Point);
		}
		
		//case in has two corner point
		Map<Point, Point> turns = getLinkPoints(p1Point, p2Point, GameConf.PIECE_WIDHT, GameConf.PIECE_HEIGHT);
		if (turns.size() != 0) {
			return getShortCut(p1Point, p2Point, turns, getDistance(p1Point, p2Point));
		}
		
		
		return null;
	}
	
	
	private int getIndex(int relative , int size)
	{
		Log.d(TAG, "getIndex(relative:" + relative + ",size:" + size + ")");
		int index = -1;
		if (relative % size == 0) {
			index = relative / size -1;
		} else {
			index = relative / size;
		}
		return index;
	}

	
	
	
	
	
	private Point getCornerPoint(Point p1, Point p2, int pieceWidth, int pieceHeight)
	{
		if (isLeftUp(p1, p2) || isLeftDown(p1, p2))
		{
			return getCornerPoint(p2, p1, pieceWidth, pieceHeight);
		}
		
		List<Point> point1RightChanel = getRightChanel(p1, p2.x, pieceWidth);
		List<Point> point1UpChanel = getUpChanel(p1, p2.y, pieceHeight);
		List<Point> point1DownChanel = getDownChanel(p1, p2.y, pieceHeight);
		
		List<Point> point2LeftChanel = getLeftChanel(p2, p1.x, pieceWidth);
		List<Point> point2UpChanel = getUpChanel(p2, p1.y, pieceHeight);
		List<Point> point2DownChanel = getUpChanel(p2, p1.y, pieceHeight);
		
		if (isRightUp(p1, p2)) {
			Point linkPoint1 = getWrapPoint(point1RightChanel, point2DownChanel);
			Point linkPoint2 = getWrapPoint(point1UpChanel, point2LeftChanel);
			return (linkPoint1 == null) ? linkPoint2 : linkPoint1;
		}
		
		if (isRightDown(p1, p2)) {
			Point linkPoint1 = getWrapPoint(point1RightChanel, point2UpChanel);
			Point linkPoint2 = getWrapPoint(point1DownChanel, point2LeftChanel);
			return (linkPoint1 == null) ? linkPoint2 : linkPoint1;
		}
		return null;
	}

	private boolean isXblock(Point p1, Point p2, int pieceWidth)
	{
		if (p2.x < p1.x) {
			return isXblock(p2, p1, pieceWidth);
		}
		// p1.x < p2.x 	
		for (int i = p1.x + pieceWidth; i < p2.x; i = i + pieceWidth)
		{
			if (hasPiece(i, p1.y)); {
				return true;
			}
		}
		return false;
	}
	
	private boolean isYblock(Point p1, Point p2, int pieceHeight)
	{
		if (p2.y < p1.y) {
			return isYblock(p2, p1, pieceHeight);
		}
		// p1.y < p2.y
		for (int i = p1.y + pieceHeight; i < p2.y; i = i + pieceHeight) {
			if (hasPiece(p1.x, i)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasPiece(int x, int y)
	{
		if (findPiece(x, y) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * judge point p2 is left up at p1
	 * @param p1
	 * @param p2
	 * @return
	 */
	private boolean isLeftUp(Point p1, Point p2)
	{
		return (p2.x < p1.x && p2.y < p1.y);
	}
	/**
	 * judge point p2 is left down at p1
	 * @param p1
	 * @param p2
	 * @return
	 */
	private boolean isLeftDown(Point p1, Point p2)
	{
		return (p2.x < p1.x && p2.y > p1.y);
	}
	/**
	 * judge point p2 is right up at p1
	 * @param p1
	 * @param p2
	 * @return
	 */
	private boolean isRightUp(Point p1, Point p2)
	{
		return (p2.x > p1.x && p2.y < p1.y);
	}
	/**
	 * judge point p2 is right down at p1
	 * @param p1
	 * @param p2
	 * @return
	 */
	private boolean isRightDown(Point p1, Point p2)
	{
		return (p2.x > p1.x && p2.y > p1.y);
	}
	
	/**
	 * 
	 * @param p
	 * @param max
	 * @param pieceWidht
	 * @return 
	 */
	private List<Point> getRightChanel(Point p, int max, int pieceWidth)
	{
		List<Point> result = new ArrayList<Point>();
		for (int i = p.x + pieceWidth; i <= max; i = i + pieceWidth)
		{
			if (hasPiece(i, p.y)) {
				return result;
			}
			
			result.add(new Point(i, p.y));
		}
		
		return result;
	}
	
	private List<Point> getLeftChanel(Point p, int min, int pieceWidth)
	{
		List<Point> result = new ArrayList<Point>();
		for (int i = p.x - pieceWidth; i >= min; i = i - pieceWidth)
		{
			if (hasPiece(i, p.y)) {
				return result;
			}
			
			result.add(new Point(i, p.y));
		}
		
		return result;	}
	
	/**
	 * 
	 * @param p
	 * @param max
	 * @param pieceHeight
	 * @return
	 */
	private List<Point> getDownChanel(Point p, int max, int pieceHeight)
	{
		List<Point> result = new ArrayList<Point>();
		for (int i = p.y + pieceHeight; i <= max; i = i + pieceHeight)
		{
			if (hasPiece(p.x, i)) {
				return result;
			}
			result.add(new Point(p.x, i));
		}
		return result;
	}
	
	/**
	 * 
	 * @param p
	 * @param min
	 * @param pieceHeight
	 * @return
	 */
	private List<Point> getUpChanel(Point p, int min, int pieceHeight)
	{
		List<Point> result = new ArrayList<Point>();
		for (int i = p.y - pieceHeight; i >= min; i = i - pieceHeight)
		{
			if (hasPiece(p.x, i)) {
				return result;
			}
			result.add(new Point(p.x, i));
		}
		return result;
	}
	
	/**
	 * 
	 * @param p1Chanel
	 * @param p2Chanel
	 * @return
	 */
	private Point getWrapPoint(List<Point> p1Chanel, List<Point> p2Chanel)
	{
		for (int i = 0; i < p1Chanel.size(); i++) {
			Point temp1 = p1Chanel.get(i);
			for (int j = 0; j < p2Chanel.size(); j ++) {
				Point temp2 = p2Chanel.get(i);
				if (temp1.equals(temp2)) {
					return temp1;
				}
			}
			
		}
		return null;
	}
	
	
	private Map<Point, Point> getLinkPoints(Point p1, Point p2, int pieceWidth, int pieceHeight)
	{
		
		if (isLeftUp(p1, p2) || isLeftDown(p1, p2)) {
			return getLinkPoints(p2, p1, pieceWidth, pieceHeight);
		}
		
		Map<Point, Point> result = new HashMap<Point, Point>();
		
		List<Point> p1UpChanel = getUpChanel(p1, p2.y, pieceHeight);
		List<Point> p1RightChanel = getRightChanel(p1, p2.x, pieceWidth);
		List<Point> p1DownChanel = getDownChanel(p1, p2.y, pieceHeight);
		
		List<Point> p2DownChanel = getDownChanel(p2, p1.y, pieceHeight);
		List<Point> p2LeftChanel = getLeftChanel(p2, p1.x, pieceWidth);
		List<Point> p2UpChanel = getUpChanel(p2, p1.y, pieceHeight);
		
		int heightMax = (mGameConf.getmYSize() + 1) * pieceHeight + mGameConf.getmBeginImageY();
		int widthMax = (mGameConf.getmXSize() + 1) * pieceWidth + mGameConf.getmBeginImageX();
		
		if (p1.y == p2.y) {
			p1UpChanel = getUpChanel(p1, 0, pieceHeight);
			p2UpChanel = getUpChanel(p2, 0, pieceHeight);
			
			Map<Point, Point> upLinkPoints = getXLinkPoints(p1UpChanel, p1UpChanel, pieceHeight);
			
			p1DownChanel = getDownChanel(p1, heightMax, pieceHeight);
			p2DownChanel = getDownChanel(p1, heightMax, pieceHeight);
			Map<Point, Point> downLinkPoints = getXLinkPoints(p2DownChanel, p2DownChanel, pieceWidth);
			
			result.putAll(upLinkPoints);
			result.putAll(downLinkPoints);
		} else if (p1.x == p2.x) {
			List<Point> p1LeftChanel = getLeftChanel(p1, 0, pieceWidth);
			p2LeftChanel = getLeftChanel(p2, 0, pieceWidth);
			Map<Point, Point> leftLinkPoints = getYLinkPoints(p1LeftChanel, p2LeftChanel, pieceHeight);
			
			p1RightChanel = getRightChanel(p1, widthMax, pieceWidth);
			List<Point> p2RightChanel = getRightChanel(p2, widthMax, pieceWidth);
			Map<Point, Point> rightLinkPoints = getYLinkPoints(p1LeftChanel, p2RightChanel, pieceHeight);
			
			result.putAll(leftLinkPoints);
			result.putAll(rightLinkPoints);
		} else 	if (isRightUp(p1, p2)) {
			Map<Point, Point> upDownLinkPoints = getXLinkPoints(p1UpChanel, p2DownChanel, pieceWidth);
			
			Map<Point, Point> rightLeftLinkPoints = getYLinkPoints(p1RightChanel, p2LeftChanel, pieceHeight);
			
			p1UpChanel = getUpChanel(p1, 0, pieceHeight);
			p2UpChanel = getUpChanel(p2, 0, pieceHeight);
			Map<Point, Point> upUpLinkPoints = getXLinkPoints(p1UpChanel, p2UpChanel, pieceWidth);
			
			p1DownChanel = getDownChanel(p1, heightMax, pieceHeight);
			p2DownChanel = getDownChanel(p2, heightMax, pieceHeight);
			Map<Point, Point> downDownLinkPoints = getXLinkPoints(p1DownChanel, p2DownChanel, pieceWidth);
			
			p1RightChanel = getRightChanel(p1, widthMax, pieceWidth);
			List<Point> p2RightChanel = getRightChanel(p2, widthMax, pieceWidth);
			Map<Point, Point> rightRightLinkPoints = getYLinkPoints(p1RightChanel, p2RightChanel, pieceHeight);
			
			List<Point> p1LeftChanel = getLeftChanel(p1, 0, pieceWidth);
			p2LeftChanel = getLeftChanel(p2, 0, pieceWidth);
			Map<Point, Point> leftLeftLinkPoints = getYLinkPoints(p1LeftChanel, p2LeftChanel, pieceHeight);
			
			result.putAll(upDownLinkPoints);
			result.putAll(rightLeftLinkPoints);
			result.putAll(upUpLinkPoints);
			result.putAll(downDownLinkPoints);
			result.putAll(rightRightLinkPoints);
			result.putAll(leftLeftLinkPoints);
			
		} else if (isRightDown(p1, p2)) {
			
			Map<Point, Point> downUpLinkPoints = getXLinkPoints(p1DownChanel, p2UpChanel, pieceWidth);
			Map<Point, Point> rightLeftLinkPoints = getYLinkPoints(p1RightChanel, p2LeftChanel, pieceHeight);
			
			p1UpChanel = getUpChanel(p1, 0, pieceHeight);
			p2UpChanel = getUpChanel(p2, 0, pieceHeight);
			Map<Point, Point> upUpLinkPoints = getXLinkPoints(p1UpChanel, p2UpChanel, pieceWidth);
			
			p2DownChanel = getDownChanel(p2, heightMax, pieceHeight);
			p1DownChanel = getDownChanel(p1, heightMax, pieceHeight);
			Map<Point, Point> downDownLinkPoints = getXLinkPoints(p1DownChanel, p2DownChanel, pieceWidth);
			
			List<Point> p1LeftChanel = getLeftChanel(p1, 0, pieceWidth);
			p2LeftChanel = getLeftChanel(p2, 0, pieceWidth);
			Map<Point, Point> leftLeftLinkPoints = getYLinkPoints(p1LeftChanel, p2LeftChanel, pieceHeight);
			
			List<Point> p2RightChanel = getRightChanel(p2, widthMax	, pieceWidth);
			p1RightChanel = getRightChanel(p1, widthMax, pieceWidth);
			Map<Point, Point> rightRightLinkPoints = getYLinkPoints(p1RightChanel, p2RightChanel, pieceHeight);
			
			result.putAll(downUpLinkPoints);
			result.putAll(rightLeftLinkPoints);
			result.putAll(upUpLinkPoints);
			result.putAll(downDownLinkPoints);
			result.putAll(leftLeftLinkPoints);
			result.putAll(rightRightLinkPoints);

			
			
			
		} else {
			
		}
		
		return result;
		
	}
	
	
	private Map<Point, Point> getXLinkPoints(List<Point> p1Chanel, List<Point> p2Chancel, int pieceWidth)
	{
		Map<Point, Point> result = new HashMap<Point, Point>();
		for (int i = 0; i < p1Chanel.size(); i++) {
			Point temp1 = p1Chanel.get(i);
			for (int j = 0; j < p2Chancel.size(); j++) {
				Point temp2 = p2Chancel.get(j);
				
				if (temp1.y == temp2.y) {
					if ( !isXblock(temp1, temp2, pieceWidth)) {
						result.put(temp1, temp2);
					}
				}
			}
		}
		return result;
	}

	private Map<Point, Point> getYLinkPoints(List<Point> p1Chanel, List<Point> p2Chanel, int pieceHeight)
	{
		Map<Point, Point> result = new HashMap<Point, Point>();
		for (int i = 0; i < p1Chanel.size(); i++) {
			Point temp1 = p1Chanel.get(i);
			for (int j = 0; j < p2Chanel.size(); j++) {
				Point temp2 = p2Chanel.get(j);
				if (temp1.x == temp2.x) {
					if ( isYblock(temp1, temp2, pieceHeight)) {
						result.put(temp1, temp2);
					}
				}
			}
		}
		return result;
	}
	
	private LinkInfo getShortCut(Point p1,Point p2, Map<Point, Point> turns, int shortDistance)
	{
		List<LinkInfo> infos = new ArrayList<LinkInfo>();
		for (Point point1 : turns.keySet()) {
			Point point2 = turns.get(point1);
			infos.add(new LinkInfo(p1, point1,point2, p2));
		}
		return getShortCut(infos,shortDistance);
	}
	
	
	private LinkInfo getShortCut(List<LinkInfo> infos, int shortDistance)
	{
		int temp1 = 0;
		LinkInfo result = null;
		
		for (int i = 0; i < infos.size(); i++)
		{
			LinkInfo info = infos.get(i);
			int distance = countAll(info.getLinkPoints());
			
			if (i == 0) {
				temp1 = distance - shortDistance;
				result = info;
			}
			
			if (distance - shortDistance < temp1) {
				temp1 = distance - shortDistance;
				result = info;
			}
			
		}
		
	
		return result;
	}
	
	
	private int countAll(List<Point> points)
	{
		int result = 0;
		for (int i = 0; i < points.size() - 1; i++) {
			Point point1 = points.get(i);
			Point point2 = points.get(i + 1);
			result += getDistance(point1, point2);
		}
		return result;
	}
	
	private int getDistance(Point p1, Point p2)
	{
		int xDistance = Math.abs(p1.x - p2.x);
		int yDistance = Math.abs(p1.y - p2.y);
		return xDistance + yDistance;
	}
	
	public final String TAG = "GameServiceImpl";
	private final int VERTICAL_BOARD = 0;
	private final int HORIZONTAL_BOARD = 1;
	private final int FULL_BOARD = 2;
	private Piece[][] mPieces;
	private GameConf mGameConf;

	
}
