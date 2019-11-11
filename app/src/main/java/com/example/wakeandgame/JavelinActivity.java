package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
        final int height = size.y;

            final ObjectAnimator translateX = ObjectAnimator.ofFloat(characterIV, "translationX", -400f, width+400f);
            final ObjectAnimator translateY = ObjectAnimator.ofFloat(characterIV, "translationY", 300f, height*(-1)-400f);
            translateX.setRepeatCount(ValueAnimator.INFINITE);
            translateY.setRepeatCount(ValueAnimator.INFINITE);

            final AnimatorSet setX = new AnimatorSet();
            setX.setDuration(2000);
            setX.play(translateX);
            setX.start();

            final AnimatorSet setY = new AnimatorSet();

            screenBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float getX = 0;
                    float getY = 0;
                    numClicks ++;
                    if(numClicks == 1) {
                        Log.d("Animation", "numClicks is 1");
                        Log.d("Animation", "getX():" + characterIV.getX());
                        getX = characterIV.getX();

                        setX.end();

                        characterIV.setX(getX);

                        setY.setDuration(2000);
                        setY.play(translateY);
                        setY.start();
                    }
                    else if(numClicks == 2){
                        Log.d("Animation", "numClicks is 2");
                        Log.d("Animation", "getY():" + characterIV.getY());

                        getY = characterIV.getY();

                        setY.end();

                        characterIV.setY(getY);

                        Log.d("Animation", "Velocity of throw: " + findVelocity(getX, getY));
                        Log.d("Animation", "Trajectory of throw: " + findTrajectory(characterIV.getX(), characterIV.getY()));

                    }

                }
            });

    }

    public double findVelocity(double getX, double getY){

        ImageView characterIV = findViewById(R.id.characterIV);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double height = size.y;

        double velocity = Math.sqrt(Math.pow((height - characterIV.getY()), 2) + Math.pow(characterIV.getX(), 2));

        return velocity;
    }

    public double findTrajectory(double getX, double getY){

        ImageView characterIV = findViewById(R.id.characterIV);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double height = size.y;

        Log.d("Animation", "Opposite is: " + (height - characterIV.getY()));
        Log.d("Animation", "Adjacent is: " + characterIV.getX());

        double trajectory = Math.atan((height - characterIV.getY())/characterIV.getX());

        return trajectory;
    }

}
