package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.R;

public class MyAccountFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_my_account,container,false);


        init(view);
        // return super.onCreateView(inflater, container, savedInstanceState);
        return  view;
    }

    protected void init(View view) {

    }

}

