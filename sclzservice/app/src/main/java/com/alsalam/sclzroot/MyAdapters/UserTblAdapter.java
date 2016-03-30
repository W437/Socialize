package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.R;

/**
 * Created by bana on 01/03/2016.
 */
public class UserTblAdapter extends ArrayAdapter<UserTbl> implements RadioGroup.OnCheckedChangeListener {

    /**
     * Adapter context
     */
    Context mContext;
    private RadioGroup radioGroup;
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

        final TextView tvUserN=(TextView)row.findViewById(R.id.tvUserN);
        ImageButton btExtra=(ImageButton)row.findViewById(R.id.btExtra);
         TextView statTv2=(TextView)row.findViewById(R.id.statTv2);
        TextView tvEmail2=(TextView)row.findViewById(R.id.statTv);
        TextView tvRole2=(TextView)row.findViewById(R.id.tvRole2);
        final TextView tvAdress2=(TextView)row.findViewById(R.id.tvAdress2);
        TextView tvEmail=(TextView)row.findViewById(R.id.tvEmail);
        TextView tvAdrerss2=(TextView)row.findViewById(R.id.tvAdrerss);
        EditText etPhone=(EditText)row.findViewById(R.id.etPhone);
        TextView tvBirth=(TextView)row.findViewById(R.id.tvBirth);

     if(mLayoutResourceId==R.layout.my_user_card_itm) {
         RadioGroup  radioGroup=(RadioGroup)row.findViewById(R.id.radioGroup);
         RadioButton Wait = (RadioButton) row.findViewById(R.id.radioButton1);
         RadioButton Maneger = (RadioButton) row.findViewById(R.id.radioButton2);
         RadioButton Teenager = (RadioButton) row.findViewById(R.id.radioButton3);
         RadioButton Coordinator = (RadioButton) row.findViewById(R.id.radioButton4);
         RadioButton Guide = (RadioButton) row.findViewById(R.id.radioButton5);

         radioGroup.setOnCheckedChangeListener(this);
         if (currentItem.getUserTafkeed().equals(UserTbl.Guide)) {
             Guide.setChecked(true);
         }
         if (currentItem.getUserTafkeed().equals(UserTbl.Maneger)) {
             Maneger.setChecked(true);
         }
         if (currentItem.getUserTafkeed().equals(UserTbl.Teenager)) {
             Teenager.setChecked(true);
         }
         if (currentItem.getUserTafkeed().equals(UserTbl.Wait)) {
             Wait.setChecked(true);
         }
         if (currentItem.getUserTafkeed().equals(UserTbl.Coordinator)) {
             Coordinator.setChecked(true);
         }
     }
        row.setTag(currentItem);
        statTv2.setText(currentItem.getStatus());
        tvEmail2.setText(currentItem.getUserEmail());
        tvAdress2.setText(currentItem.getUserAddress());

        tvRole2.setText(currentItem.getUserTafkeed());
        tvUserN.setText(currentItem.getUserName());
        tvEmail.setText(currentItem.getUserEmail());
        tvAdrerss2.setText(currentItem.getUserAddress());
        etPhone.setText(currentItem.getUserPhone());
        tvUserN.setText(currentItem.getFirstName());
        String date="";
        if(currentItem.getUserBirthday()!=null)
             date= DateFormat.getDateFormat(getContext()).format(currentItem.getUserBirthday());
        tvBirth.setText(date);

        btExtra.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String adress = tvAdress2.getText().toString();

                Toast.makeText(getContext(), "adress" + adress.toString(), Toast.LENGTH_LONG).show();


            }

        });

        return row;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Toast.makeText(getContext(), "wait" +radioGroup.toString(), Toast.LENGTH_LONG).show();


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