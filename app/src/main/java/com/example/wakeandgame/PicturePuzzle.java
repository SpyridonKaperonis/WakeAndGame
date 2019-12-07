package com.example.wakeandgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PicturePuzzle extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreTV;
    private TextView mQuestion;
    private Button mChoice1BTN;
    private Button mChoice2BTN;
    private Button mChoice3BTN;
    private Button mChoice4BTN;
    private Button mCat1;
    private Button mCat2;
    private Button mCat3;
    private Button mCat4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNum = 0;
    private int category = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.picture_puzzle);

        mScoreTV = (TextView)findViewById(R.id.scoreTV);
        mQuestion = (TextView)findViewById(R.id.question);
        mChoice1BTN = (Button)findViewById(R.id.answer1);
        mChoice2BTN = (Button)findViewById(R.id.answer2);
        mChoice3BTN = (Button)findViewById(R.id.answer3);
        mChoice4BTN = (Button)findViewById(R.id.answer4);
        mCat1 = (Button)findViewById(R.id.category1);
        mCat2 = (Button)findViewById(R.id.category2);
        mCat3 = (Button)findViewById(R.id.category3);
        mCat4 = (Button)findViewById(R.id.category4);

        mCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = 1;
                updateQuestionMath();
            }
        });

        mCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = 2;
                updateQuestionVG();
            }
        });

        mChoice1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1BTN.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }


                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }
                }
            }
        });

        mChoice2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice2BTN.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }

                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }
                }
            }
        });

        mChoice3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice3BTN.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }

                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }
                }
            }
        });

        mChoice4BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice4BTN.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }

                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    if(category == 1) {
                        updateQuestionMath();
                    } else if(category == 2) {
                        updateQuestionVG();
                    }
                }
            }
        });

    }

    private void updateQuestionMath() {
        mQuestion.setText(mQuestionLibrary.getQuestionMath(mQuestionNum));
        mChoice1BTN.setText(mQuestionLibrary.getChoice1Math(mQuestionNum));
        mChoice2BTN.setText(mQuestionLibrary.getChoice2Math(mQuestionNum));
        mChoice3BTN.setText(mQuestionLibrary.getChoice3Math(mQuestionNum));
        mChoice4BTN.setText(mQuestionLibrary.getChoice4Math(mQuestionNum));

        mAnswer = mQuestionLibrary.getCorrectMath(mQuestionNum);
        mQuestionNum++;
    }

    private void updateQuestionVG() {
        mQuestion.setText(mQuestionLibrary.getQuestionVG(mQuestionNum));
        mChoice1BTN.setText(mQuestionLibrary.getChoice1VG(mQuestionNum));
        mChoice2BTN.setText(mQuestionLibrary.getChoice2VG(mQuestionNum));
        mChoice3BTN.setText(mQuestionLibrary.getChoice3VG(mQuestionNum));
        mChoice4BTN.setText(mQuestionLibrary.getChoice4VG(mQuestionNum));

        mAnswer = mQuestionLibrary.getCorrectVG(mQuestionNum);
        mQuestionNum++;
    }

    private void updateScore(int point) {
        mScoreTV.setText("SCORE: " + mScore + "/10");
    }


}
