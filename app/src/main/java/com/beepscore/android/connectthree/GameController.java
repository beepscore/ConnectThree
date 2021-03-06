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

    static boolean canMove(Board board, int row, int column) {

            BoardPiece boardPiece = board.boardPieces[row][column];
            if (boardPiece == null) {
                return true;
            } else {
                return false;
            }
    }

    boolean isBoardFull(Game game) {
        // Use game.moves
        // This is more efficient than looping through game.board rows and columns
        if (game.moves.size() < (game.board.numberOfRows * game.board.numberOfColumns)) {
            return false;
        } else
            return true;
    }

    static boolean isGameWon(Board board) {

        if (isGameWonInAnyColumn(board)
                || isGameWonInAnyRow(board)
                || isGameWonInAnyDiagonal(board)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isGameWonInAnyColumn(Board board) {

        for (int columnNumber = 0; columnNumber < board.numberOfColumns; columnNumber++) {
            if (isGameWonInColumn(board, columnNumber)) {
                return true;
            }
        }
        return false;
    }

    static boolean isGameWonInAnyRow(Board board) {

        for (int rowNumber = 0; rowNumber < board.numberOfRows; rowNumber++) {
            if (isGameWonInRow(board, rowNumber)) {
                return true;
            }
        }
        return false;
    }

    static boolean isGameWonInAnyDiagonal(Board board) {

        if (isGameWonInDiagonalSlopeNegative(board)
                || isGameWonInDiagonalSlopePositive(board)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isGameWonInColumn(Board board, int columnNumber) {

        BoardPiece boardPiece0 = board.boardPieces[0][columnNumber];
        // loop does one unnecessary revisit of boardPiece0.
        // However loop indices are clear to programmer, so don't optimize further.
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

    /**
     * Assumes board is square, numberOfRows == numberOfColumns
     * @param board
     * @return true if diagonal from 0,0 to numberOfRows, numberOfColumns
     * contains boardPieces from a single player
     */
    static boolean isGameWonInDiagonalSlopeNegative(Board board) {

        BoardPiece boardPiece0 = board.boardPieces[0][0];
        for (int index = 0; index < board.numberOfRows; index++) {
            BoardPiece currentBoardPiece = board.boardPieces[index][index];
            if (currentBoardPiece == null) {
                return false;
            }
            if (currentBoardPiece != boardPiece0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Assumes board is square, numberOfRows == numberOfColumns
     * @param board
     * @return true if diagonal from 0, numberOfColumns to numberOfRows, 0
     * contains boardPieces from a single player
     */
    static boolean isGameWonInDiagonalSlopePositive(Board board) {

        int columnNumberMaximum = board.numberOfColumns - 1;
        BoardPiece boardPiece0 = board.boardPieces[0][columnNumberMaximum];
        for (int index = 0; index < board.numberOfRows; index++) {
            int row = index;
            int column = columnNumberMaximum - index;
            BoardPiece currentBoardPiece = board.boardPieces[row][column];
            if (currentBoardPiece == null) {
                return false;
            }
            if (currentBoardPiece != boardPiece0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add move at row, column.
     * Assumes move is available.
     * @param playerId
     * @param row
     * @param column
     */
    void addMove(String playerId, int row, int column) {
        Move move = new Move(playerId, row, column);
        game.moves.add(move);
        game.board.boardPieces[row][column] = game.currentPlayer.boardPiece;
    }

    void toggleCurrentPlayer() {
        if (game.currentPlayer == game.players.get(0)) {
            game.currentPlayer = game.players.get(1);
        } else {
            game.currentPlayer = game.players.get(0);
        }
    }

}
