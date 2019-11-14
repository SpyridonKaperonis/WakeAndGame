package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Model.Alarm> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tempBTN = findViewById(R.id.tempBTN);

        final Intent intent = new Intent(this, AlarmActivity.class);

        AlarmsAdapter alarmServer = new AlarmsAdapter(model);
        RecyclerView alarmRV = findViewById(R.id.alarmRV);
        alarmRV.setAdapter(alarmServer);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        alarmRV.setLayoutManager(manager);

        tempBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        model = new ArrayList<Model.Alarm>();

                Button newBTN = findViewById(R.id.newBTN);

                newBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText dateET = findViewById(R.id.dateET);
                        EditText timeET = findViewById(R.id.timeET);
                        EditText noteET;

                        model.add(new Model.Alarm(dateET.getText().toString(),timeET.getText().toString(), "hello"));

                        dateET.setText("");
                        timeET.setText("");
                    }
                });

    }
}
