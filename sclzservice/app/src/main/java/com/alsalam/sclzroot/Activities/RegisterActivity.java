package com.alsalam.sclzroot.Activities;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends Activity implements View.OnClickListener {
     private EditText  etMail_Address, etUsername, etPass, etConfirm_Pass, etLocation, etPhoneNumber, etFirstName, etLastName;
     private Spinner spnDay,spnMonth,spnYear;
     private RadioButton rbMale,rbFemale;
     private RadioGroup rgGender;
     private Button  btnSubmit;
     private MobileServiceClient mClient;
     private String userGender = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etMail_Address = (EditText) findViewById(R.id.etMail_address);//  type your email address
        etUsername = (EditText) findViewById(R.id.etUsername);// tpe username
        etPass = (EditText) findViewById(R.id.etPass);// type password
        etConfirm_Pass = (EditText) findViewById(R.id.etConfirm_pass);// confirm your password
        etLocation = (EditText) findViewById(R.id.etLocation);
        etPhoneNumber = (EditText) findViewById(R.id.etPhone);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);

        spnDay = (Spinner) findViewById(R.id.spnDay);// choosing birth day
        spnMonth = (Spinner) findViewById(R.id.spnMonth);// choosing birth Month
        spnYear = (Spinner) findViewById(R.id.spnYear);// choosing birth Year

        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);// choosing male or female
        rbMale = (RadioButton) findViewById(R.id.rbMale);// choosig female or male

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        rbFemale.setOnClickListener(this);
        rbMale.setOnClickListener(this);


    }




    public UserTbl getUserInfo()
    {
        if(rgGender.getCheckedRadioButtonId() == rbMale.getId())
            userGender = "Male";
        else
            userGender = "Female";

        UserTbl user = new UserTbl(
                (int)(Math.random()*99999999) + "",
                etUsername.getText().toString(),
                etPass.getText().toString(),
                etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etMail_Address.getText().toString(),
                "normalUser",
                etLocation.getText().toString(),
                new Date(1998, 2, 17),
                userGender,
                etPhoneNumber.getText().toString()
        );

        Log.d("test", user.toString());
        return user;
    }
//s

    public boolean areFieldsEmpty()
    {
        if(etUsername.getText().toString() == null || etPass.getText().toString() == null ||
            etFirstName.getText().toString() == null || etLastName.getText().toString() == null
                    || etMail_Address.getText().toString() == null || etLocation.getText().toString() == null
                    || userGender == null || etPhoneNumber.getText().toString() == null)
            return true;
        return false;
    }

    public void addUserToDB(UserTbl user)
    {
        try {

            mClient = new MobileServiceClient("https://sclzservice.azurewebsites.net",getBaseContext());
            MobileServiceTable<UserTbl> mtable = mClient.getTable(UserTbl.class);
            mtable.insert(user, new TableOperationCallback<UserTbl>() {
                @Override
                public void onCompleted(UserTbl entity, Exception exception, ServiceFilterResponse response) {
                    if(exception==null)
                    {
                        Toast.makeText(getBaseContext(), "REGISTERED SUCCESSFULY!", Toast.LENGTH_LONG).show();
                        Log.d("AZURE DB", "SUCCESS! YAY!");
                        startActivity(new Intent(getBaseContext(), LoginActivity.class));
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"FAILED",Toast.LENGTH_LONG).show();
                        Log.d("AZURE DB", "FAILED");
                        Log.d("AZURE DB", exception.getMessage());
                    }
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnSign:
                startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
                break;
            case R.id.btnSubmit:
                if(!areFieldsEmpty()) {
                    addUserToDB(getUserInfo());
                    Log.d("testa", "Clicked submit");
                }
                else {
                    Toast.makeText(getBaseContext(),"FILL IN ALL FIELDS",Toast.LENGTH_LONG).show();
                }
                break;

        }



    }
}
