package com.beepscore.android.connectthree;

import android.media.Image;

/**
 * Created by stevebaker on 2/12/16.
 */
public class BoardPiece {

    public final String boardPieceId;
    public final Image image;

    // constructor
    public BoardPiece(String boardPieceId, Image image) {
        this.boardPieceId = boardPieceId;
        this.image = image;
    }
}
