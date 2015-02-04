package com.example.contents.eighteen;

import java.util.List;

import android.util.Log;

public abstract class AbstractBoard {
	protected abstract List<Piece> createPiece(GameConf config, Piece[][] pieces);
	private final String TAG = "AbstractBoard";
	public Piece[][] create(GameConf config)
	{
		if (config == null) {
			Log.e(TAG, "config == null");
			return null;
		}
		Piece[][] pieces = new Piece[config.getmXSize()][config.getmYSize()];
		//List<PieceImage> playImages = 
		
		return pieces;
	}
}
