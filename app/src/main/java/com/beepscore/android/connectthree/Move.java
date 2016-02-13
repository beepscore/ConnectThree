package com.beepscore.android.connectthree;

/**
 * Created by stevebaker on 2/12/16.
 */

public class Move {

    public final String player;
    public final int row;
    public final int column;

    // TODO: Consider add timeStamp
    /**
     * timeStamp in iso 8601 format
     */
    //public final String timestampIso8601;

    // constructor
    public Move(String player, int row, int column) {
        this.player = player;
        this.row = row;
        this.column = column;
    }

}
