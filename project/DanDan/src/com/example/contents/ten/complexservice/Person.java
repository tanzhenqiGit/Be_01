package com.example.contents.ten.complexservice;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Person implements Parcelable {

	public static final String TAG = "Person";
	private Integer mId;
	private String mName;
	private String mPass;
	
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



	public String getmPass() {
		return mPass;
	}



	public void setmPass(String mPass) {
		this.mPass = mPass;
	}


	
	public Person(Integer mId, String mName, String mPass) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mPass = mPass;
	}


	
	public Person()
	{
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Log.d(TAG, "equals is called.");
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Person other = (Person) obj;
		if (mName == null) {
			if (other.mName != null) {
				return false;
			}
		} else if (!mName.equals(other.mName)){
			return false;
		} else {
			// continue 
		}
		
		if (mPass == null) {
			if (other.mPass != null) {
				return false;
			}
		} else if (!mPass.equals(other.mPass)) {
			return false;
		} else {}
			
		return true;
		
	}



	@Override
	public int hashCode() {
		Log.d(TAG, "hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mPass == null) ? 0 : mPass.hashCode());
		return result;
	}



	@Override
	public int describeContents() {
		Log.d(TAG, "describeContents");
		
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		Log.d(TAG, "writeToParce flags=" + flags);
		dest.writeInt(mId);
		dest.writeString(mName);
		dest.writeString(mPass);
	}
	
	public static final Parcelable.Creator<Person> CREATOR
		= new Parcelable.Creator<Person>() {

			@Override
			public Person createFromParcel(Parcel source) {
				Log.d(Person.TAG, "createFormparcel");
				
				return new Person(source.readInt(),
						source.readString(),
						source.readString());
				
			}

			@Override
			public Person[] newArray(int size) {
				Log.d(Person.TAG, "newArray");
				return new Person[size];
			}
		
		};

}
