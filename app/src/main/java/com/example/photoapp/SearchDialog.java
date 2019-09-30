package com.example.photoapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class SearchDialog extends AppCompatDialogFragment {
    private EditText editTextCaption;
    private EditText editTextTimeStamp;
    private SearchDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_search, null);

        builder.setView(view).setTitle("Search").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String caption = editTextCaption.getText().toString();
                String timeStamp = editTextTimeStamp.getText().toString();
                listener.applySearch(caption, timeStamp);
            }
        });

        editTextCaption = view.findViewById(R.id.search_caption);
        editTextTimeStamp = view.findViewById(R.id.search_time);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (SearchDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement search dialog listener");
        }

    }

    public interface SearchDialogListener {
        void applySearch(String caption, String timeStamp);
    }
}
