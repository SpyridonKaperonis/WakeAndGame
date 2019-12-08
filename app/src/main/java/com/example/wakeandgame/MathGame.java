package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MathGame extends AppCompatActivity {



    private int num1;
    private int num2;
    private int maximum;
    private int minimum;
    private int answer;
    private String questionGen;
    private int correctans;
    private int mistakes;
    private int addscore;


    private int countClick;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_layout);


        countClick = 0;
        minimum = 0;
        maximum = 10;

        final Thread thread = new Thread(){
            final TextView timedisplay = findViewById(R.id.countTime);
            int seconds = 0;
            @Override
            public void run () {
                while(!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                seconds++;

                                timedisplay.setText(String.valueOf(seconds));
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();


        Button submit = findViewById(R.id.btnSub);
        Button nextQ = findViewById(R.id.nextQuestion);
        Button reset = findViewById(R.id.resetBtn);




        generator(maximum);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checker();
                toasts();
                generator(maximum);
                minimum = minimum +8;
                maximum = maximum +8;

            }
        });

        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generator(maximum);
                minimum = minimum +8;
                maximum = maximum +8;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });






    }
    //Random numbers generator
    public void generator(int maximum){
        this.maximum = maximum;
        Random randnumber = new Random();

        num1 = randnumber.nextInt(maximum)+minimum;
        num2 = randnumber.nextInt(maximum)+minimum;
        answer = num1 + num2;



        questionGen = num1 + " + " + num2 ;


        TextView questionT = findViewById(R.id.questionTV);
        questionT.setText(questionGen);



    }

    public void toasts(){
        if(mistakes > correctans){
            Toast.makeText(getApplicationContext(), "You can do better", Toast.LENGTH_SHORT).show();
        }else if(correctans > 5){
            String [] phrases = {"Yeah", "Vamos", "You got this","Let's go"};
            String randomphrase = phrases[new Random().nextInt(phrases.length)];
            Toast toast =Toast.makeText(getApplicationContext(),  randomphrase, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
            toast.show();



        }
    }
    public void checker(){

        EditText input = findViewById(R.id.submition);
        String number = input.getText().toString();
        //int output = Integer.parseInt(number);
        if(number.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
            toast.show();
            minimum =0;
            maximum =10;
            return;
        }

        else if(answer ==Integer.parseInt(number)) {
            correctans++;
            addscore = addscore + 10;
            TextView score = findViewById(R.id.scoreCount);
            score.setText(Integer.toString(addscore));
            input.getText().clear();
            // Toast.makeText(getApplicationContext(),"Holaaaa", Toast.LENGTH_LONG).show();

        }else{
            mistakes++;
            addscore = addscore -10;
            TextView score =findViewById(R.id.scoreCount);
            score.setText(Integer.toString(addscore));
            input.getText().clear();
            // Toast.makeText(getApplicationContext(),"Nooooo", Toast.LENGTH_LONG).show();
        }

    }



    public void reset(){

        addscore = 0;
        correctans =0;
        mistakes = 0;
        TextView score =findViewById(R.id.scoreCount);
        score.setText(Integer.toString(addscore));
        minimum = 0;
        maximum = 10;
        generator(maximum);
    }









}
