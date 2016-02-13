package com.beepscore.android.connectthree;

/**
 * Created by stevebaker on 2/12/16.
 */

public class Player {

    public final String playerId;
    public final BoardPiece boardPiece;

    // constructor
    public Player(String playerId, BoardPiece boardPiece) {
        this.playerId = playerId;
        this.boardPiece = boardPiece;
    }

}
