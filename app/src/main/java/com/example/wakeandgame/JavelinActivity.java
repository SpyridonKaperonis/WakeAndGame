package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class JavelinActivity extends AppCompatActivity {

    private int locationX;
    private int locationY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.javelin_layout);

        Intent intent = getIntent();
        final ImageView characterIV = findViewById(R.id.characterIV);

        //Attempting to create an event where I slide the image in order to calculate
        //an angle for the javelin throw itself

        characterIV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int x = (int)motionEvent.getRawX();
                final int y = (int)motionEvent.getRawY();

                switch(motionEvent.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();

                        locationX = x - layoutParams.leftMargin;
                        locationY = y - layoutParams.topMargin;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        ConstraintLayout.LayoutParams layoutP = (ConstraintLayout.LayoutParams)view.getLayoutParams();

                        layoutP.leftMargin = x - locationX;
                        layoutP.bottomMargin = locationY - y;
                        layoutP.rightMargin = 0;
                        layoutP.topMargin = 0;

                        characterIV.setLayoutParams(layoutP);
                        break;

                    case MotionEvent.ACTION_UP:

                        break;

                    default:
                        break;
                }
                return true;
            }
        });

    }
}
