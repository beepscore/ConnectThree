package com.beepscore.android.connectthree;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Use Drawable. Alternatively, could use resource
    // http://stackoverflow.com/questions/9774705/setimageresource-vs-setdrawable
    Drawable mBoardPieceDrawableBlank;
    Drawable mBoardPieceDrawableO;
    Drawable mBoardPieceDrawableX;
    final int numberOfRows = 3;
    final int numberOfColumns = 3;
    GameController mGameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureBoardPieceDrawables();
        configureNewGame();
    }

    public void configureBoardPieceDrawables() {
        // Use ContextCompat
        //http://stackoverflow.com/questions/29041027/android-getresources-getdrawable-deprecated-api-22
        mBoardPieceDrawableBlank = ContextCompat.getDrawable(this, R.drawable.blank);
        mBoardPieceDrawableO = ContextCompat.getDrawable(this, R.drawable.o);
        mBoardPieceDrawableX = ContextCompat.getDrawable(this, R.drawable.x);
    }

    public void configureNewGame() {
        Board board = new Board(numberOfRows, numberOfColumns);

        List<Player> players = getConfiguredPlayers();

        Game game = new Game(board, players);
        mGameController = new GameController(game);

        GridLayout boardGridLayout = (GridLayout)findViewById(R.id.boardGridLayout);
        drawBoard(boardGridLayout, game);
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

    /**
     * Draw board to match game current state
     * @param gridLayout
     * @param game
     */
    void drawBoard(GridLayout gridLayout, Game game) {
        // Use dependency-injected argument game.board.numberOfRows in preference to field numberOfRows
        // Use MVC Model board.numberOfRows in preference to MVC View gridLayout.getRowCount()
        for (int row = 0; row < game.board.numberOfRows; row++) {
            for (int column = 0; column < game.board.numberOfColumns; column++) {

                // NOTE: based on logging, childIndex appears to map gridLayout children correctly.
                // If gridLayout children order is not stable, this mapping could fail.
                // So this method might work fine when all images are the same (e.g. blank)
                // but not when some images are different than others.
                int childIndex = (game.board.numberOfColumns * row) + column;
                View childView = gridLayout.getChildAt(childIndex);
                //Log.d("drawBoard", childView.toString());

                ImageButton childImageButton = (ImageButton) childView;
                if (game.board.boardPieces[row][column] == null) {
                    childImageButton.setImageDrawable(mBoardPieceDrawableBlank);
                } else {
                    // NOTE: boardPiece.drawable could be null
                    childImageButton.setImageDrawable(game.board.boardPieces[row][column].drawable);
                }
            }
        }
    }

    public void onClickNewGame(View view) {
        configureNewGame();
    }

    public void onButtonClick(View view) {
        ImageButton imageButton = (ImageButton) view;

        int buttonIndex = Integer.parseInt(imageButton.getTag().toString());
        // integer division truncates
        int row = buttonIndex / numberOfRows;
        int column = buttonIndex % numberOfRows;

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
            }
        }
    }

}
