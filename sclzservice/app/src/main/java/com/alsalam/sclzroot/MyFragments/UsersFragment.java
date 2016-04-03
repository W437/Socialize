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
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.handlers.Refrashable;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

public class UsersFragment extends Fragment implements Refrashable {
    private MobileServiceClient mClient;
    private Spinner spinner;

    String spin_val;
    private String[] user = new String[5];

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
        if(userTblAdapter==null) userTblAdapter=new UserTblAdapter(getContext(),R.layout.user_card_toconfirm_itm);
        listView.setAdapter(userTblAdapter);
        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter, "all");

        spinner=(Spinner)view.findViewById(R.id.apnrTafked);
        int i=0;
        user[i++]=getResources().getString(R.string.ALL_USERS);
        user[i++]=getResources().getString(R.string.Waiting_to_approval);
        user[i++]=getResources().getString(R.string.Maneger);
        user[i++]=getResources().getString(R.string.Coordinators);
        user[i++] =getResources().getString(R.string.Guide);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,"all");
                        break;
                    case 1:
                        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Wait);

                        break;
                    case 2:
                        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Maneger);

                        break;
                    case 3:
                        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Coordinator);

                        break;
                    case 4:
                        ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Guide);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

    @Override
    public void refresh() {
            switch (spinner.getSelectedItemPosition())
    {
        case 0:
            ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,"all");
            break;
        case 1:
            ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Wait);

            break;
        case 2:
            ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Maneger);

            break;
        case 3:
            ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Coordinator);

            break;
        case 4:
            ((MainpageActivity) getActivity()).refreshAllUsersFromTable(userTblAdapter,UserTbl.Guide);

            break;
    }


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