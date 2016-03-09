package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.example.sclzservice.R;

/**
 * Created by hp1 on 08/03/2016.
 */
public class EventsToParticipate extends Fragment
{
    private ListView listView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_to_participate, container, false);
        init(view);

        listView3= (ListView) view.findViewById(R.id.lstvEventsTo);
        EventTblAdapter eventTblAdapter=new EventTblAdapter(getContext(),R.layout.event_card_itm);


        listView3.setAdapter(eventTblAdapter);


        return view;
    }
    protected void init(View view)
    {



    }

}
