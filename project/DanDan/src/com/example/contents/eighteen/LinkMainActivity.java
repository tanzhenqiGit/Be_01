package com.example.contents.eighteen;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dandan.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class LinkMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		initialize();
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "onRestart");
		super.onRestart();
		if (mIsPlaying) {
			startGame(mGameTime);
		}
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause");
		super.onPause();
		stopTimer();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	@SuppressLint("ClickableViewAccessibility")
	private void initialize()
	{
		Log.d(TAG, "initialize()");
		setContentView(R.layout.eighteen_link_main);
		mGameConfig = new GameConf(8, 8, 2, 4, 100 * 1000, this);
		
	
		mStartBtn = (Button) findViewById(R.id.eighteen_link_main_start_btn);
		if (mStartBtn != null) {
			mStartBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d(TAG, "start button onclicked");
					startGame(GameConf.DEFAULT_TIME);
				}
			});
		}
		mShowTime = (TextView) findViewById(R.id.eighteen_link_main_time_txt);
		if (mShowTime != null) {
			
		}
		
		mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		mGameService = new GameServiceImpl(mGameConfig);
		mGameView = (GameView) findViewById(R.id.eighteen_link_main_gameview);
		if (mGameView != null) {
			mGameView.setmGameService(mGameService);
			mGameView.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						
						gameViewTouchDown(event);
						
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						
						gameViewTouchUp(event);
						
					} else {
						
					}
					return true;
				}
			});
			
			mLostDialog = createDialog("Lost", "游戏结束 | 重新开始", R.drawable.lost)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					startGame(GameConf.DEFAULT_TIME);					
				}
			});
			
			
			mSucessDialog = createDialog("Sucess", "游戏胜利 | 重新开始", R.drawable.success)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startGame(GameConf.DEFAULT_TIME);							
						}
					});
		}
		
	}
	

	private void startGame(int gameTime)
	{
		if (mTimer != null) {
			stopTimer();
		}
		
		mGameTime = gameTime;
		if (gameTime == GameConf.DEFAULT_TIME) {
			Log.d(TAG, "startGame : " + gameTime);
			mGameView.startGame();
		}
		
		mIsPlaying = true;
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (mHandler != null) {
					mHandler.sendEmptyMessage(MSG_UPDATE_TIMER);
				}
			}
		}, 0, 1000);
		
		mSelectPiece = null;
	}
	
	
	private void stopTimer()
	{
		if (mTimer != null) {
			mTimer.cancel();
			mTimer = null;
		} else {
			Log.d(TAG, "stopTimer mTimer == null");
		}
	}
	private void gameViewTouchUp(MotionEvent event)
	{
		if (mGameView != null) {
			mGameView.postInvalidate();
		}
	}


	private void gameViewTouchDown(MotionEvent event)
	{
		if (mGameService == null) {
			Log.d(TAG, "gameViewTouchDown");
			return;
		}
		Piece[][] pieces = mGameService.getPieces();
		float touchX = event.getX();
		float touchY = event.getY();
	
		Piece currentPiece = mGameService.findPiece(touchX, touchY);
		if (currentPiece == null) {
			return;
		}
		Log.d(TAG, "touch : (" + currentPiece.getmIndexX() + "," + currentPiece.getmIndexY() + ")");

		mGameView.setmSelectPiece(currentPiece);
		if (mSelectPiece == null) {
			mSelectPiece = currentPiece;
			mGameView.postInvalidate();
			return;
		}
		
		if (mSelectPiece != null) {
			LinkInfo linkInfo = mGameService.link(mSelectPiece, currentPiece);
			if (linkInfo == null) {
				Log.d(TAG, "gameViewTouchDown linkInfo is null");
				mSelectPiece = currentPiece;
				mGameView.postInvalidate();
			} else {
				Log.d(TAG, "link sucessed.");
				handleSuccessLink(linkInfo, mSelectPiece, currentPiece, pieces);
			}
		}
	}
	
	private void handleSuccessLink(LinkInfo linkInfo, Piece PrePiece, Piece currentPiece, Piece[][] pieces)
	{
		linkInfo.print();
		mGameView.setmLinkInfo(linkInfo);
		mGameView.setmSelectPiece(null);
		mGameView.postInvalidate();
		
		pieces[PrePiece.getmIndexX()][PrePiece.getmIndexY()] = null;
		pieces[currentPiece.getmIndexX()][currentPiece.getmIndexY()] = null;
		
		mSelectPiece = null;
		if (mVibrator != null) {
			mVibrator.vibrate(100);
		}
		
		if (!mGameService.hasPieces()) {
			mSucessDialog.show();
			stopTimer();
			mIsPlaying = false;
		}
		
	}
	
	private AlertDialog.Builder createDialog(String title, String message, int imageResource)
	{
		return new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message)
				.setIcon(imageResource);
	}
	
	
	private final String TAG = "LinkMainActivity";
	private final int MSG_UPDATE_TIMER = 0x01;
	private Button mStartBtn;
	private TextView mShowTime;
	private GameView mGameView;
	private GameConf mGameConfig;
	private GameService mGameService;
	private int mGameTime;
	
	private AlertDialog.Builder mLostDialog;
	private AlertDialog.Builder mSucessDialog;
	
	private Timer mTimer = new Timer();
	private boolean mIsPlaying;
	private Vibrator mVibrator;
	private Piece mSelectPiece;
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case MSG_UPDATE_TIMER:
				if (mShowTime != null) {
					mShowTime.setText("剩余时间：" + mGameTime);
					mGameTime--;
					if (mGameTime < 0) {
						Log.d(TAG, "time out ....");
						stopTimer();
						mIsPlaying = false;
						mLostDialog.show();
						return;
					}
				}
				break;
			default:
				Log.d(TAG, "handleMessage inter default case.");
				break;
			}
		}
		
	};
	
}
