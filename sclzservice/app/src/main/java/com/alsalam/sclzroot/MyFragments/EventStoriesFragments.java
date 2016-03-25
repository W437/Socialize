package com.alsalam.sclzroot.MyFragments;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import android.os.Bundle;

import android.app.Activity;

import android.util.Log;

import android.view.Menu;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Spinner;


import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;
import com.example.sclzservice.ToDoItem;
import com.example.sclzservice.ToDoItemAdapter;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncContext;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.ColumnDataType;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.MobileServiceLocalStoreException;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.SQLiteLocalStore;
import com.microsoft.windowsazure.mobileservices.table.sync.synchandler.SimpleSyncHandler;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.ne;
import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;
import android.widget.AdapterView.OnItemSelectedListener;
public class EventStoriesFragments extends Fragment
{
    private ListView listView;
    private Spinner spinner;

    String spin_val;
    private String[] event = new String[6];

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.events_stories,container,false);
       // init(view);
        listView= (ListView) view.findViewById(R.id.listView);
        ((MainHomeActivity)getActivity()).refreshEventsFromTable(listView,R.layout.event_card_itm);
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
