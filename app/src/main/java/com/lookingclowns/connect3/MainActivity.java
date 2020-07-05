package com.lookingclowns.connect3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SHORT_DURATION = 300;
    private boolean IS_RED = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int counterSrc = IS_RED ? R.drawable.red : R.drawable.yellow;
        counter.setImageResource(counterSrc);
        counter.setTranslationY(-500);
        counter.animate().translationYBy(500).rotation(3600).setDuration(SHORT_DURATION);
        IS_RED = !IS_RED;
    }
}