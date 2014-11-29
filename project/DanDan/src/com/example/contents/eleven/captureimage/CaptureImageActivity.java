package com.example.contents.eleven.captureimage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CaptureImageActivity extends Activity {

	private final String TAG = "CaptureImageActivity";
	private SurfaceView mView;
	private SurfaceHolder mSurfaceHolder;
	private int mScreenWidth, mScreenHeight;
	private Camera mCamera;
	private boolean mIsPreview = false;
	
	
	@SuppressLint("NewApi")
	private void initializeCamera()
	{
		if (!mIsPreview) {
			mCamera = Camera.open(0);
			if (mCamera != null) {
				mCamera.setDisplayOrientation(90);
			}
			if (mCamera != null && !mIsPreview) {
				Camera.Parameters paramters = mCamera.getParameters();
				paramters.setPreviewSize(mScreenWidth, mScreenHeight);
				paramters.setPreviewFpsRange(4, 10);
				paramters.setPictureFormat(ImageFormat.JPEG);
				paramters.set("jpeg-quality", 85);
				paramters.setPictureSize(mScreenWidth, mScreenHeight);
				mCamera.setParameters(paramters);
				try {
					mCamera.setPreviewDisplay(mSurfaceHolder);
				} catch (IOException e) {
					Log.d(TAG,"exception is ocurred.");
					e.printStackTrace();
				}
				mCamera.startPreview();
				//mCamera.autoFocus(null);
			}
			
		}
	}
	
	
	PictureCallback mJpegCallback = new PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			Log.d(TAG,"onPictureTaken");
			final Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
			View saveDialog = getLayoutInflater()
					.inflate(R.layout.eleven_capture_image_save, null);
			final EditText photoName 
				= (EditText)saveDialog.findViewById(
						R.id.eleven_capture_image_save_imagename_edittext);
			ImageView showImage = (ImageView)saveDialog.findViewById(R.id.eleven_capture_save_showimage_imageview);
			if (showImage != null) {
				showImage.setImageBitmap(bm);
				
			} else {
				Log.d(TAG, "showImage == null");
				return;
			}
			
			new AlertDialog.Builder(CaptureImageActivity.this).setView(saveDialog)
				.setPositiveButton("save", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Log.d(TAG, "save button is onclicked");
					File file = new File(Environment.getExternalStorageDirectory(),
							photoName.getText().toString()+".jpg");
					FileOutputStream outStream = null;
					Toast.makeText(CaptureImageActivity.this,
							Environment.getExternalStorageDirectory().getPath()+photoName.getText().toString()+".jpg", Toast.LENGTH_LONG).show();
					try {
						outStream = new FileOutputStream(file);
						bm.compress(CompressFormat.JPEG, 100, outStream);
						try {
							outStream.close();
						} catch (IOException e) {
							Log.d(TAG,"IOException");
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						Log.d(TAG,"file :"+file.toString() + "not found");
						e.printStackTrace();
					}
					
					
				}
			}).setNegativeButton("cancel",null).show();
			camera.stopPreview();
			camera.startPreview();
			mIsPreview = true;
			
		}
	};
	
	
	AutoFocusCallback mAutoFocusCallback = new AutoFocusCallback() {
		
		@Override
		public void onAutoFocus(boolean success, Camera camera) {
			Log.d(TAG, "onautoFocus is called success" + success);
			if (success) {
				camera.takePicture(new ShutterCallback() {
					
		     		@Override
					public void onShutter() {
						Log.d(TAG, "onShutter is called");
						
					}
				}, new PictureCallback() {
					
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						Log.d(TAG, "onPictureTaken is called");
						
					}
				}, mJpegCallback);
			} 
			
		}
	};
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP ) {
			Log.d(TAG,"action up is called");
			capture();
		}
		Log.d(TAG, "onTouchEvent =" + event.getAction());
		return super.onTouchEvent(event);
	}
	private  void capture() 
	{
		Log.d(TAG, "capture");
	    if (mCamera != null) {
	    	mCamera.autoFocus(mAutoFocusCallback);
	    }
	}
	private void initialize()
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.eleven_capture_image_main);
		
		WindowManager wm = getWindowManager();
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		mScreenWidth = metrics.widthPixels;
		mScreenHeight = metrics.heightPixels;
		
		Log.d(TAG, "mScreenWidth=" + mScreenWidth + ",mScreenHeight=" + mScreenHeight);
		
		mView = (SurfaceView)findViewById(R.id.eleven_capture_image_main_surface);
		if (mView != null) {
			Log.d(TAG, "setType");
			mView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			mSurfaceHolder = mView.getHolder();
			mSurfaceHolder.addCallback(new Callback() {
				
				@Override
				public void surfaceDestroyed(SurfaceHolder holder) {
					Log.d(TAG, "surfaceDestroyed");
					if (mCamera != null) {
						if (mIsPreview) {
							mCamera.stopPreview();
							mCamera.release();
							mCamera = null;
						}
					}
					
				}
				
				@Override
				public void surfaceCreated(SurfaceHolder holder) {
					Log.d(TAG, "surfaceCreated");
					initializeCamera();
					
				}
				
				@Override
				public void surfaceChanged(SurfaceHolder holder, int format, int width,
						int height) {
					Log.d(TAG, "surfaceChanged width="+width+",height="+height);
					
				}
			});
			
		} else {
			Log.d(TAG, "view == null");
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"Activity onCreate");
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Log.d(TAG,"onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"Activity onDestroy");
		super.onDestroy();
	}

	
}
