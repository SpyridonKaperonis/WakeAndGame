package com.example.wakeandgame;

import java.sql.Time;
import java.util.Date;

public class Model {

    //Creating Alarm model class
    public static class Alarm{
        public Time time;
        public Date date;
        public String note;

        public Alarm(){
            this.time = null;
            this.date = null;
            this.note = null;
        }

        public Alarm(Time time, Date date, String note){
            this.date = date;
            this.time = time;
            this.note = note;
        }
    }
}
