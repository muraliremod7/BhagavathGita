package com.murali.hariprahlad.bhagavathgita.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.murali.hariprahlad.bhagavathgita.R;


public class LearningGitaFragment extends Fragment implements View.OnClickListener{
    private ImageView arjunVishada;
    Context context;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_learning_gita, container, false);
        arjunVishada = (ImageView)view.findViewById(R.id.arjuna);
        arjunVishada.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.arjuna:
                fnShowCustomAlertDialog();
                break;
        }
    }

    private void fnShowCustomAlertDialog() {
        //Inflate layout
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
        LayoutInflater factory = LayoutInflater.from(view.getContext());
        final View view1 = factory.inflate(R.layout.alertdialog, null);
        alertDialog.setView(view1);
        alertDialog.show();
    }
}
