package com.example.wakeandgame;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Model {
    //Creating Alarm model class
    public static class Alarm{
        public String time;
        public String date;
        public String note;

        public Alarm(String date, String time, String note){
            this.date = date;
            this.time = time;
            this.note = note;
        }
    }
}
