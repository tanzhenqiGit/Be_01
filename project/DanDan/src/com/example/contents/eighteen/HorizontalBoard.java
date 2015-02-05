package com.example.contents.eighteen;

import java.util.ArrayList;
import java.util.List;

public class HorizontalBoard extends AbstractBoard {

	@Override
	protected List<Piece> createPiece(GameConf config, Piece[][] pieces) {
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				
				if (j % 2 == 0) {
					Piece piece = new Piece(i, j);
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}

}
