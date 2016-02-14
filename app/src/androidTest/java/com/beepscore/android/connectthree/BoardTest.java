package com.beepscore.android.connectthree;

        import android.app.Application;
        import android.test.ApplicationTestCase;

/**
 * Created by stevebaker on 2/13/16.
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class BoardTest extends ApplicationTestCase<Application> {

    public BoardTest() {
        super(Application.class);
    }

    public void testToStringEmpty() {
        Board board = new Board(3, 3);
        String expected = "[0][0] null" + System.lineSeparator()
                + "[0][1] null" + System.lineSeparator()
                + "[0][2] null" + System.lineSeparator()
                + "[1][0] null" + System.lineSeparator()
                + "[1][1] null" + System.lineSeparator()
                + "[1][2] null" + System.lineSeparator()
                + "[2][0] null" + System.lineSeparator()
                + "[2][1] null" + System.lineSeparator()
                + "[2][2] null" + System.lineSeparator();
        assertTrue(board.toString().equals(expected));
    }

    public void testToString() {
        Board board = new Board(3, 3);
        board.boardPieces[2][1] = new BoardPiece("foo", null);
        String expected = "[0][0] null" + System.lineSeparator()
                + "[0][1] null" + System.lineSeparator()
                + "[0][2] null" + System.lineSeparator()
                + "[1][0] null" + System.lineSeparator()
                + "[1][1] null" + System.lineSeparator()
                + "[1][2] null" + System.lineSeparator()
                + "[2][0] null" + System.lineSeparator()
                + "[2][1] foo" + System.lineSeparator()
                + "[2][2] null" + System.lineSeparator();
        assertTrue(board.toString().equals(expected));
    }

}
