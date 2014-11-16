package com.example.contents.ten.complexservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.contents.ten.complexservice.IPet.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ComplexService extends Service {

	private static final String TAG = "ComplexService";
	private PetBinder mPetBinder;
	private static Map<Person, List<Pet>> mPets
		= new HashMap<Person, List<Pet>>();
	
	static 
	{
		ArrayList<Pet> list1 = new ArrayList<Pet>();
		list1.add(new Pet("Íú²Æ", 4.3));
		list1.add(new Pet("À´¸£", 5.1));
		mPets.put(new Person(1, "sun", "sun"), list1);
		
		ArrayList<Pet> list2 = new ArrayList<Pet>();
		list2.add(new Pet("ketty", 2.3));
		list2.add(new Pet("garfield", 3.1));
		mPets.put(new Person(2, "bai", "bai"), list2);
		
	}
	
	public class PetBinder extends Stub
	{

		@Override
		public List<Pet> getPets(Person owner) throws RemoteException {
			Log.d(TAG,"getPets");
			return mPets.get(owner);
			
		}
		
	}
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(TAG, "onBind");
		return mPetBinder;
	}

	@Override
	public void onCreate() {
		Log.d(TAG,"onCreate");
		super.onCreate();
		mPetBinder = new PetBinder();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG,"onDestroy");
		super.onDestroy();
	}

}
