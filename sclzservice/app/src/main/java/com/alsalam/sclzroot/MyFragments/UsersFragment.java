package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.R;
import com.example.sclzservice.ToDoItem;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

public class UsersFragment extends Fragment {
    private MobileServiceClient mClient;
    private Spinner spinner;

    String spin_val;
    private String[] user = new String[4];

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<UserTbl> mToDoTable;
    ListView listView;
    UserTblAdapter userTblAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_users, container, false);
        listView= (ListView) view.findViewById(R.id.listView);
        ((MainHomeActivity)getActivity()).refreshAllUsersFromTable(listView, R.layout.user_card_itm);
        spinner=(Spinner)view.findViewById(R.id.spinner_id);
        user[0] =getResources().getString(R.string.Guide);
        user[1]=getResources().getString(R.string.Waiting_to_approval);
        user[2]=getResources().getString(R.string.Coordinators);
         user[3]=getResources().getString(R.string.Maneger);

//        try {
//            mClient = new MobileServiceClient(
//                    "https://sclzservice.azurewebsites.net",
//                    getContext());
//            mToDoTable = mClient.getTable(UserTbl.class);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        // Get the Mobile Service Table instance to use
//

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, user);

// setting adapters to spinners

        spinner.setAdapter(spin_adapter);

        return  view;


    }



//    protected void intit(View view)
//    {
//        final UserTblAdapter mAdapter=new UserTblAdapter(getContext(),18 );
//        new AsyncTask<Void, Void, Void>() {
//
//            @Override
//            protected Void doInBackground(Void... params)
//            {
//
//                try
//                {
//
//                    final MobileServiceList<UserTbl> result = mToDoTable.execute().get();
//                    getActivity().runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            mAdapter.clear();
//                            for (UserTbl item : result)
//                            {
//                                mAdapter.add(item);
//                            }
//                        }
//                    });
//
//                }
//                catch (Exception exception)
//                {
//
//                }
//                return null;
//
//
//            }
//        }.execute();
//
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params)
//            {
//                try {
//                    final MobileServiceList<UserTbl> result =
//                            mToDoTable.where().field("complete").eq(false).execute().get();
//                    for (UserTbl item : result) {
//                        Log.i("Users", "Read object with ID " + item.getId());
//                    }
//                }
//                catch (Exception exception)
//                {
//
//                }
//                return null;
//            }
//        }.execute();
//
//
//    }


}
