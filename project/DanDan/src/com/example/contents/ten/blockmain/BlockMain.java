package com.example.contents.ten.blockmain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.android.internal.telephony.ITelephony;
import com.example.dandan.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class BlockMain extends Activity {

	private final String TAG = "BlockMain";
	private ArrayList<String> mBlockList = new ArrayList<String>();
	private TelephonyManager mTMger;
	private CustomPhoneCallListener mCPListener;
	private Button mManagerBlock = null;
	
	
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
		mManagerBlock = (Button)findViewById(R.id.ten_blockmain_main_blockBtn);
		if (mManagerBlock != null) {
			mManagerBlock.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG,"mManagerBlock is onclicked");
					final Cursor cursor = getContentResolver()
						.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, null, null, null);
					
					BaseAdapter adapter = new BaseAdapter() {
						
						@Override
						public View getView(int position, View convertView, ViewGroup parent) {
							cursor.moveToPosition(position);
							CheckBox rb = new CheckBox(BlockMain.this);
							String number = cursor.getString(
									cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
									.replace("-", "");
							rb.setText(number);
							if (isBlock(number)) {
								rb.setChecked(true);
							}
							
							return rb;
						}
						
						@Override
						public long getItemId(int position) {
							Log.d(TAG,"getItemId position=" + position);
							return position;
						}
						
						@Override
						public Object getItem(int position) {
							Log.d(TAG, "getItem() position=" + position);
							return position;
						}
						
						@Override
						public int getCount() {
							Log.d(TAG, "getCount()");
							return cursor.getCount();
						}
					};
					
					View selectView = getLayoutInflater().inflate(R.layout.ten_blackmain_line, null);
					final ListView listview = (ListView)selectView.findViewById(
							R.id.ten_blackmain_line_list);
					if (listview != null) {
						listview.setAdapter(adapter);
					} else {
						Log.d(TAG, "listview == null");
						return;
					}
					
					new AlertDialog.Builder(BlockMain.this)
					.setView(selectView)
					.setPositiveButton("sure",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Log.d(TAG,"onClicked");
							mBlockList.clear();
							for (int i = 0; i < listview.getCount(); i++) {
								CheckBox checkbox = (CheckBox)listview.getChildAt(i);
								if (checkbox.isChecked()) {
									mBlockList.add(checkbox.getText().toString());
									
								}
								Log.d(TAG,"mBlockList" + mBlockList);
							}
							
						}

					}).show();
				}
			});
		}
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
