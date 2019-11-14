package com.example.wakeandgame;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmsAdapter.AlarmViewHolder> {
    public static class AlarmViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout theView;

        public AlarmViewHolder(LinearLayout v){
            super(v);
            theView = v;
        }

        public AlarmViewHolder avh = this;

    }

    private ArrayList<Model.Alarm> alarms = null;


    public AlarmsAdapter(ArrayList<Model.Alarm> alarms){
        super();
        this.alarms = alarms;
    }
    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
