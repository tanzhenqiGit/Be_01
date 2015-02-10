package com.example.contents.eighteen;

import java.util.ArrayList;
import java.util.List;

public class FullBoard extends AbstractBoard {

	@Override
	protected List<Piece> createPiece(GameConf config, Piece[][] pieces) {
		List<Piece> notNUllPieces = new ArrayList<Piece>();
		for (int i = 1; i < pieces.length - 1; i++) {
			for (int j = 1; j < pieces[i].length - 1; j++) {
				Piece piece = new Piece(i, j);
				notNUllPieces.add(piece);
			}
		}
		return notNUllPieces;
	}

}
