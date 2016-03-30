package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.R;

/**
 * Created by hp1 on 08/03/2016.
 */
public class MyEventsFragment extends Fragment
{
    private ListView listView2;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_events_fragments,container,false);
        init(view);




        listView= (ListView) view.findViewById(R.id.lstvMyEvent);
        ((MainpageActivity)getActivity()).refreshEventsFromTable(listView, R.layout.event_card_itm);



        return  view;
    }

    protected void init(View view) {


    }


}
