package com.beepscore.android.connectthree;

/**
 * Created by stevebaker on 2/12/16.
 */
public class GameController {

    Game game;

    // constructor
    // must initialize any final fields here, can't set them later
    public GameController(Game game) {
        this.game = game;
    }

    boolean isBoardFull(Game game) {
        // Use game.moves
        // This is more efficient than looping through game.board rows and columns
        if (game.moves.size() < (game.board.numberOfRows * game.board.numberOfColumns)) {
            return false;
        } else
            return true;
    }

    static boolean isGameWonInAnyColumn(Board board) {

        for (int rowNumber = 0; rowNumber < board.numberOfRows; rowNumber++) {
            if (isGameWonInColumn(board, rowNumber)) {
                return true;
            }
        }
        return false;
    }

    static boolean isGameWonInColumn(Board board, int columnNumber) {

        BoardPiece boardPiece0 = board.boardPieces[0][columnNumber];
        for (int rowNumber = 0; rowNumber < board.numberOfRows; rowNumber++) {
            BoardPiece currentBoardPiece = board.boardPieces[rowNumber][columnNumber];
            if (currentBoardPiece == null) {
                return false;
            }
            if (currentBoardPiece != boardPiece0) {
                return false;
            }
        }
        return true;
    }

    static boolean isGameWonInRow(Board board, int rowNumber) {

        BoardPiece boardPiece0 = board.boardPieces[rowNumber][0];
        for (int columnNumber = 0; columnNumber < board.numberOfColumns; columnNumber++) {
            BoardPiece currentBoardPiece = board.boardPieces[rowNumber][columnNumber];
            if (currentBoardPiece == null) {
                return false;
            }
            if (currentBoardPiece != boardPiece0) {
                return false;
            }
        }
        return true;
    }

}
