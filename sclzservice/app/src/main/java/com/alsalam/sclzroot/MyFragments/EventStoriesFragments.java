package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.handlers.Refrashable;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.ne;
import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;

public class EventStoriesFragments extends Fragment implements Refrashable
{
    private ListView listView;
    private Spinner spinner;

    String spin_val;
    private String[] event;
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
        if(event==null)event = new String[5];
        event[1] =getResources().getString(R.string.all_events);
        event[2]=getResources().getString(R.string.accepted_events);
        event[0]=getResources().getString(R.string.waiting_to_confirm);
        event[3]=getResources().getString(R.string.events_according_time);
       // event[4]=getResources().getString(R.string.events_according_my_location);
        event[4]=getResources().getString(R.string.past_events);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter);
                        break;
                    case 0:
                        ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter, EventTbl.WAITING);
                        break;
                    case 2:
                        ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter, EventTbl.ACCEPTED);
                        break;
                    case 3:
                        ((MainpageActivity)getActivity()).refreshEventsFromTableOrederByDate(eventTblAdapter);
                        break;
                    case 4:
                        ((MainpageActivity)getActivity()).refreshPastEventsFromTableOrederByDate(eventTblAdapter);

                        break;
                    case 5:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




//setting array adaptors to spinners

//ArrayAdapter is a BaseAdapter that is backed by an array of arbitrary objects

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, event);

// setting adapters to spinners

        spinner.setAdapter(spin_adapter);


       /// ((MainHomeActivity)((MainHomeActivity) getActivity()).refreshEventsFromTable(spinner,R.layout.events_stories);







        // Get the Mobile Service Table instance to use


        return  view;
    }

    @Override
    public void refresh() {
        switch (spinner.getSelectedItemPosition())
        {
            case 1:
                ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter);
                break;
            case 0:
                ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter, EventTbl.WAITING);
                break;
            case 2:
                ((MainpageActivity)getActivity()).refreshEventsFromTable(eventTblAdapter, EventTbl.ACCEPTED);
                break;
            case 3:
                ((MainpageActivity)getActivity()).refreshEventsFromTableOrederByDate(eventTblAdapter);
                break;
            case 4:
                ((MainpageActivity)getActivity()).refreshPastEventsFromTableOrederByDate(eventTblAdapter);

                break;
            case 5:
                break;

        }
    }
}
