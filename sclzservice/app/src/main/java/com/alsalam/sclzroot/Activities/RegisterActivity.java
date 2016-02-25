package com.alsalam.sclzroot.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sclzservice.R;

public class RegisterActivity extends Activity {
     private TextView tvMail_Address, tvPass,tvBD,tvGender;
     private EditText  etMail_Address,etUsername,etPass,etConfirm_Pass;
     private Spinner spnDay,spnMonth,spnYear;
     private RadioButton rdbM,rdbF;
     private Button  btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvMail_Address=(TextView)findViewById(R.id.tvMail_address);// Email Address or Username
        tvPass=(TextView)findViewById(R.id.tvPass);// Password
        tvBD=(TextView)findViewById(R.id.tvBirthD);// birth date

        etMail_Address=(EditText)findViewById(R.id.etMail_address);//  type your email address
        etUsername=(EditText)findViewById(R.id.etUsername);// tpe username
        etPass=(EditText)findViewById(R.id.etPass);// type password
        etConfirm_Pass= (EditText)findViewById(R.id.etConfirm_pass);// confirm your password

        spnDay=(Spinner)findViewById(R.id.spnDay);// choosing birth day
        spnMonth=(Spinner)findViewById(R.id.spnMonth);// choosing birth Month
        spnYear=(Spinner)findViewById(R.id.spnYear);// choosing birth Year

        rdbF=(RadioButton)findViewById(R.id.rdbF);// choosing male or female
        rdbM=(RadioButton)findViewById(R.id.rdbM);// choosig female or male

        btnSubmit=(Button)findViewById(R.id.btnSubmit);


         btnSubmit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  switch (v.getId()){
                      case R.id.btnSubmit:
                          Intent intent =new Intent(RegisterActivity.this,HomeActivity.class);
                          startActivity(intent);
                          break;

                  }
             }
         });

         }






}
