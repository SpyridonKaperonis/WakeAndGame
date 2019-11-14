package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tempBTN = findViewById(R.id.tempBTN);

        final Intent intent = new Intent(this, AlarmActivity.class);

        AlarmsAdapter alarmServer = new AlarmsAdapter();
        final RecyclerView alarmRV = findViewById(R.id.alarmRV);
        alarmRV.setAdapter(alarmServer);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        alarmRV.setLayoutManager(manager);

        final class AlarmDetailsLookup extends ItemDetailsLookup {
            // Need to know the recycler to ask.
            private final RecyclerView mRecyclerView;
            AlarmDetailsLookup(RecyclerView recyclerView) {
                mRecyclerView = recyclerView;
            }
            public ItemDetails getItemDetails(MotionEvent e) {
                // Get the x,y and see if we can find a subview
                View view = alarmRV.findChildViewUnder(e.getX(), e.getY());
                if (view != null) {
                    RecyclerView.ViewHolder holder = alarmRV.getChildViewHolder(view);
                    if (holder instanceof AlarmsAdapter.AlarmViewHolder) {
                        return ((AlarmsAdapter.AlarmViewHolder) holder).getItemDetails();
                    }
                }
                return null;
            }
        }

        tempBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        model = Model.getMyModel();

                Button newBTN = findViewById(R.id.newBTN);

                newBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText dateET = findViewById(R.id.dateET);
                        EditText timeET = findViewById(R.id.timeET);
                        EditText noteET;

                        model.arrModel.add(new Model.Alarm(dateET.getText().toString(),timeET.getText().toString(), "hello"));

                        dateET.setText("");
                        timeET.setText("");
                    }
                });

    }
}
