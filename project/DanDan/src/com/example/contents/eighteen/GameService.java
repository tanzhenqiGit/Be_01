package com.example.contents.eighteen;

public interface GameService {

	/*
	 * control game start.
	 */
	void start();
	/*
	 * 
	 * @return a array contain Pieces
	 */
	Piece[][] getPieces();
	
	/*
	 *
	 */
	boolean hasPieces();
	
	/*
	 * 
	 */
	Piece findPiece(float touchX, float touchY);
	
	/*
	 * 
	 */
	LinkInfo link(Piece p1, Piece p2);
}
