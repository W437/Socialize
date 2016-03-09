package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.events_stories,container,false);
        init(view);


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

    private void init(View view)
    {
        final EventTblAdapter  mAdapter=new EventTblAdapter(getContext(),18 );
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                try {

                    final MobileServiceList<EventTbl> result =  mToDoTable.execute().get();
                    getActivity().runOnUiThread(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            mAdapter.clear();
                            for (EventTbl item : result)
                            {
                                mAdapter.add(item);
                            }
                        }
                    });
                }
                catch (Exception exception)
                {

                }
                return null;
            }

        }.execute();







    }
}
