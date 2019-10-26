package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_layout);

        final Intent home = new Intent(this, MainActivity.class);

        Button mathBTNHome = findViewById(R.id.mathGameNav);
        mathBTNHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);


            }

        });




}
}
