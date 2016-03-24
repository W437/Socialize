package com.alsalam.sclzroot.MyFragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddEventFragment extends Fragment implements View.OnClickListener{

    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;
    private Spinner spinner;
    String spin_val;
    private String[]time = new String[24];
    /** test
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<EventTbl> mToDoTable;
    private EditText etTime,etHours,etLocation,etAge, etTitle, etLimitParticipants, etEventDate, etDescription,etRequirments;
    private Button btnDone;
    private RadioButton rdb_male,rdb_female, rbBothLoc, rbBothG;
    private Spinner spnType;
    private RadioGroup rgLocation;
    private String location, genderPref;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextInputLayout wBeginTime;
    private ImageButton getLocBtn,imageDate,imageTime,imageHour;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
   // private Geocoder geocoder;
    private Location location2;
    String result = "";

      private Date eventDate;
    private FragmentManager fragmentManager;
    private SearchOnMapDialog searchFragment;
    private EventTbl event;


    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_add_event,container,false);
        event=new EventTbl();

        init(view);
       // return super.onCreateView(inflater, container, savedInstanceState);
      return  view;
     }

    protected void init(View view) {

        etTime =(EditText)view.findViewById(R.id.etTime); // beginning time
       // etEndT=(EditText)view.findViewById(R.id.etEndT);// ending Time
        etLocation=(EditText)view.findViewById(R.id.etLocation);// location
        etAge=(EditText)view.findViewById(R.id.etAge);// age range
        etTitle=(EditText)view.findViewById(R.id.etTitle);
        etLimitParticipants =(EditText)view.findViewById(R.id.etLimit);
        etEventDate=(EditText)view.findViewById(R.id.etEventDate);
        etDescription = (EditText)view.findViewById(R.id.etDescription);
        etRequirments = (EditText)view.findViewById(R.id.etRequirments);
        etHours = (EditText)view.findViewById(R.id.etHours);
        spinner=(Spinner)view.findViewById(R.id.spinner_id);
        imageHour= (ImageButton) view.findViewById(R.id.imageHour);
        imageDate= (ImageButton) view.findViewById(R.id.imageDate);
        imageTime= (ImageButton) view.findViewById(R.id.imageTime);



        // rgGender=(RadioGroup)view.findViewById(R.id.rgGender);
       // rgLocation=(RadioGroup)view.findViewById(R.id.rgLocation);
        wBeginTime=(TextInputLayout)view.findViewById(R.id.BeginningWrapper);

       // rbBothG=(RadioButton)view.findViewById(R.id.rbBothG);
       // rbBothLoc=(RadioButton)view.findViewById(R.id.rbBothLoc);
       // rdb_male=(RadioButton)view.findViewById(R.id.rdb_male);// choosing gendet (male)
        //rdb_female=(RadioButton)view.findViewById(R.id.rdb_female);//choosing gendet (female)
      //  spnType=(Spinner)view.findViewById(R.id.spnType);// choosing event_itm type
        btnDone=(Button)view.findViewById(R.id.btnDone);// the Done button which take you to the home Page
        getLocBtn = (ImageButton)view.findViewById(R.id.getLocBtn);

        //etTime.setOnClickListener(this);
       // etEndT.setOnClickListener(this);
     //   etEventDate.setOnClickListener(this);
      //  wBeginTime.setOnClickListener(this);

        btnDone.setOnClickListener(this);
        getLocBtn.setOnClickListener(this);

        imageHour.setOnClickListener(this);

        imageDate.setOnClickListener(this);

        imageTime.setOnClickListener(this);
        //etTime.setClickable(false);
        if(null==fragmentManager) {
            fragmentManager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
        }

    }




    public EventTbl getEventInfo()
    {
      //  if(rgGender.getCheckedRadioButtonId() == rdb_male.getId())
           // genderPref = "Male";
      //  else if(rgGender.getCheckedRadioButtonId() == rdb_female.getId())
          //  genderPref = "Female";
       // else
          //  genderPref = "Male & Female";

      //  if(rgLocation.getCheckedRadioButtonId() == R.id.rdb_out)
          //  location = "Outdoors";
      // else if(rgLocation.getCheckedRadioButtonId() == R.id.rdb_in)
        //   location = "Indoors";
      //  else
        //    location = "Outdoors & Indoors";

        event.setEventTitle(etTitle.getText().toString());
        event.setEventDescription(etDescription.getText().toString());
        event.setEventMaxParticipants(Integer.parseInt(etLimitParticipants.getText().toString()));
        event.setEventRequirements(etRequirments.getText().toString());
        event.setEventDate(etEventDate.getText().toString());
        event.setEventTime(etTime.getText().toString());
        event.setEventHours(etHours.getText().toString());
        event.setEventAgeRange(etAge.getText().toString());
        event.setEventLocation(etLocation.getText().toString());
        event.setEventGenderPref(genderPref);
        event.setEventActivityLocation(location);
       // event.setId(( Math.random() * 9999999) + "");
        event.setHostId((Math.random() * 9999999) + "");

          //event.setEventMaxParticipators(etLimitParticipants.getText().toString());
//        EventTbl event = new EventTbl( "",
//                etLocation.getText().toString(),
//                etTitle.getText().toString(),
//                etTime.getText().toString(),
//                etEventDate.getText().toString(),
//                etEndT.getText().toString(),
//                Math.random()*9999 + "",
//                Integer.parseInt(etLimitParticipants.getText().toString()),
//                etPurpose.getText().toString(),
//                etSummary.getText().toString(),
//                location,
//                genderPref,
//                etAge.getText().toString());

        Log.d("EVENT TEST", event.toString());
        return event;
    }

    public boolean areFieldsFilled() {
        if (etTitle.getText().toString().length() == 0) {
            etTitle.requestFocus();
            etTitle.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if (etLimitParticipants.getText().toString().length() == 0) {
            etLimitParticipants.requestFocus();
            etLimitParticipants.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
//        else if (etRequirments.getText().toString().length() == 0) {
//            etRequirments.requestFocus();
//            etRequirments.setError("FIELD CANNOT BE EMPTY");
//            return false;
//        }
//
//        else
         if (etEventDate.getText().toString().length() == 0) {
            etEventDate.requestFocus();
            etEventDate.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if (etTime.getText().toString().length() == 0) {
            etTime.requestFocus();
            etTime.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
//        else if (etHours.getText().toString().length() == 0) {
//            etHours.requestFocus();
//            etHours.setError("FIELD CANNOT BE EMPTY");
//            return false;
//        }
//        else
        if (etAge.getText().toString().length() == 0) {
            etAge.requestFocus();
            etAge.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if (etLocation.getText().toString().length() == 0) {
            etLocation.requestFocus();
            etLocation.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if (rgLocation.getCheckedRadioButtonId() == -1) {
            rgLocation.requestFocus();
            Toast.makeText(getContext(), "PLEASE CHECK A LOCATION TYPE", Toast.LENGTH_SHORT).show();
            return false;
        }
       // else if (rgGender.getCheckedRadioButtonId() == -1) {
          //  rgGender.requestFocus();
          //  Toast.makeText(getContext(), "PLEASE CHECK A GENDER PREFERENCE", Toast.LENGTH_SHORT).show();
            return false;
        }
       // else if (etDescription.getText().toString().length() == 0) {
          //  etDescription.requestFocus();
           // etDescription.setError("FIELD CANNOT BE EMPTY");
           // return false;
       // }
       // return true;
   // }



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

        if (v == imageDate) {

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
                            if(eventDate==null)
                                eventDate=new Date(year,monthOfYear,dayOfMonth);
                            else {
                                eventDate.setYear(year);
                                eventDate.setMonth(monthOfYear);
                                eventDate.setDate(dayOfMonth);                           }
                            etEventDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == imageTime) {

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
                            if(eventDate==null)
                                eventDate=new Date(mYear,mMonth,mDay,hourOfDay,minute);
                            else {
                                eventDate.setHours(hourOfDay);
                                eventDate.setMinutes(minute);
                            }
                             etTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

//        if (v == etEndT) {
//
//            // Get Current Time
//            final Calendar c = Calendar.getInstance();
//            mHour = c.get(Calendar.HOUR_OF_DAY);
//            mMinute = c.get(Calendar.MINUTE);
//
//            // Launch Time Picker Dialog
//            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
//                    new TimePickerDialog.OnTimeSetListener() {
//
//                        @Override
//                        public void onTimeSet(TimePicker view, int hourOfDay,
//                                              int minute) {
//
//                            etEndT.setText(hourOfDay + ":" + minute);
//                        }
//                    }, mHour, mMinute, false);
//            timePickerDialog.show();
//        }

        if (v == btnDone )
        {
            if(areFieldsFilled()) {
                addEventToDB(getEventInfo());
                Log.d("Azure", "Event Added!");
                //Toast.makeText(getActivity(),"FILL IN ALL FIELDS!",Toast.LENGTH_LONG).show();
                Log.d("Azure", getEventInfo().toString());
           }

        }

        if ( v == getLocBtn)
        {
            if(searchFragment==null)
            {
                searchFragment=new SearchOnMapDialog();
                searchFragment.setSearch(event,etLocation);

            }
            searchFragment.show(fragmentManager,"search");

//            try {
//                //etLocation.setText(getLocation(new Location("prov")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}


