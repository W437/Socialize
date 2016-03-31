package com.alsalam.sclzroot.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.R;

/**
 * Created by bana on 01/03/2016.
 */
public class UserTblAdapter extends ArrayAdapter<UserTbl> {

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

        final TextView tvUserN = (TextView) row.findViewById(R.id.tvUserN);


        TextView tvEmail = (TextView) row.findViewById(R.id.tvEmail);
        TextView tvAddress = (TextView) row.findViewById(R.id.tvAddress);
        TextView etPhone = (TextView) row.findViewById(R.id.tvPhone);
        TextView tvBirth = (TextView) row.findViewById(R.id.tvBirth);
        TextView tvTafkeed = (TextView) row.findViewById(R.id.tvTafkeed);

        row.setTag(currentItem);
        tvAddress.setText(currentItem.getUserAddress());

        tvTafkeed.setText(currentItem.getUserTafkeed());
        tvEmail.setText(currentItem.getUserEmail());

        etPhone.setText(currentItem.getUserPhone());
        tvUserN.setText(currentItem.getFirstName());
        String date = "";
        if (currentItem.getUserBirthday() != null)
            date = DateFormat.getDateFormat(getContext()).format(currentItem.getUserBirthday());
        tvBirth.setText(date);

        if (mLayoutResourceId == R.layout.user_card_toconfirm_itm) {
            RadioGroup radioGroup = (RadioGroup) row.findViewById(R.id.radioGroup);
            RadioButton Wait = (RadioButton) row.findViewById(R.id.rbWait);
            RadioButton Maneger = (RadioButton) row.findViewById(R.id.rbManeger);
            RadioButton Teenager = (RadioButton) row.findViewById(R.id.rbYoung);
            RadioButton Coordinator = (RadioButton) row.findViewById(R.id.rbRkaz);
            RadioButton Guide = (RadioButton) row.findViewById(R.id.rbGuid);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Toast.makeText(getContext(), "checkedId:" + checkedId, Toast.LENGTH_LONG).show();
                }
            });
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
        if (mLayoutResourceId == R.layout.event_to_accept) {
            TextView tvStatus = (TextView) row.findViewById(R.id.tvStatus);
            tvStatus.setText(currentItem.getStatus());

            final ImageButton btnAccept = (ImageButton) row.findViewById(R.id.btAccept);
            final ImageButton btnRefused = (ImageButton) row.findViewById(R.id.btRefused);
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == btnAccept) {
                        // TODO update gustevent
                    }
                    if (v == btnRefused) {
                        // TODO update gustevent
                    }
                }
            };
            btnAccept.setOnClickListener(clickListener);
            btnRefused.setOnClickListener(clickListener);

        }


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