package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alarm_layout);
        Intent intent = getIntent();

        //Spyridon
        final Intent mathGameIntent = new Intent(this, MathGame.class);
        Button mathGameBTN = findViewById(R.id.mathgameAct);
        mathGameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mathGameIntent);

            }
        });



        //Ben
        final Intent puzzleIntent = new Intent(this, PicturePuzzle.class);
        Button puzzleBTN = findViewById(R.id.puzzleBTN);
        puzzleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(puzzleIntent);
            }
        });


        //Seth



        //Eli
        final Intent javelinIntent = new Intent(this, JavelinActivity.class);
        Button javelinBTN = findViewById(R.id.javelinBTN);
        javelinBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(javelinIntent);
            }
        });

    }
}
