package com.alsalam.sclzroot.MyFragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;

public class AddEventFragment extends Fragment implements View.OnClickListener{

    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<EventTbl> mToDoTable;
    private EditText etBegT,etEndT,etLocation,etPurpose,etAge, etTitle, etParticipantsLimit, etEventDate, etProp;
    private Button btnDone;
    private RadioButton rdb_male,rdb_female, rbBothLoc, rbBothG;
    private Spinner spnType;
    private RadioGroup rgLocation, rgGender;
    private String location, genderPref;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextInputLayout wBeginTime;
    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_add_event,container,false);
        init(view);
       // return super.onCreateView(inflater, container, savedInstanceState);
      return  view;
     }

    protected void init(View view) {

        etBegT=(EditText)view.findViewById(R.id.etBegT); // beginning time
        etEndT=(EditText)view.findViewById(R.id.etEndT);// ending Time
        etLocation=(EditText)view.findViewById(R.id.etLocation);// location
        etAge=(EditText)view.findViewById(R.id.etAge);// age range
        etTitle=(EditText)view.findViewById(R.id.etTitle);
        etParticipantsLimit=(EditText)view.findViewById(R.id.etLimit);
        etEventDate=(EditText)view.findViewById(R.id.etEventDate);
        etPurpose = (EditText)view.findViewById(R.id.etPurpose);
        etProp = (EditText)view.findViewById(R.id.etProp);

        rgGender=(RadioGroup)view.findViewById(R.id.rgGender);
        rgLocation=(RadioGroup)view.findViewById(R.id.rgLocation);
        wBeginTime=(TextInputLayout)view.findViewById(R.id.BeginningWrapper);

        rbBothG=(RadioButton)view.findViewById(R.id.rbBothG);
        rbBothLoc=(RadioButton)view.findViewById(R.id.rbBothLoc);
        rdb_male=(RadioButton)view.findViewById(R.id.rdb_male);// choosing gendet (male)
        rdb_female=(RadioButton)view.findViewById(R.id.rdb_female);//choosing gendet (female)
        spnType=(Spinner)view.findViewById(R.id.spnType);// choosing event_itm type
        btnDone=(Button)view.findViewById(R.id.btnDone);// the Done button which take you to the home Page

        //etBegT.setOnClickListener(this);
        etEndT.setOnClickListener(this);
        etEventDate.setOnClickListener(this);
        wBeginTime.setOnClickListener(this);
        btnDone.setOnClickListener(this);
        //etBegT.setClickable(false);

    }

    public EventTbl getEventInfo()
    {
        if(rgGender.getCheckedRadioButtonId() == rdb_male.getId())
            genderPref = "Male";
        else if(rgGender.getCheckedRadioButtonId() == rdb_female.getId())
            genderPref = "Female";
        else
            genderPref = "Male & Female";

        if(rgLocation.getCheckedRadioButtonId() == R.id.rdb_out)
            location = "Outdoors";
        else if(rgLocation.getCheckedRadioButtonId() == R.id.rdb_in)
            location = "Indoors";
        else
            location = "Outdoors & Indoors";


        EventTbl event = new EventTbl(Math.random()*99999 + "",
                etLocation.getText().toString(),
                etTitle.getText().toString(),
                etBegT.getText().toString(),
                etEventDate.getText().toString(),
                etEndT.getText().toString(),
                Math.random()*9999 + "",
                Integer.parseInt(etParticipantsLimit.getText().toString()),
                etPurpose.getText().toString(),
                etProp.getText().toString(),
                location,
                genderPref,
                etAge.getText().toString());

        Log.d("test", event.toString());
        return event;
    }

    public boolean areFieldsEmpty()
    {
        if(etLocation.getText() == null || etTitle.getText() == null ||
                etBegT.getText() == null || etEventDate.getText() == null ||
                etEndT.getText() == null || etParticipantsLimit.getText() == null ||
                etPurpose.getText() == null || etProp.getText() == null ||
                location == null || genderPref == null || etAge.getText() == null)
            return true;
        return false;
    }



    public void addEventToDB(EventTbl event)
    {
        try {

            mClient = new MobileServiceClient("https://sclzservice.azurewebsites.net", getContext());
            MobileServiceTable<EventTbl> mtable = mClient.getTable(EventTbl.class);
            mtable.insert(event, new TableOperationCallback<EventTbl>() {
                @Override
                public void onCompleted(EventTbl entity, Exception exception, ServiceFilterResponse response) {
                    if(exception==null)
                    {
                        Toast.makeText(getContext(), "EVENT ADDED SUCCESSFULY!", Toast.LENGTH_LONG).show();
                        Log.d("AZURE DB", "SUCCESS! YAY!");

                    }
                    else
                    {
                        Toast.makeText(getContext(),"FAILED",Toast.LENGTH_LONG).show();
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

        if (v == etEventDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etEventDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == wBeginTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            etBegT.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if (v == etEndT) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            etEndT.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if (v == btnDone )
        {
                addEventToDB(getEventInfo());
                Log.d("Azure", "Event Added!");
                //Toast.makeText(getActivity(),"FILL IN ALL FIELDS!",Toast.LENGTH_LONG).show();
                Log.d("Azure", getEventInfo().toString());

        }
    }
}


