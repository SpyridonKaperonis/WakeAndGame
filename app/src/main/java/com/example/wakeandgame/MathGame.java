package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MathGame extends AppCompatActivity {

    private int num1;
    private int num2;
    private int question;
    private int count;
    int score =0;
    private int [] answer;
    private String questionGen;
    private int maximum;
    private int minimum;

    private int countClick;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_layout);

        countClick=0;
        minimum = 0;
        maximum = 10;


//        TextView output = findViewById(R.id.scoreCount);
//        output.setText(score);
        Button submit = findViewById(R.id.btnSub);
        Button nextQ = findViewById(R.id.nextQuestion);

        generator(maximum);

        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generator(maximum);
                minimum = minimum +10;
                maximum = maximum +10;
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checker();

            }
        });



}

    public void generator(int maximum){
        this.maximum = maximum;
        Random randomnum = new Random();

        this.num1 = randomnum.nextInt(maximum)+minimum;
        this.num2 = randomnum.nextInt(maximum)+minimum;
        this.question = this.num1 + this.num2;

        this.questionGen = num1 + "+" + num2 ;
        this.score++;

        TextView questionT = findViewById(R.id.questionTV);
        questionT.setText(this.questionGen);


    }

    public void checker(){
        EditText input = findViewById(R.id.submition);
//        String value = input.getText().toString();
//        int valueinput = Integer.parseInt(value);



        if(input.equals(this.question)){
            TextView score = findViewById(R.id.scoreCount);
            String scorein = score.getText().toString();
            int scoreout = Integer.parseInt(scorein);
            int newscore = scoreout + 10;
            score.setText(newscore);

        }else{
            TextView score = findViewById(R.id.scoreCount);
//            this.score = this.score -15;
//            score.setText(this.score);
        }
    }
}
