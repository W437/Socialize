package com.alsalam.sclzroot.MyFragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.example.sclzservice.R;

/**
 * Created by hp1 on 21/03/2016.
 */
public class ParticipatorsFragment extends DialogFragment
{

  private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.participators,container,false);
        init(view);
        // return super.onCreateView(inflater, container, savedInstanceState);
        return  view;
    }

    private void init(View view)
    {
        listView= (ListView) view.findViewById(R.id.lstvParticipants);
       // ((MainHomeActivity)getActivity()).refreshEventsParticipatedFromTable(listView,R.layout.user_card_itm);





    }

}
