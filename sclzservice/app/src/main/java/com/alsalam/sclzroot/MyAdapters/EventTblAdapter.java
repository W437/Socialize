package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;

/**
 * Created by bana on 01/03/2016.
 */
public class EventTblAdapter extends ArrayAdapter<EventTbl> {

    /**
     *       Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public EventTblAdapter(Context context, int layoutResourceId) {
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

        TextView tvBegin2=(TextView)row.findViewById(R.id.tvBeginning2);
        Button btMore=(Button)row.findViewById(R.id.btMore);

        TextView tvEventT=(TextView)row.findViewById(R.id.tvEventT);
        TextView tvSummary2=(TextView)row.findViewById(R.id.tvSummary2);
        TextView tvAdress2=(TextView)row.findViewById(R.id.tvAdress2);


        row.setTag(currentItem);

        tvBegin2.setText(currentItem.getEventBegin().toString());
      tvAdress2.setText(currentItem.getAdress());
        tvSummary2.setText(currentItem.getEventSummary());
        tvEventT.setText(currentItem.getEventTitle());

        btMore.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


            }

        });

        return row;
    }


}