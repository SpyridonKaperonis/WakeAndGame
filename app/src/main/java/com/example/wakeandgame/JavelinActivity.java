package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class JavelinActivity extends AppCompatActivity {

    private int numClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.javelin_layout);

        Intent intent = getIntent();
        final ImageView characterIV = findViewById(R.id.characterIV);
        final Button screenBTN = findViewById(R.id.screenBTN);

        //Attempting to create an event where I slide the image in order to calculate
        //an angle for the javelin throw itself

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int imageWidth = (characterIV.getWidth())*-1;

        final Animation animationX = new TranslateAnimation(-400, width, 0, 0);
        animationX.setDuration(2000);
        animationX.setRepeatMode(Animation.RELATIVE_TO_SELF);
        animationX.setRepeatCount(Animation.INFINITE);
        characterIV.setAnimation(animationX);

        screenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(numClicks >= 1){
                    screenBTN.setVisibility(View.INVISIBLE);
                }
                else{
                    switch (numClicks){
                        case 0:
                            numClicks++;
                            characterIV.clearAnimation();
                            Log.d("Animation", "case 0 hit: numClicks updated, animation cleared");
                            break;
                        default:
                            break;
                    }


                }
            }
        });

    }
}
