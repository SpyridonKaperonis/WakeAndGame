package com.example.wakeandgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity {

    Button chooseTimeBTN, chooseDateBTN, newFinishBTN;
    TextView timeTV, dateTV;

    private int minute, hour, day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

        chooseTimeBTN = findViewById(R.id.chooseTimeBTN);
        timeTV = findViewById(R.id.timeTV);
        chooseDateBTN = findViewById(R.id.chooseDateBTN);
        dateTV = findViewById(R.id.dateTV);

        chooseTimeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(NewAlarmActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int inputHour, int inputMinute) {
                        if((inputMinute % 10) != 0) {
                            timeTV.setText(inputHour + ":0" + inputMinute);
                        }else{
                            timeTV.setText(inputHour + ":" + inputMinute);
                        }
                    }
                }, hour, minute, false);
                timePicker.show();
            }
        });

        chooseDateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(NewAlarmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        dateTV.setText((m+1) + "/" + d + "/" + y);
                    }
                },year,month,day);
                datePicker.show();
            }
        });

        Intent createIntent = new Intent();

        createIntent.putExtra("hour", hour);
        createIntent.putExtra("minute", minute);
        createIntent.putExtra("month", month);
        createIntent.putExtra("day", day);
        createIntent.putExtra("year", year);
        createIntent.putExtra("date", dateTV.getText());
        createIntent.putExtra("time", timeTV.getText());
        setResult(1,createIntent);

        newFinishBTN = findViewById(R.id.newFinishBTN);

    }
}
