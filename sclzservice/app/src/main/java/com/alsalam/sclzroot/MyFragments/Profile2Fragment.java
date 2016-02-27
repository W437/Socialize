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

import com.example.sclzservice.R;

public class Profile2Fragment extends Fragment {
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
     //kjkjkjk


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_profile2,container,false);
        intit(view);
        return view;
    }

    protected void intit(View view) {

        tvName=(TextView)view.findViewById(R.id.tvName);
        tvLName=(TextView)view.findViewById(R.id.tvLName);
        tvLoc=(TextView)view.findViewById(R.id.tvLoc);
        tvHob=(TextView)view.findViewById(R.id.tvHob);
        tvGen=(TextView)view.findViewById(R.id.tvGen);
        et1=(EditText)view.findViewById(R.id.et1);
        et2=(EditText)view.findViewById(R.id.et2);
        et3=(EditText)view.findViewById(R.id.et3);
        et4=(EditText)view.findViewById(R.id.et4);
        et5=(EditText)view.findViewById(R.id.et5);
    }

}
