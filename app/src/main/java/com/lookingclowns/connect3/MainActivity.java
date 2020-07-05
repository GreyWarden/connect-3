package com.lookingclowns.connect3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SHORT_DURATION = 300;
    // RED = 0, YELLOW = 1
    private int ACTIVE_PLAYER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int counterTag = Integer.parseInt(counter.getTag().toString());

//        if (gameState[counterTag] != -1 && gameState[counterTag] != ACTIVE_PLAYER ) {
//            Toast.makeText(this, "The spot is already taken", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (gameState[counterTag] != -1 && gameState[counterTag] == ACTIVE_PLAYER) {
//            Toast.makeText(this, "You already chose that spot", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        gameState[counterTag] = ACTIVE_PLAYER;
        counter.setImageResource(this.getCounterSrc());
        counter.setTranslationY(-500);
        counter.animate().translationYBy(500).rotation(3600).setDuration(SHORT_DURATION);
        this.changeActivePlayer();
    }

    private int getCounterSrc() {
        return ACTIVE_PLAYER == 0 ? R.drawable.red : R.drawable.yellow;
    }

    private void changeActivePlayer() {
        ACTIVE_PLAYER = ACTIVE_PLAYER == 0 ? 1 : 0;
    }
}