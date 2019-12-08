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

    }

    //Random numbers generator
    public void generator(int maximum) {
        this.maximum = maximum;
        Random randnumber = new Random();

        num1 = randnumber.nextInt(maximum) + minimum;
        num2 = randnumber.nextInt(maximum) + minimum;
        answer = num1 + num2;


        questionGen = num1 + " + " + num2;


        TextView questionT = findViewById(R.id.questionTV);
        questionT.setText(questionGen);


    }

    public void checker() {

        EditText input = findViewById(R.id.submition);
        String number = input.getText().toString();
        //int output = Integer.parseInt(number);
        if (number.matches("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
            toast.show();
            minimum = 0;
            maximum = 10;
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
            // Toast.makeText(getApplicationContext(),"Nooooo", Toast.LENGTH_LONG).show();
        }


    }
}