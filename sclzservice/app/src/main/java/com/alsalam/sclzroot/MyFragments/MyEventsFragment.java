package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.example.sclzservice.R;

/**
 * Created by hp1 on 08/03/2016.
 */
public class MyEventsFragment extends Fragment
{
    private ListView listView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_events_fragments,container,false);
        init(view);


        listView2= (ListView) view.findViewById(R.id.lstvMyEvent);

        EventTblAdapter eventTblAdapter=new EventTblAdapter(getContext(),R.layout.event_card_itm);

        listView2.setAdapter(eventTblAdapter);



        return  view;
    }

    protected void init(View view) {


    }


}
