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
}