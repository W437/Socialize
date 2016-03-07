package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;

/**
 * Created by bana on 01/03/2016.
 */
public class UserTblAdapter extends ArrayAdapter<UserTbl> {

    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public UserTblAdapter(Context context, int layoutResourceId) {
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

        final UserTbl currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

//
          TextView tvUserN=(TextView)row.findViewById(R.id.tvUserN);
          Button btExtra=(Button)row.findViewById(R.id.btExtra);
          TextView tvRole=(TextView)row.findViewById(R.id.tvRole);
         TextView tvRole2=(TextView)row.findViewById(R.id.tvRole2);
          TextView tvEmail= (TextView)row.findViewById(R.id.tvEmail);
        TextView tvEmail2= (TextView)row.findViewById(R.id.tvEmail2);
        TextView tvAddress= (TextView)row.findViewById(R.id.tvAdress);
        TextView tvAddress2= (TextView)row.findViewById(R.id.tvAdress2);


//
//        row.setTag(currentItem);
//
//        tvBegin2.setText(currentItem.getEventBegin().toString());
//        tvLocation2.setText(currentItem.getEventLocation());
        return row;
    }

}