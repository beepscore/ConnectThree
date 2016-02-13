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
}
