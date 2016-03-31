package com.alsalam.sclzroot.MyFragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.alsalam.sclzroot.Activities.RegisterActivity;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.GuestsToEvent;
import com.alsalam.sclzroot.handlers.EventsHandler;
import com.alsalam.sclzroot.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.text.DateFormat;

/**
 * Created by hp1 on 15/03/2016.
 */
public class JoinEventDialog extends DialogFragment implements View.OnClickListener
{

    protected EventsHandler eventsHandler;
    private TextView tvTime,tvHours,tvLocation,tvAge, tvTitle, tvLimitParticipants, tvEventDate, tvDescription,tvRequirments;
    private Button btnJoin,btnCancel;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private EditText etNumOfParticipants,iNeed,iBring;
     private EventTbl eventTbl;
    private MobileServiceClient mClient;

    @SuppressLint("ValidFragment")
    public JoinEventDialog(EventTbl currentItem) {
        super();
        this.eventTbl=currentItem;

    }

    public void setEventTbl() {
        tvTitle.setText(this.eventTbl.getTitle());
        tvLocation.setText(this.eventTbl.getAddressLocation());
        tvDescription.setText(this.eventTbl.getDescription());
        tvHours.setText(this.eventTbl.getHours());
        tvLimitParticipants.setText(this.eventTbl.getMaxParticipants());
        tvRequirments.setText(this.eventTbl.getRequirements());


        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        tvTime.setText("Time: " + dateFormat.format(eventTbl.getDate()));

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof EventsHandler){
            this.eventsHandler= (EventsHandler) context;
        }
    }

    @Override
    public void onDetach() {
        this.eventsHandler=null;
        super.onDetach();
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.join_event, container, false);
        init(view);
        //setListerners();
        setEventTbl();
        return  view;
    }

//    private void setListerners() {
//        btnJoin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(eventsHandler!=null){
//                    //pass event object or id pass them by bundle
//                    //join event may implemment serializable interface to pass serializable object for ease of access
//                    eventsHandler.onJoinEvent(null);
//                }
//                dismiss();
//            }
//        });
//    }


    protected void init(View view) {

        tvTime = (TextView) view.findViewById(R.id.tvTime); // beginning time
        tvLocation = (TextView) view.findViewById(R.id.tvLocation);// location
        tvAge = (TextView) view.findViewById(R.id.tvAge);// age range
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvLimitParticipants = (TextView) view.findViewById(R.id.tvLimit);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);

        btnJoin=(Button)view.findViewById(R.id.btnJoin);
         //  spnType=(Spinner)view.findViewById(R.id.spnType);// choosing event_itm type
        // btnDone = (Button) view.findViewById(R.id.btnDone);// the Done button which take you to the home Page
       //   getLocBtn = (ImageButton) view.findViewById(R.id.getLocBtn);

           etNumOfParticipants=(EditText)view.findViewById(R.id.etNumOfParticipants);
           iNeed=(EditText)view.findViewById(R.id.iNeed);
           iBring=(EditText)view.findViewById(R.id.iBring);

           btnCancel=(Button)view.findViewById(R.id.btnCancel);




    }

    public boolean areFieldsFilled() {
        if (etNumOfParticipants.getText().toString().length() == 0) {
            etNumOfParticipants.requestFocus();
            etNumOfParticipants.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if (iBring.getText().toString().length() == 0) {
            iBring.requestFocus();
            iBring.setError("FIELD CANNOT BE EMPTY");
            return false;
        }

        if (iNeed.getText().toString().length() == 0) {
            iNeed.requestFocus();
            iNeed.setError("FIELD CANNOT BE EMPTY");
            return false;
        }

              return  true;
     }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnJoin:

                 if(areFieldsFilled()) {


                     int num = Integer.parseInt(etNumOfParticipants.getText().toString());
                     String ineed = iNeed.getText().toString();
                     String ibring = iBring.getText().toString();
                     GuestsToEvent guestsToEvent = new GuestsToEvent();
                     guestsToEvent.setCountP(num);
                     guestsToEvent.setiBring(ibring);
                     guestsToEvent.setiNeed(ineed);


                     try {

                         mClient = new MobileServiceClient("https://sclzservice.azurewebsites.net", getContext());
                         MobileServiceTable<GuestsToEvent> mtable = mClient.getTable(GuestsToEvent.class);
                         mtable.insert(guestsToEvent, new TableOperationCallback<GuestsToEvent>() {
                             @Override
                             public void onCompleted(GuestsToEvent entity, Exception exception, ServiceFilterResponse response) {
                                 if (exception == null) {
                                     Toast.makeText(getContext(), "JOINED SUCCESSFULY!", Toast.LENGTH_LONG).show();
                                     Log.d("AZUREDB", "SUCCESS! YAY!");

                                     dismiss();

                                 } else {
                                     exception.printStackTrace();
                                     Toast.makeText(getContext(), "Joining FAILED", Toast.LENGTH_LONG).show();
                                     Log.d("AZUREDB", "FAILED");
                                     Log.d("AZUREDB", exception.getMessage());
                                 }
                             }
                         });

                     } catch (MalformedURLException e) {
                         e.printStackTrace();
                     }
                 }
                break;



              case R.id.btnCancel :
                   dismiss();
                  break;
        }


    }

}
