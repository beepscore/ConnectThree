package com.beepscore.android.connectthree;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by stevebaker on 2/12/16.
 */
public class BoardPiece {

    public final String boardPieceId;
    public final Drawable drawable;

    // constructor
    public BoardPiece(String boardPieceId, Drawable drawable) {
        this.boardPieceId = boardPieceId;
        this.drawable = drawable;
    }

    public String toString() {
        return boardPieceId;
    }

}
