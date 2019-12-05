package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class CardGameActivity extends AppCompatActivity {

    ImageView currImage = null;
    private int currPair = 0;
    final int[] drawable = new int[]{R.drawable.puppy1, R.drawable.puppy2, R.drawable.puppy3, R.drawable.puppy4, R.drawable.puppy5,
            R.drawable.puppy6, R.drawable.puppy7, R.drawable.puppy8};

    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
