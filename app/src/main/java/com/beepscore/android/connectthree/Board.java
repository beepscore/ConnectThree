package com.beepscore.android.connectthree;

/**
 * Created by stevebaker on 2/12/16.
 */
public class Board {

    final int numberOfRows;
    final int numberOfColumns;
    // On the board, each row, column position may be null
    BoardPiece [][] boardPieces;

    // constructor
    // must initialize any final fields here, can't set them later
    public Board(final int numberOfRows, final int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        boardPieces = new BoardPiece [numberOfRows][numberOfColumns] ;
    }
}
