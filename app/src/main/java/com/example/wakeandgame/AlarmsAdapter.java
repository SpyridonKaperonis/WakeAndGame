package com.example.wakeandgame;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.selection.ItemDetailsLookup;

import org.w3c.dom.Text;

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

        public ItemDetailsLookup.ItemDetails getItemDetails() {
            return new ItemDetailsLookup.ItemDetails() {
                @Override
                public int getPosition() {
                    return avh.getAdapterPosition();
                }
                @Nullable
                @Override
                public Object getSelectionKey() {
                    return avh.getItemId();
                }
            };
        }
    }

    private ArrayList<Model.Alarm> alarms = null;


    public AlarmsAdapter(ArrayList<Model.Alarm> alarms){
        super();
        this.alarms = alarms;
    }
    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_layout, parent, false);

        return new AlarmViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {
        TextView dateTV = holder.theView.findViewById(R.id.dateTV);
        TextView timeTV = holder.theView.findViewById(R.id.timeTV);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }


}
