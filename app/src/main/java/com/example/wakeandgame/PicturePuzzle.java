package com.example.wakeandgame;

import android.content.Intent;
import android.os.Bundle;
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

        ArrayList<String> mathCategory = new ArrayList<>();
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

        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);
        Button answer4 = findViewById(R.id.answer4);

        TextView question = findViewById(R.id.question);

    }
}
