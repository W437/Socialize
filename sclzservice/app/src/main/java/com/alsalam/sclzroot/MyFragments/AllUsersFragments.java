package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;

/**
 * Created by hp1 on 07/03/2016.
 */
public class AllUsersFragments extends  Fragment
{
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.all_users,container,false);
        init(view);

        listView= (ListView) view.findViewById(R.id.lstvUsers);
        //
        //
        //

        UserTblAdapter userTblAdapter =new UserTblAdapter(getContext(),R.layout.user_card_itm);

        listView.setAdapter(userTblAdapter);

        return  view;
    }

    private void init(View view)
    {


    }


}
