package com.alsalam.sclzroot.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sclzservice.R;

public class Profile2Activity extends Activity {
    private TextView tvName;
    private TextView tvLName;
    private TextView tvLoc;
    private TextView tvHob;
    private TextView tvGen;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        tvName=(TextView)findViewById(R.id.tvName);
        tvLName=(TextView)findViewById(R.id.tvLName);
        tvLoc=(TextView)findViewById(R.id.tvLoc);
        tvHob=(TextView)findViewById(R.id.tvHob);
        tvGen=(TextView)findViewById(R.id.tvGen);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
    }

}
