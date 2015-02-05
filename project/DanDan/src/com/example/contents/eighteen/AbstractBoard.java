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
		List<Piece> notNullPieces = createPiece(config, pieces); 
		
		List<PieceImage> playImages = 
				ImageUtil.getPlayImages(config.getmContext(), notNullPieces.size());
		
		int imageWidth = playImages.get(0).getmImage().getWidth();
		int imageHeight = playImages.get(0).getmImage().getHeight();
		
		for (int i = 0; i < notNullPieces.size(); i++) {
			Piece piece = notNullPieces.get(i);
			piece.setmImage(playImages.get(i));
			piece.setmBeginX(piece.getmIndexX() * imageWidth + config.getmBeginImageX());
			piece.setmBeginY(piece.getmIndexY() * imageHeight + config.getmBeginImageY());
			pieces[piece.getmIndexX()][piece.getmIndexY()] = piece;
		}
		
		return pieces;
	}
}
