package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.R;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.ne;
import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;

public class EventStoriesFragments extends Fragment
{
    private ListView listView;
    private Spinner spinner;

    String spin_val;
    private String[] event = new String[6];
    private EventTblAdapter eventTblAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.events_stories,container,false);
       // init(view);
        listView= (ListView) view.findViewById(R.id.listView);
        if(eventTblAdapter ==null) eventTblAdapter =new EventTblAdapter(getContext(), R.layout.event_to_accept);
        listView.setAdapter(eventTblAdapter);
        ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter);
        spinner=(Spinner)view.findViewById(R.id.spinner_id);
        event[0] =getResources().getString(R.string.all_events);
        event[1]=getResources().getString(R.string.accepted_events);
        event[2]=getResources().getString(R.string.my_own_events);
        event[3]=getResources().getString(R.string.events_according_time);
        event[4]=getResources().getString(R.string.events_according_my_location);
        event[5]=getResources().getString(R.string.past_events);




//setting array adaptors to spinners

//ArrayAdapter is a BaseAdapter that is backed by an array of arbitrary objects

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, event);

// setting adapters to spinners

        spinner.setAdapter(spin_adapter);


       /// ((MainHomeActivity)((MainHomeActivity) getActivity()).refreshEventsFromTable(spinner,R.layout.events_stories);







        // Get the Mobile Service Table instance to use


        return  view;
    }

}
