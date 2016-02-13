package com.beepscore.android.connectthree;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by stevebaker on 2/12/16.
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class GameControllerTest extends ApplicationTestCase<Application> {

    public GameControllerTest() {
        super(Application.class);
    }

    public void testIsBoardFullMovesEmpty() {
        Board board = new Board(3, 3);
        Game game = new Game(board, null);
        GameController gameController = new GameController(game);

        // check setup
        assertEquals(0, game.moves.size());

        assertFalse(gameController.isBoardFull(game));
    }

    public void testIsBoardFullAlmostfull() {
        Board board = new Board(3, 3);
        Game game = new Game(board, null);
        GameController gameController = new GameController(game);
        game.moves.add(new Move("moe", 0, 0));
        game.moves.add(new Move("larry", 0, 1));
        game.moves.add(new Move("moe", 0, 2));
        game.moves.add(new Move("larry", 1, 0));
        game.moves.add(new Move("moe", 1, 1));
        game.moves.add(new Move("larry", 1, 2));
        game.moves.add(new Move("moe", 2, 0));
        game.moves.add(new Move("larry", 2, 1));

        // check setup
        assertEquals(8, game.moves.size());

        assertFalse(gameController.isBoardFull(game));
    }

    public void testIsBoardFullTrue() {
        Board board = new Board(3, 3);
        Game game = new Game(board, null);
        GameController gameController = new GameController(game);
        game.moves.add(new Move("moe", 0, 0));
        game.moves.add(new Move("larry", 0, 1));
        game.moves.add(new Move("moe", 0, 2));
        game.moves.add(new Move("larry", 1, 0));
        game.moves.add(new Move("moe", 1, 1));
        game.moves.add(new Move("larry", 1, 2));
        game.moves.add(new Move("moe", 2, 0));
        game.moves.add(new Move("larry", 2, 1));
        game.moves.add(new Move("moe", 2, 2));

        // check setup
        assertEquals(9, game.moves.size());

        assertTrue(gameController.isBoardFull(game));
    }

    public void testIsGameWonInAnyColumnBoardEmpty() {
        Board board = new Board(3, 3);

        assertFalse(GameController.isGameWonInAnyColumn(board));
    }

    public void testIsGameWonInAnyColumnFalse() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        BoardPiece boardPieceLarry = new BoardPiece("Larry", null);
        board.boardPieces[0][2] = boardPieceMoe;
        board.boardPieces[1][2] = boardPieceLarry;
        board.boardPieces[2][2] = boardPieceMoe;

        assertFalse(GameController.isGameWonInAnyColumn(board));
    }

    public void testIsGameWonInAnyColumnTrue() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        board.boardPieces[0][1] = boardPieceMoe;
        board.boardPieces[1][1] = boardPieceMoe;
        board.boardPieces[2][1] = boardPieceMoe;

        assertTrue(GameController.isGameWonInAnyColumn(board));
    }

    public void testIsGameWonInAnyRowBoardEmpty() {
        Board board = new Board(3, 3);

        assertFalse(GameController.isGameWonInAnyRow(board));
    }

    public void testIsGameWonInAnyRowFalse() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        BoardPiece boardPieceLarry = new BoardPiece("Larry", null);
        board.boardPieces[2][0] = boardPieceMoe;
        board.boardPieces[2][1] = boardPieceLarry;
        board.boardPieces[2][2] = boardPieceMoe;

        assertFalse(GameController.isGameWonInAnyRow(board));
    }

    public void testIsGameWonInAnyRowTrue() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        board.boardPieces[1][0] = boardPieceMoe;
        board.boardPieces[1][1] = boardPieceMoe;
        board.boardPieces[1][2] = boardPieceMoe;

        assertTrue(GameController.isGameWonInAnyRow(board));
    }

    public void testIsGameWonInColumnBoardEmpty() {
        Board board = new Board(3, 3);

        assertFalse(GameController.isGameWonInColumn(board, 2));
    }

    public void testIsGameWonInColumnFalse() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        BoardPiece boardPieceLarry = new BoardPiece("Larry", null);
        board.boardPieces[0][2] = boardPieceMoe;
        board.boardPieces[1][2] = boardPieceLarry;
        board.boardPieces[2][2] = boardPieceMoe;

        assertFalse(GameController.isGameWonInColumn(board, 0));
    }

    public void testIsGameWonInColumnTrue() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        board.boardPieces[0][1] = boardPieceMoe;
        board.boardPieces[1][1] = boardPieceMoe;
        board.boardPieces[2][1] = boardPieceMoe;

        assertTrue(GameController.isGameWonInColumn(board, 1));
    }

    public void testIsGameWonInRowBoardEmpty() {
        Board board = new Board(3, 3);

        assertFalse(GameController.isGameWonInRow(board, 1));
    }

    public void testIsGameWonInRowFalse() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        BoardPiece boardPieceLarry = new BoardPiece("Larry", null);
        board.boardPieces[2][0] = boardPieceMoe;
        board.boardPieces[2][1] = boardPieceLarry;
        board.boardPieces[2][2] = boardPieceMoe;

        assertFalse(GameController.isGameWonInRow(board, 2));
    }

    public void testIsGameWonInRowTrue() {
        Board board = new Board(3, 3);

        BoardPiece boardPieceMoe = new BoardPiece("Moe", null);
        board.boardPieces[1][0] = boardPieceMoe;
        board.boardPieces[1][1] = boardPieceMoe;
        board.boardPieces[1][2] = boardPieceMoe;

        assertTrue(GameController.isGameWonInRow(board, 1));
    }

}
