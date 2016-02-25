package com.alsalam.sclzroot.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sclzservice.R;

public class ProfileActivity extends Activity {
    private TextView tvFirstN,tvLastN,tvBirthD;// first name,last name,birthday date
    private EditText etFirstN,etLastN;// First name, last name
    private EditText et_mail2,et_pass2;// Editing mail & Password
    private Spinner spn_Day,spn_Month,spn_Year;
    private RadioButton rdb_Male2,rdb_Female2;// Gender
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        tvFirstN=(TextView)findViewById(R.id.tvFirstN);
//        tvBirthD=(TextView)findViewById(R.id.tvBirthD);//birthday date
//
//
//        etFirstN=(EditText)findViewById(R.id.etFirstN);// first name
//        etLastN=(EditText)findViewById(R.id.etLastN);// last name
//        et_mail2=(EditText)findViewById(R.id.et_mail2);//email that you want to edit
//        et_pass2=(EditText)findViewById(R.id.et_pass2);//password
//
//        spn_Day=(Spinner)findViewById(R.id.spn_Day);
//        spn_Month=(Spinner)findViewById(R.id.spn_Month);
//        spn_Year=(Spinner)findViewById(R.id.spnYear);
//
//        rdb_Male2=(RadioButton)findViewById(R.id.rdb_Male2);
//        rdb_Female2=(RadioButton)findViewById(R.id.rdb_Female2);
//
//        btnBack=(Button)findViewById(R.id.btnBack);
//
//
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Intent intent =new Intent (ProfileActivity.this,HomeActivity.class);
//               //  startActivity(intent);
//            }
//        });
    }

}
