package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.R;

/**
 * Created by hp1 on 08/03/2016.
 */
public class EventsToParticipate extends Fragment
{
    private ListView listView3;
    private ListView listView;
    private EventTblAdapter eventTblAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_to_participate, container, false);
        init(view);

        listView= (ListView) view.findViewById(R.id.listView);
        if(eventTblAdapter ==null) eventTblAdapter =new EventTblAdapter(getContext(), R.layout.event_card_itm);
        listView.setAdapter(eventTblAdapter);
        ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter);


        return view;
    }
    protected void init(View view)
    {



    }



}
