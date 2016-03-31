package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.TableManager.EventTbl;

/**
 * Created by bana on 01/03/2016.
 */
public class EventToAceeptAdapter extends ArrayAdapter<EventTbl> {

    /**
     *       Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout f
     */
    int mLayoutResourceId;

    public EventToAceeptAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
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

        TextView tvTime2=(TextView)row.findViewById(R.id.tvTime2);
        ImageButton btDisAccept=(ImageButton)row.findViewById(R.id.btRefused);
        ImageButton btAccept=(ImageButton)row.findViewById(R.id.btAccept);

        TextView tvTitle=(TextView)row.findViewById(R.id.tvTitle);
        TextView tvDescription=(TextView)row.findViewById(R.id.tvDescription);
        TextView tvAdress2=(TextView)row.findViewById(R.id.tvAdress2);

        tvTime2.setText(currentItem.getDate().toString());
        tvAdress2.setText(currentItem.getAddressLocation().toString());
        tvDescription.setText(currentItem.getDescription().toString());
        tvTitle.setText(currentItem.getTitle().toString());

        btAccept.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {


                //String tvSummary12=tvSummary2.getText().toString();

                Toast.makeText(getContext(),"SUMMARY"  ,Toast.LENGTH_LONG).show();



            }

        });
        btDisAccept.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //String tvSummary12=tvSummary2.getText().toString();

                Toast.makeText(getContext(), "SUMMARY", Toast.LENGTH_LONG).show();


            }

        });

        row.setTag(currentItem);

        tvTime2.setText(currentItem.getDate().toString());
      //tvAdress2.setText(currentItem.getAddress().toString());
        //tvSummary2.setText(currentItem.getEventPurpose().toString());
        tvTitle.setText(currentItem.getTitle().toString());

        return row;
    }


}