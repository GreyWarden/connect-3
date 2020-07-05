package com.lookingclowns.connect3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lookingclowns.connect3.application.usecase.gamestatus.GameStatus;
import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

public class MainActivity extends AppCompatActivity {

    private static final long SHORT_DURATION = 300;
    private GameStatus gameStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameStatus = new GameStatus(new GameBoard());
    }

    public void dropIn(View view) {
        if (gameStatus.isGameFinished()) {
            return;
        }

        ImageView counter = (ImageView) view;
        int counterTag = Integer.parseInt(counter.getTag().toString());

        try {
            this.gameStatus.addToken(counterTag);
        } catch (PlayerIsNotAllowedException playerIsNotAllowed) {
            Log.d("Error", "Error que no se esperaba porque no se debería dar");
            return;
        } catch (PositionIsTakenException positionTakenException) {
            Toast.makeText(this, "The spot is already taken", Toast.LENGTH_SHORT)
                    .show();
            return;
        } catch (PositionAlreadySelectedByPlayerException positionAlreadySelectedByPlayerException) {
            Toast.makeText(this, "You already chose that spot", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        counter.setImageResource(this.getCounterSrc(this.gameStatus.getActivePlayer()));
        counter.setTranslationY(-500);
        counter.animate().translationYBy(500).rotation(3600).setDuration(SHORT_DURATION);

        if (gameStatus.isGameFinished()) {
            Button retryButton = findViewById(R.id.retryButton);
            TextView finishedGameText = findViewById(R.id.endGameText);
            finishedGameText.setText(this.createText());
            finishedGameText.setAlpha(1);
            retryButton.setAlpha(1);
        }
    }

    private String createText() {
        if (gameStatus.getWinnerPlayer() == -1) {
            return getResources().getString(R.string.end_game_draw);
        }
        return String.format(
                getResources().getString(R.string.end_game_player_won),
                (gameStatus.getWinnerPlayer() + 1)
        );
    }

    private int getCounterSrc(int activePlayer) {
        return activePlayer == 0 ? R.drawable.red : R.drawable.yellow;
    }

    public void retry(View view) {
        this.gameStatus = new GameStatus(new GameBoard());
        Button retryButton = findViewById(R.id.retryButton);
        TextView finishedGameText = findViewById(R.id.endGameText);
        finishedGameText.setText("");
        finishedGameText.setAlpha(0);
        retryButton.setAlpha(0);
        ((ImageView) findViewById(R.id.firstPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.secondPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.thirdPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.forthPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.fifthPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.sixthPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.seventhPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.eighthPiece)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.ninthPiece)).setImageDrawable(null);
    }
}