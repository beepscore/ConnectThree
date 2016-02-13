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

    public void testIsBoardFull() {
        Board board = new Board(3, 3);
        Game game = new Game(board, null);
        GameController gameController = new GameController(game);

        assertFalse(gameController.isBoardFull(game));
    }
}
