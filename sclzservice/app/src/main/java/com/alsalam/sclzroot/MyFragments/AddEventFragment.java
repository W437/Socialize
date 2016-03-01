package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sclzservice.R;

public class AddEventFragment extends Fragment {
    private TextView tvselect_type,tvprop,tvLimit,tvLocation,tvGen,tvPurp,tvAge;
    private EditText etBegT,etEndT,etLocation,etPurp,etAge;
     private  Button btnDone;
     private RadioButton rdb_in,rdb_out,rdb_male,rdb_female;
     private Spinner spnType;
//lklk;kjjjllll
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_add_event,container,false);
        init(view);
       // return super.onCreateView(inflater, container, savedInstanceState);
      return  view;
     }

    protected void init(View view) {



        tvselect_type=(TextView)view.findViewById(R.id.tvselect_type);// SelectType
        tvLocation=(TextView)view.findViewById(R.id.tvLocation);// location
        tvGen=(TextView)view.findViewById(R.id.tvGen);// gender preference

        etBegT=(EditText)view.findViewById(R.id.etBegT); // beginning time
        etEndT=(EditText)view.findViewById(R.id.etEndT);// ending Time
        etLocation=(EditText)view.findViewById(R.id.etLocation);// location
        etAge=(EditText)view.findViewById(R.id.etAge);// age range

        rdb_in=(RadioButton)view.findViewById(R.id.rdb_in);// choosing  location INDOORS/OUTDOORS
        rdb_out=(RadioButton)view.findViewById(R.id.rdb_out);//choosing  location INDOORS/OUTDOORS
        rdb_male=(RadioButton)view.findViewById(R.id.rdb_male);// choosing gendet (male)
        rdb_female=(RadioButton)view.findViewById(R.id.rdb_female);//choosing gendet (female)
        spnType=(Spinner)view.findViewById(R.id.spnType);// choosing event type
        btnDone=(Button)view.findViewById(R.id.btnDone);// the Done button which take you to the home Page


//kkkk

    }

}
