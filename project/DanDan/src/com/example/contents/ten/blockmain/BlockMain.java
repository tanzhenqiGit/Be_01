package com.example.contents.ten.blockmain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.example.dandan.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

public class BlockMain extends Activity {

	private final String TAG = "BlockMain";
	private ArrayList<String> mBlockList = new ArrayList<String>();
	private TelephonyManager mTMger;
	private CustomPhoneCallListener mCPListener;
	
	
	
	public class CustomPhoneCallListener extends PhoneStateListener
	{

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			Log.d(TAG, "onCallStateChanged");
			switch(state) {
			case TelephonyManager.CALL_STATE_IDLE:
				Log.d(TAG, "onCallStateChanged CALL_STATE_IDLE");
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				Log.d(TAG, "onCallStateChanged CALL_STATE_OFFHOOK");
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Log.d(TAG, "onCallStateChanged CALL_STATE_RINGING");
				if (isBlock(incomingNumber)) {
					try {
						Method method = Class.forName("android.os.ServiceManager")
								.getMethod("getService", String.class);
						IBinder binder = (IBinder) method.invoke(null, 
								new Object[] {TELEPHONY_SERVICE});
						ITelephony telephony = ITelephony.Stub.asInterface(binder);
						try {
							Log.d(TAG, "telephony end call");
							telephony.endCall();
						} catch (RemoteException e) {
							Log.d(TAG, "RemoteException");
							e.printStackTrace();
						}
						
					} catch (NoSuchMethodException e) {
						Log.d(TAG, "NoSuchMethodException");
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						Log.d(TAG, "ClassNotFoundException");
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						Log.d(TAG, "IllegalArgumentException");
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						Log.d(TAG, "IllegalAccessException");
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						Log.d(TAG, "InvocationTargetException");
						e.printStackTrace();
					}
				}
				break;
			default:
				Log.d(TAG, "onCallStateChanged default");
				break;
			
			}
			super.onCallStateChanged(state, incomingNumber);
		}
		
	}
	
	public boolean isBlock(String phone)
	{
		for(String indexName : mBlockList)
		{
			if(indexName.equals(phone)) {
				return true;
			}
		}
		return false;
	}
	
	
	private void initializeComponent()
	{
		mTMger = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		mCPListener = new CustomPhoneCallListener();
		mTMger.listen(mCPListener, PhoneStateListener.LISTEN_CALL_STATE);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_blockmain_main);
		initializeComponent();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG, "onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
