package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

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
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        GridView gridView = (GridView) findViewById(R.id.cardGV);
        CardAdapter cardAdapter = new CardAdapter(this);
        gridView.setAdapter(cardAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPos < 0)
                {
                    currentPos = position;
                    currImage = (ImageView) view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }

                else
                {
                    if(currentPos == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.card_back);
                    }

                    else if(pos[currentPos] != pos[position])
                    {
                        currImage.setImageResource(R.drawable.card_back);
                        Toast.makeText(getApplicationContext(), "Not a match... ", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        currPair++;

                        if(currPair == 0)
                        {
                            Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    currentPos = -1;
                }
            }
        });
    }
}
