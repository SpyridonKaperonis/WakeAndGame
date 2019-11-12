package com.example.wakeandgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class JavelinDialog extends DialogFragment {

    private double distance;

    public JavelinDialog(double distance){
        this.distance = distance;
    }

    public interface JavelinDialogCall{
        void restartActivity();
        void endActivity();
    }

    private JavelinDialogCall myActivity = null;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        myActivity = (JavelinDialogCall)context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Thanks for throwing!");
        builder.setMessage("You threw the javelin " + distance);
        builder.setPositiveButton("THROW AGAIN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myActivity.restartActivity();
            }
        });
        builder.setNegativeButton("BACK TO GAMES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myActivity.endActivity();
            }
        });

        return builder.create();
    }

}
