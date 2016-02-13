package com.beepscore.android.connectthree;

/**
 * Created by stevebaker on 2/12/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Game is a model of the game, including each player's moves.
 */
public class Game {

    // final makes fields act like "read only" properties
    // http://binkley.blogspot.com/2005/01/read-only-properties-in-java.html
    final Board board;
    final List<Player> players;

    // Chess games are recorded as a list of moves, so use it for tic-tac-toe.
    // Also can use it to see who gets to move next.
    // YAGNI? allows for animated playback
    List<Move> moves = new ArrayList<Move>();

    // constructor
    // must initialize any final fields here, can't set them later
    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

}
