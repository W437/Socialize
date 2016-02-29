package com.alsalam.sclzroot.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.sclzservice.R;

public class EventInfoActivity extends Activity {
    private TextView tv_EventName,tv_Details,tv_HostName, tv_Parl,tv_JoinReq,tv_Ager,tv_EventLocation,tv_GenderP;
    private Button btn_PAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        tv_EventName=(TextView)findViewById(R.id.tv_EventName);// Event Name
        tv_Details=(TextView)findViewById(R.id.tv_Details);// Details
        tv_HostName=(TextView)findViewById(R.id.tv_HostName);// Host Name
        tv_Parl=(TextView)findViewById(R.id.tv_ParL);//  Participants Limits
        tv_JoinReq=(TextView)findViewById(R.id.tv_JoinReq);//  jois requests
        tv_Ager=(TextView)findViewById(R.id.tv_AgeR);//  Age Range
        tv_EventLocation=(TextView)findViewById(R.id.tv_EventLocation);// Event Location field
        tv_GenderP=(TextView)findViewById(R.id.tv_GenderP);//  Gender preference

        btn_PAR=(Button)findViewById(R.id.btn_PAR);// Participate button
    }

}
