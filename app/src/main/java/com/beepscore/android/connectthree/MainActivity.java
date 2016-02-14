package com.beepscore.android.connectthree;

import android.graphics.drawable.Drawable;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Use Drawable. Alternatively, could use resource
    // http://stackoverflow.com/questions/9774705/setimageresource-vs-setdrawable
    Drawable mBoardPieceDrawableO;
    Drawable mBoardPieceDrawableX;
    GameController mGameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBoardPieceDrawableO = getDrawable(R.drawable.o);
        mBoardPieceDrawableX = getDrawable(R.drawable.x);

        final int numberOfRows = 3;
        final int numberOfColumns = 3;
        Board board = new Board(numberOfRows, numberOfColumns);

        List<Player> players = getConfiguredPlayers();

        Game game = new Game(board, players);
        mGameController = new GameController(game);
    }

    List<Player> getConfiguredPlayers() {
        List<Player> players = new ArrayList<Player>();
        BoardPiece boardPieceMoe = new BoardPiece("boardPieceMoe", mBoardPieceDrawableO);
        Player playerMoe = new Player("Moe", boardPieceMoe);
        players.add(playerMoe);

        BoardPiece boardPieceLarry = new BoardPiece("boardPieceLarry", mBoardPieceDrawableX);
        Player playerLarry = new Player("Larry", boardPieceLarry);
        players.add(playerLarry);
        return players;
    }

    public void onButtonClick(View view) {
        ImageButton imageButton = (ImageButton) view;

        Pair<Integer, Integer> buttonCoordinates = getButtonCoordinates(view);
        int row = buttonCoordinates.first.intValue();
        int column = buttonCoordinates.second.intValue();

        if (!GameController.isGameWon(mGameController.game.board)
                && GameController.canMove(mGameController.game.board, row, column)) {
            mGameController.addMove(mGameController.game.currentPlayer.playerId,
                    row, column);
            imageButton.setImageDrawable(mGameController.game.currentPlayer.boardPiece.drawable);
            if (GameController.isGameWon(mGameController.game.board)) {
                Log.i("onButtonClick", "Game won");
                Toast.makeText(getApplicationContext(), "Game won", Toast.LENGTH_LONG).show();
            } else if (mGameController.isBoardFull(mGameController.game)) {
                Log.i("onButtonClick", "Game is a draw");
                Toast.makeText(getApplicationContext(), "Game is a draw", Toast.LENGTH_LONG).show();
            } else {
                mGameController.toggleCurrentPlayer();
                Toast.makeText(getApplicationContext(), "currentPlayer " +
                        mGameController.game.currentPlayer.playerId, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * @return a Pair of row, column
     */
    Pair<Integer, Integer> getButtonCoordinates(View view) {

        int row = 0;
        int column = 0;

        switch(view.getId()) {
            case R.id.imageButton00: {
                row = 0;
                column = 0;
                break;
            }
            case R.id.imageButton01: {
                row = 0;
                column = 1;
                break;
            }
            case R.id.imageButton02: {
                row = 0;
                column = 2;
                break;
            }
            case R.id.imageButton10: {
                row = 1;
                column = 0;
                break;
            }
            case R.id.imageButton11: {
                row = 1;
                column = 1;
                break;
            }
            case R.id.imageButton12: {
                row = 1;
                column = 2;
                break;
            }
            case R.id.imageButton20: {
                row = 2;
                column = 0;
                break;
            }
            case R.id.imageButton21: {
                row = 2;
                column = 1;
                break;
            }
            case R.id.imageButton22: {
                row = 2;
                column = 2;
                break;
            }
        }
        return Pair.create(row, column);
    }

}
