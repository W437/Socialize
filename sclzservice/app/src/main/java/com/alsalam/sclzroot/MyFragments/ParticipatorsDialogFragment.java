package com.alsalam.sclzroot.MyFragments;

import android.annotation.SuppressLint;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ListView;

import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.R;

/**
 * Created by hp1 on 15/03/2016.
 */
public class ParticipatorsDialogFragment extends DialogFragment
{

    //protected EventsHandler eventsHandler;
    private ListView lstvParticipants;
    EventTbl currentItem;
    private UserTblAdapter userTblAdapter;

    @SuppressLint("ValidFragment")
    public ParticipatorsDialogFragment(EventTbl currentItem) {
        super();
        this.currentItem=currentItem;

    }





    protected void init(View view)
    {
        lstvParticipants =(ListView)view.findViewById(R.id.lstvParticipants);
        if(userTblAdapter==null) userTblAdapter=new UserTblAdapter(getContext(),R.layout.user_card_itm);
        lstvParticipants.setAdapter(userTblAdapter);
        ((MainpageActivity) getActivity()).refreshAllUsersFromTableToEvent(userTblAdapter, currentItem.getId());

        // lstvParticipants.setAdapter(userTblAdapter);

    }




}
