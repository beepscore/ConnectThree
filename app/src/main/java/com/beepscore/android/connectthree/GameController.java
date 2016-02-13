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

}
