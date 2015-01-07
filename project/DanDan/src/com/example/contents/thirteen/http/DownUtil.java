/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2015-1-5
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2015-1-5 ÏÂÎç5:33:30
* @class DownUtil.java
*/ 
package com.example.contents.thirteen.http;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author free
 *
 */
public class DownUtil {
	
	
	private String mPath;
	private String mTargetFile;
	private int mThreadNum;
	
	private DownloadThread[] mThreads; 
	private int mFileSize;
	
	/**
	 * @param mPath
	 * @param mTargetFile
	 * @param mThreadNum
	 */
	public DownUtil(String mPath, String mTargetFile, int mThreadNum) {
		super();
		this.mPath = mPath;
		this.mTargetFile = mTargetFile;
		this.mThreadNum = mThreadNum;
		mThreads = new DownloadThread[mThreadNum];
	}


	public void download() throws Exception
	{
		URL url1 = new URL(mPath);
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "");
		
		conn.setRequestProperty("Connection", "Keep-Alive");
		
		mFileSize = conn.getContentLength();
		conn.disconnect();
		
		int currentPartSize = mFileSize / mThreadNum + 1;
		RandomAccessFile  file = new RandomAccessFile(mTargetFile, "rw");
		file.setLength(mFileSize);
		file.close();
		
		for (int i = 0; i < mThreadNum; i++)
		{
			int startPos = i * currentPartSize;
			RandomAccessFile currentPart = new RandomAccessFile(mTargetFile, "rw");
			currentPart.seek(startPos);
			mThreads[i] = new DownloadThread(startPos, currentPartSize, currentPart);
			mThreads[i].start();
		}
	}
	
	
	public double getCompleteRate()
	{
		int sumSize = 0;
		for (int i = 0; i < mThreadNum; i++)
		{
			if (mThreads[i] != null) {
				sumSize += mThreads[i].mLength;
			}
		}
		if (mFileSize <= 0) {
			return 0;
		}
		
		return sumSize * 1.0 / mFileSize;
	}
	
	

	
	
	
	private class DownloadThread extends Thread
	{
		/**
		 * @param mStartPos
		 * @param mCurrentPartSize
		 * @param mCurrentPart
		 */
		public DownloadThread(int mStartPos, int mCurrentPartSize,
				RandomAccessFile mCurrentPart) {
			super();
			this.mStartPos = mStartPos;
			this.mCurrentPartSize = mCurrentPartSize;
			this.mCurrentPart = mCurrentPart;
		}

		
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				URL url = new URL(mPath);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				//conn.setRequestProperty(field, newValue)
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				
				InputStream inStream = conn.getInputStream();
				inStream.skip(this.mStartPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				while (mLength < mCurrentPartSize && (hasRead = inStream.read(buffer)) != -1) {
					mCurrentPart.write(buffer, 0, hasRead);
					mLength += hasRead;
				}
				mCurrentPart.close();
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}



		private int mStartPos;
		private int mCurrentPartSize;
		private RandomAccessFile mCurrentPart;
		public int mLength;
		
	
	}
}
