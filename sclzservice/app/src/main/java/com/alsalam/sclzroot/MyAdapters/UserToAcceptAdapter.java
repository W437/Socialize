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

import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;

/**
 * Created by bana on 01/03/2016.
 */
public class UserToAcceptAdapter extends ArrayAdapter<UserTbl> {

    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public UserToAcceptAdapter(Context context, int layoutResourceId) {
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

        final TextView tvUserN=(TextView)row.findViewById(R.id.tvTitle);
        ImageButton btDisAccept=(ImageButton)row.findViewById(R.id.btDisAccept);
        ImageButton btAccept=(ImageButton)row.findViewById(R.id.btAccept);
        TextView tvEmail2=(TextView)row.findViewById(R.id.statTv);
        TextView tvRole2=(TextView)row.findViewById(R.id.tvRole2);
        final TextView tvAdress2=(TextView)row.findViewById(R.id.tvAdress2);


        row.setTag(currentItem);

        tvEmail2.setText(currentItem.getUserEmail().toString());
        tvAdress2.setText(currentItem.getUserAddress().toString());
        tvRole2.setText(currentItem.getUserTafkeed().toString());
        tvUserN.setText(currentItem.getFirstName().toString());

        btAccept.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String adress = tvAdress2.getText().toString();

                Toast.makeText(getContext(), "adress" + adress.toString(), Toast.LENGTH_LONG).show();


            }

        });
        btDisAccept.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String adress = tvAdress2.getText().toString();

                Toast.makeText(getContext(), "adress" + adress.toString(), Toast.LENGTH_LONG).show();


            }

        });

        return row;
    }


//TextView tvEmail2=(TextView)itemView.findViewById(R.id.tvSummary2);
       // TextView tvRole2=(TextView)itemView.findViewById(R.id.tvRole2);
       // TextView tvUserN=(TextView)itemView.findViewById(R.id.tvEventT);
       // TextView tvAdress2=(TextView)itemView.findViewById(R.id.tvAdress2);
        //Button btExtra=(Button)itemView.findViewById(R.id.btExtra);

       // UserTbl u=userTbls.get(position);
       // tvAdress2.setText(u.getUserAddress().toString());

       // tvEmail2.setText(u.getUserEmail().toString());
       // tvRole2.setText(u.getUserTafkeed().toString());
       // tvUserN.setText(u.getLastName().toString());
       // btExtra.setOnClickListener(new View.OnClickListener() {


         //   @Override
          //  public void onClick(View v) {

                // String tvEmail = tvEmail2.getText().toString();
              //  Toast.makeText(getContext(), "EMil" , Toast.LENGTH_LONG).show();

          //  }

        //});

       // return itemView;
   // }

//        TextView tvBegin2=(TextView)row.findViewById(R.id.tvBegin);
//        Button btMore=(Button)row.findViewById(R.id.btMore);
//        TextView tvLocation2=(TextView)row.findViewById(R.id.tvLocation2);
//
//        row.setTag(currentItem);
//
//        tvBegin2.setText(currentItem.getEventBegin().toString());
//        tvLocation2.setText(currentItem.getAddressLocation());
        

}