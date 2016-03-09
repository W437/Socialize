package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;
import com.example.sclzservice.ToDoItem;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

public class EventStoriesFragments extends Fragment
{
    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<EventTbl> mToDoTable;
    ListView  listView;
    EventTblAdapter eventTblAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.events_stories,container,false);

        eventTblAdapter=new EventTblAdapter(getContext(),R.layout.event_card_itm);
        listView= (ListView) view.findViewById(R.id.listView);
        init();
        listView.setAdapter(eventTblAdapter);


        try {
            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    getContext());
            mToDoTable = mClient.getTable(EventTbl.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Get the Mobile Service Table instance to use


        return  view;
    }

    private void init()
    {
        Log.d("INITBH"," init starts");

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                try {
                    Log.d("INITBH","doInBackground ");

                    final MobileServiceList<EventTbl> result =  mToDoTable.execute().get();
                    Log.d("INITBH",result.size()+" befor runonui size");

                    getActivity().runOnUiThread(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            eventTblAdapter.clear();
                            Log.d("INITBH", result.size() + " size");
                            for (EventTbl item : result)
                            {
                                eventTblAdapter.add(item);

                            }
                        }
                    });
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                return null;
            }

        }.execute();
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params) {
//                try {
//                    final MobileServiceList<EventTbl> result =
//                            mToDoTable.where().field("complete").eq(false).execute().get();
//                    for (EventTbl item : result) {
//                        Log.i("Evnts", "Read object with ID " + item.getId());
//                    }
//                } catch (Exception exception)
//                {
//
//                }
//                return null;
//            }
//        }.execute();

    }
}
