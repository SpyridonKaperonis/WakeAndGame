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
import androidx.fragment.app.DialogFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PicturePuzzle extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreTV;
    private TextView mQuestion;
    private TextView mQuestionCount;
    private TextView mTitle;
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
    private int mCategory = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.picture_puzzle);

        mScoreTV = (TextView)findViewById(R.id.scoreTV);
        mQuestion = (TextView)findViewById(R.id.question);
        mQuestionCount = (TextView)findViewById(R.id.questionTV);
        mTitle = (TextView)findViewById(R.id.title);
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
                mCategory = 1;
                updateQuestionMath();
                mChoice1BTN.setVisibility(View.VISIBLE);
                mChoice2BTN.setVisibility(View.VISIBLE);
                mChoice3BTN.setVisibility(View.VISIBLE);
                mChoice4BTN.setVisibility(View.VISIBLE);
                mTitle.setText("Math Trivia");
                mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
            }
        });

        mCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategory = 2;
                updateQuestionVG();
                mChoice1BTN.setVisibility(View.VISIBLE);
                mChoice2BTN.setVisibility(View.VISIBLE);
                mChoice3BTN.setVisibility(View.VISIBLE);
                mChoice4BTN.setVisibility(View.VISIBLE);
                mTitle.setText("Video Game Trivia");
                mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
            }
        });

        mCat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategory = 3;
                updateQuestionCoding();
                mChoice1BTN.setVisibility(View.VISIBLE);
                mChoice2BTN.setVisibility(View.VISIBLE);
                mChoice3BTN.setVisibility(View.VISIBLE);
                mChoice4BTN.setVisibility(View.VISIBLE);
                mTitle.setText("Coding Trivia");
                mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
            }
        });

        mCat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategory = 4;
                updateQuestionMovies();
                mChoice1BTN.setVisibility(View.VISIBLE);
                mChoice2BTN.setVisibility(View.VISIBLE);
                mChoice3BTN.setVisibility(View.VISIBLE);
                mChoice4BTN.setVisibility(View.VISIBLE);
                mTitle.setText("Movies Trivia");
                mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
            }
        });

        mChoice1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1BTN.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
                    }

                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
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
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
                    }

                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
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
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
                    }

                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
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
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
                    }

                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    Toast.makeText(PicturePuzzle.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PicturePuzzle.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    mQuestionCount.setText("QUESTION: " + mQuestionNum + "/10");
                    if(mCategory == 1) {
                        if(mQuestionNum == mQuestionLibrary.getLastMath()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMath();
                        }
                    } else if(mCategory == 2) {
                        if(mQuestionNum == mQuestionLibrary.getLastVG()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionVG();
                        }
                    } else if(mCategory == 3) {
                        if(mQuestionNum == mQuestionLibrary.getLastCoding()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionCoding();
                        }
                    } else if(mCategory == 4) {
                        if(mQuestionNum == mQuestionLibrary.getLastMovies()) {
                            mQuestion.setText("Final Results: " + mScore + "/10 correct.");
                            mChoice1BTN.setVisibility(View.INVISIBLE);
                            mChoice2BTN.setVisibility(View.INVISIBLE);
                            mChoice3BTN.setVisibility(View.INVISIBLE);
                            mChoice4BTN.setVisibility(View.INVISIBLE);
                        } else {
                            updateQuestionMovies();
                        }
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

    private void updateQuestionCoding() {
        mQuestion.setText(mQuestionLibrary.getQuestionCoding(mQuestionNum));
        mChoice1BTN.setText(mQuestionLibrary.getChoice1Coding(mQuestionNum));
        mChoice2BTN.setText(mQuestionLibrary.getChoice2Coding(mQuestionNum));
        mChoice3BTN.setText(mQuestionLibrary.getChoice3Coding(mQuestionNum));
        mChoice4BTN.setText(mQuestionLibrary.getChoice4Coding(mQuestionNum));

        mAnswer = mQuestionLibrary.getCorrectCoding(mQuestionNum);
        mQuestionNum++;
    }

    private void updateQuestionMovies() {
        mQuestion.setText(mQuestionLibrary.getQuestionMovies(mQuestionNum));
        mChoice1BTN.setText(mQuestionLibrary.getChoice1Movies(mQuestionNum));
        mChoice2BTN.setText(mQuestionLibrary.getChoice2Movies(mQuestionNum));
        mChoice3BTN.setText(mQuestionLibrary.getChoice3Movies(mQuestionNum));
        mChoice4BTN.setText(mQuestionLibrary.getChoice4Movies(mQuestionNum));

        mAnswer = mQuestionLibrary.getCorrectMovies(mQuestionNum);
        mQuestionNum++;
    }

    private void updateScore(int point) {
        mScoreTV.setText("SCORE: " + mScore + "/10");
    }


}
