package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageButton;
import android.widget.TextView;

import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.MyFragments.JoinEventDialog;
import com.alsalam.sclzroot.MyFragments.ParticipatorsDialogFragment;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.R;

import java.text.SimpleDateFormat;

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
    private String time;
//    private ImageButton btDel;
//    private ImageButton btEdit;
//    private ImageButton btAccept,btRefused;

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

        //final TextView eventTitle=(TextView)row.findViewById(R.id.eventTitle);
        ImageButton btMore= (ImageButton) row.findViewById(R.id.btMore);
        ImageButton btPartic=(ImageButton)row.findViewById(R.id.btPartic);
        TextView tvTitle=(TextView)row.findViewById(R.id.tvTitle);
        TextView tvDescription=(TextView)row.findViewById(R.id.tvDescription);
        TextView tvAddress=(TextView)row.findViewById(R.id.tvAddress);
        TextView tvTime=(TextView)row.findViewById(R.id.tvTime);
        TextView tvStatus=(TextView)row.findViewById(R.id.tvStatus);

        row.setTag(currentItem);
        tvTitle.setText(currentItem.getTitle());
        tvDescription.setText(currentItem.getDescription());
        tvAddress.setText(currentItem.getAddressLocation());
        if (currentItem.getDate() != null) {
            //  time = DateFormat.getDateFormat(getContext()).format(currentItem.getDate());
             SimpleDateFormat df = new SimpleDateFormat(); //called without pattern
            tvTime.setText(df.format(currentItem.getDate()));
        }

        if (currentItem.getStatus().equals(EventTbl.WAITING))

            tvStatus.setText(mContext.getResources().getString(R.string.Waiting_to_approval));

        if (currentItem.getStatus().equals(EventTbl.ACCEPTED))

            tvStatus.setText(mContext.getResources().getString(R.string.ACCEPTED));

        if (currentItem.getStatus().equals(EventTbl.CANCELED))

            tvStatus.setText(mContext.getResources().getString(R.string.CANCELED));

        if (currentItem.getStatus().equals(EventTbl.REJECTED))

            tvStatus.setText(mContext.getResources().getString(R.string.REJECTED));

        btPartic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 showParDialog(currentItem);
            }
        });




        btMore.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                showDialog(currentItem);


            }

        });



        if( mLayoutResourceId==R.layout.my_event_card_itm)
        {
            ImageButton btDel = (ImageButton) row.findViewById(R.id.delEven);
            ImageButton btEdit = (ImageButton) row.findViewById(R.id.btEdit);
            View.OnClickListener clickListener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            };
            btDel.setOnClickListener(clickListener);
            btEdit.setOnClickListener(clickListener);
        }
        if( mLayoutResourceId==R.layout.event_to_accept)
        {
            final ImageButton btRefused = (ImageButton) row.findViewById(R.id.btRefused);
            final ImageButton btAccept=(ImageButton)row.findViewById(R.id.btAccept);
            View.OnClickListener clickListener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v==btAccept)
                    {
                        currentItem.setStatus(EventTbl.ACCEPTED);
                        ((MainpageActivity)mContext).updateEvent(currentItem);
                    }
                    if(v==btRefused)
                    {
                        currentItem.setStatus(EventTbl.REJECTED);
                        ((MainpageActivity)mContext).updateEvent(currentItem);
                    }
                }
            };
            btRefused.setOnClickListener(clickListener);
            btRefused.setOnClickListener(clickListener);
        }

        return row;
    }

        void showParDialog(EventTbl currentItem){
            ParticipatorsDialogFragment participatorsFragment =new ParticipatorsDialogFragment(currentItem);
             participatorsFragment.show(fragmentManager,"AAAA");
        }

      void showDialog(EventTbl currentItem) {
        JoinEventDialog joinEvent=new JoinEventDialog(currentItem);
        joinEvent.show(fragmentManager,"kkkkk");
    }





}