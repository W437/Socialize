package com.alsalam.sclzroot.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sclzservice.R;

public class AddEventActivity extends Activity {
    private TextView tvselect_type,tvprop,tvLimit,tvLocation,tvGen,tvPurp,tvAge;
    private EditText etBegT,etEndT,etLocation,etPurp,etAge;
     private  Button btnDone;
     private RadioButton rdb_in,rdb_out,rdb_male,rdb_female;
     private Spinner spnType;
    //kokololo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        tvselect_type=(TextView)findViewById(R.id.tvselect_type);// SelectType
        tvprop=(TextView)findViewById(R.id.tvprop);//event propirities
        tvLimit=(TextView)findViewById(R.id.tvLimit);// paricipants limit
        tvLocation=(TextView)findViewById(R.id.tvLocation);// location
        tvGen=(TextView)findViewById(R.id.tvGen);// gender preference
        tvPurp=(TextView)findViewById(R.id.tvPurp);//  Event Purpose
        tvAge=(TextView)findViewById(R.id.tvAge);// Age Range

        etBegT=(EditText)findViewById(R.id.etBegT); // beginning time
        etEndT=(EditText)findViewById(R.id.etEndT);// ending Time
        etLocation=(EditText)findViewById(R.id.etLocation);// location
        etAge=(EditText)findViewById(R.id.etAge);// age range

        rdb_in=(RadioButton)findViewById(R.id.rdb_in);// choosing  location INDOORS/OUTDOORS
        rdb_out=(RadioButton)findViewById(R.id.rdb_out);//choosing  location INDOORS/OUTDOORS
        rdb_male=(RadioButton)findViewById(R.id.rdb_male);// choosing gendet (male)
        rdb_female=(RadioButton)findViewById(R.id.rdb_female);//choosing gendet (female)
        spnType=(Spinner)findViewById(R.id.spnType);// choosing event type

//kkkk

    }

}
