package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;
import com.example.sclzservice.ToDoActivity;
import com.example.sclzservice.ToDoItem;

import java.util.ArrayList;

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


        TextView tvBegin2=(TextView)row.findViewById(R.id.tvBegin);
        Button btMore=(Button)row.findViewById(R.id.btMore);
        TextView tvLocation2=(TextView)row.findViewById(R.id.tvLocation2);

        row.setTag(currentItem);

        tvBegin2.setText(currentItem.getEventBegin().toString());
        tvLocation2.setText(currentItem.getEventLocation());
        return row;
    }

}