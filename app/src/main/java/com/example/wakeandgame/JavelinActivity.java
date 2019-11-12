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

        //Getting screen sizes to manipulate the current screen state
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        final int height = size.y;

        //Creating ObjectAnimator for managing its translation affects
        final ObjectAnimator translateX = ObjectAnimator.ofFloat(characterIV, "translationX", -400f, width+400f);
        final ObjectAnimator translateY = ObjectAnimator.ofFloat(characterIV, "translationY", 300f, height*(-1)-400f);
        translateX.setRepeatCount(ValueAnimator.INFINITE);
        translateY.setRepeatCount(ValueAnimator.INFINITE);

        //Setting the AnimatorSet's to manage animation direction and speed
        final AnimatorSet setX = new AnimatorSet();
        final AnimatorSet setY = new AnimatorSet();
        setX.setDuration(2000);
        setX.play(translateX);
        setX.start();

        //Full screen button that will handle the number of clicks and the relevant change in direction
        screenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Values for grabbing the location of the object once screen is clicked
                double getX = 0;
                double getY = 0;

                //Button has been clicked if onClick() has been activated so increment one
                numClicks ++;

                /*
                if clicked once{
                    get characterIV current x-position,
                    end translation on x-axis,
                    set characterIV x location to current position captured,
                    begin translation on y-axis
                }
                 */
                if(numClicks == 1) {
                    Log.d("Animation", "numClicks is 1");
                    Log.d("Animation", "getX():" + characterIV.getX());
                    getX = characterIV.getX();

                    setX.end();

                    characterIV.setX((float)getX);

                    setY.setDuration(2000);
                    setY.play(translateY);
                    setY.start();
                }

                /*
                else if clicked a second time{
                    get characterIV current y-position,
                    end translation on y-axis,
                    set characterIV y location to current position captured
                }
                 */

                else if(numClicks == 2){
                    Log.d("Animation", "numClicks is 2");
                    Log.d("Animation", "getY():" + characterIV.getY());

                    getY = characterIV.getY();

                    setY.end();

                    characterIV.setY((float)getY);

                    Log.d("Animation", "Velocity of throw: " + findVelocity(characterIV.getX(), characterIV.getY()));
                    Log.d("Animation", "Trajectory of throw: " + Math.toDegrees(findTrajectory(characterIV.getX(), characterIV.getY())));
                    Log.d("Animation", "Distance of throw: " + distance(findVelocity(characterIV.getX(), characterIV.getY()),
                            Math.toDegrees(findTrajectory(characterIV.getX(), characterIV.getY())), (height - characterIV.getY())));

                }

            }
        });

    }

    /*
    Using the characterIV coordinate (as the parameters) and phone display, get the location of the image and use
    the pythagorean theorem to get the length of the hypotenuse, of which will also
    be treated as its magnitude, therefore capturing the strength and distance of
    initial throw, creating a velocity of the throw itself.
     */

    public double findVelocity(double getX, double getY){

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double height = size.y;

        double velocity = Math.sqrt(Math.pow((height - getY), 2) + Math.pow(getX, 2));

        return velocity;
    }

    /*
    Using characterIV coordinate (as the parameters) and the phone display, use the coordinates to
    find the angle of trajectory by taking the arctangent of getY/getX
     */

    public double findTrajectory(double getX, double getY){

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double height = size.y;

        Log.d("Animation", "Opposite is: " + (height - getY));
        Log.d("Animation", "Adjacent is: " + getX);

        double trajectory = Math.atan((height - getY)/getX);

        return trajectory;
    }

    public double distance(double velocity, double angle, double height){

        double gravity = 9.81;

        return velocity * Math.cos(angle)*(velocity*Math.sin(angle) + (Math.sqrt(
                (Math.pow(velocity, 2)*Math.pow(Math.sin(angle), 2)) + (2*height*gravity)))/gravity);
    }

}
