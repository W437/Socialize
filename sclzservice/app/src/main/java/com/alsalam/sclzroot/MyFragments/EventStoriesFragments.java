package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sclzservice.R;

public class EventStoriesFragments extends Fragment
{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.events_stories,container,false);
        init(view);

        return  view;
    }

    private void init(View view)
    {


    }
}
