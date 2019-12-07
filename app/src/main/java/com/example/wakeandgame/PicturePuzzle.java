package com.example.wakeandgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PicturePuzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.picture_puzzle);

        //Intent intent = getIntent();

        final ArrayList<String> mathCategory = new ArrayList<>();
        ArrayList<String> videoGameCategory = new ArrayList<>();
        ArrayList<String> codingCategory = new ArrayList<>();
        ArrayList<String> moviesCategory = new ArrayList<>();

        mathCategory.add("What is the next prime number after 7?");
        mathCategory.add("What is the square root of 144?");
        mathCategory.add("What is the result of 3 squared?");
        mathCategory.add("What is a polygon with 7 sides called?");
        mathCategory.add("What does the roman numeral 'C' represent?");

        videoGameCategory.add("What year was the Playstation 1 released?");
        videoGameCategory.add("What is the name of the final course in all of the 'Mario Cart' games?");
        videoGameCategory.add("");


        Button category1 = findViewById(R.id.category1);
        Button category2 = findViewById(R.id.category2);
        Button category3 = findViewById(R.id.category3);
        Button category4 = findViewById(R.id.category4);

        final Button answer1 = findViewById(R.id.answer1);
        final Button answer2 = findViewById(R.id.answer2);
        final Button answer3 = findViewById(R.id.answer3);
        final Button answer4 = findViewById(R.id.answer4);

        final TextView question = findViewById(R.id.question);
        TextView questionTV = findViewById(R.id.questionTV);
        final TextView scoreTV = findViewById(R.id.scoreTV);

        final boolean[] cat1 = {false};
        final boolean[] cat2 = {false};
        final boolean[] cat3 = {false};
        final boolean[] cat4 = {false};

        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat1[0] = true;
                question.setText(mathCategory.get(0));

                if(cat1[0] == true) {
                    answer1.setText("one test");
                    answer2.setText("two test");
                    answer3.setText("three test");
                    answer4.setText("four test");
                }

                answer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        scoreTV.setText("SCORE: 1/10");
                    }
                });
            }
        });



        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat2[0] = true;
            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat3[0] = true;
            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat4[0] = true;
            }
        });


    }
}
