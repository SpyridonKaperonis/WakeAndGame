package com.example.wakeandgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    private Model model;

    private Button chooseTimeBTN, chooseDateBTN;
    private int minute, hour, day, month, year;


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

        chooseTimeBTN = findViewById(R.id.chooseTimeBTN);
        chooseDateBTN = findViewById(R.id.chooseDateBTN);

        chooseTimeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int inputHour, int inputMinute) {
                        EditText timeET = findViewById(R.id.timeET);
                        if(inputMinute < 10) {
                            timeET.setText(inputHour + ":0" + inputMinute);
                        }else{
                            timeET.setText(inputHour + ":" + inputMinute);
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

                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        EditText dateET = findViewById(R.id.dateET);

                        dateET.setText((m+1) + "/" + d + "/" + y);
                    }
                },year,month,day);
                datePicker.show();
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

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        /*
        //Possible new alarm interface
        Button newAlarmBTN = findViewById(R.id.newAlarmBTN);
        final Intent intent1 = new Intent(this, NewAlarmActivity.class);

        newAlarmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewAlarmActivity.class);
                startActivityForResult(i, 1);
            }
        });

        model = Model.getMyModel();

         */

    }

    /*
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == 1){
                model.arrModel.add(new Model.Alarm(data.getStringExtra("date"),
                        data.getStringExtra("time"), "hola"));
                Log.d("Data", data.getStringExtra("date") + " " +
                        data.getStringExtra("time"));
            } else {
                Toast.makeText(this, "Either date or time is not filled in.", Toast.LENGTH_SHORT).show();
            }
        }

    }

     */
}
