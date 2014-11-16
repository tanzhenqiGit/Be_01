package com.example.contents.ten.complexservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Pet implements Parcelable {

	private String mName;
	private double mWeight;
	private final static String TAG = "Pet";
	public String getmName() {
		return mName;
	}




	public void setmName(String mName) {
		this.mName = mName;
	}




	public double getmWeight() {
		return mWeight;
	}




	public void setmWeight(double mWeight) {
		this.mWeight = mWeight;
	}

	
	public Pet(String mName, double mWeight) {
		super();
		this.mName = mName;
		this.mWeight = mWeight;
	}

	public Pet() {
		
	}
	



	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		Log.d(TAG, "writeToParcel");
		dest.writeString(mName);
		dest.writeDouble(mWeight);
		
	}
	
}
