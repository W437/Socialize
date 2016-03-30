package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
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
