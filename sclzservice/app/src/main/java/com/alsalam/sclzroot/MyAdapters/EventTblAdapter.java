package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.alsalam.sclzroot.MyFragments.JoinEventDialog;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;

import static android.app.PendingIntent.getActivity;

/**
 * Created by bana on 01/03/2016.
 */
public class EventTblAdapter extends ArrayAdapter<EventTbl> {

    FragmentManager fragmentManager;
    /**
     *       Adapter context
     */
    Context mContext;

    /**
     *
     * Adapter View layout
     */
    int mLayoutResourceId;

    public EventTblAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
        if(null==fragmentManager){
            fragmentManager=((AppCompatActivity)context).getSupportFragmentManager();
        }
    }

    public EventTblAdapter(Context context,int mLayoutResourceId,FragmentManager fragmentManager)
    {
        this(context,mLayoutResourceId);
        this.fragmentManager=fragmentManager;
    }
    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final EventTbl currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        final TextView eventTitle=(TextView)row.findViewById(R.id.eventTitle);
        Button btMore=(Button)row.findViewById(R.id.btMore);

        TextView tvEventT=(TextView)row.findViewById(R.id.eventTitle);
        TextView tvSummary2=(TextView)row.findViewById(R.id.summary2);
        TextView tvAdress2=(TextView)row.findViewById(R.id.tvAdress2);


        row.setTag(currentItem);

     //   tvBegin2.setText(currentItem.getEventBegin().toString());
      //tvAdress2.setText(currentItem.getAddress());
        //tvSummary2.setText(currentItem.getEventPurpose());
        tvEventT.setText(currentItem.getEventTitle());
        btMore.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                    showDialog();

            }

        });


        return row;
    }
    void showDialog () {
        // Create the fragment and show it as a dialog.
        JoinEventDialog joinEvent=new JoinEventDialog();
        joinEvent.show(fragmentManager,"kkkkk");
    }

}