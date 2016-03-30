package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.TableManager.DataBaseMngr;
import com.alsalam.sclzroot.TableManager.UserTbl;

public class Profile2Fragment extends Fragment {
    private EditText etProfile_Name;
    private EditText etProfile_LastName;
    private EditText etProfile_Location;
    private EditText etProfile_gender;
    private EditText etProfile_phone;
     //kjkjkjk




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_profile2,container,false);
        intit(view);
        return view;
    }


    protected void intit(View view) {

        etProfile_Name=(EditText)view.findViewById(R.id.etProfile_Name);
        etProfile_LastName=(EditText)view.findViewById(R.id.etProfile_LastName);
        etProfile_phone=(EditText)view.findViewById(R.id.etProfile_phone);
        etProfile_Location=(EditText)view.findViewById(R.id.etProfile_Location);
        etProfile_gender=(EditText)view.findViewById(R.id.etProfile_gender);



        etProfile_Name.setText(DataBaseMngr.getLogedFirstName(getContext()));
        etProfile_LastName.setText(DataBaseMngr.getLogedUserLastName(getContext()));
        etProfile_Location.setText(DataBaseMngr.getLogedUserAddress(getContext()));
        etProfile_phone.setText(DataBaseMngr.getLogedUserPhoneNumber(getContext()));
        etProfile_gender.setText(DataBaseMngr.getLogedUserGender(getContext()));

       }

}
