package com.alsalam.sclzroot.MyFragments;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.alsalam.sclzroot.Activities.RegisterActivity;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.handlers.EventsHandler;
import com.alsalam.sclzroot.R;

/**
 * Created by hp1 on 15/03/2016.
 */
public class ParticipatorsFragment extends DialogFragment
{

    //protected EventsHandler eventsHandler;
    private ListView lstvParticipants;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    //    if(context instanceof EventsHandler){
      //      this.eventsHandler= (EventsHandler) context;
    //    }
    }

    @Override
    public void onDetach() {
//        this.eventsHandler=null;
        super.onDetach();
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.participators, container, false);
        init(view);

        return  view;
    }







    protected void init(View view)
    {
        lstvParticipants =(ListView)view.findViewById(R.id.lstvParticipants);
        UserTblAdapter userTblAdapter =new UserTblAdapter(getContext(),R.layout.user_card_itm);

       lstvParticipants.setAdapter(userTblAdapter);

    }




}
