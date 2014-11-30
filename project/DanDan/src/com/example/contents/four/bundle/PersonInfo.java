/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÉÏÎç11:10:22.
*/ 
package com.example.contents.four.bundle;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class PersonInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPasswd() {
		return mPasswd;
	}
	public void setmPasswd(String mPasswd) {
		this.mPasswd = mPasswd;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PersonInfo(String mName, String mPasswd, String mGender) {
		super();
		this.mName = mName;
		this.mPasswd = mPasswd;
		this.mGender = mGender;
	}
	private Integer mId;
	private String mName;
	private String mPasswd;
	private String mGender;

}
