package com.alsalam.sclzroot.MyFragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.handlers.Refrashable;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Calendar;
import java.util.Date;

public class CalendarFragment extends Fragment implements Refrashable {


    CaldroidFragment caldroidFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_calendar,container,false);
        intit(view);

         caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        caldroidFragment.setCaldroidListener(listener);
        Date date=new Date(20,3,2016);

        ColorDrawable green = new ColorDrawable(Color.GREEN);
        caldroidFragment.setBackgroundDrawableForDate(green, new Date(2,4,2016));
     //   caldroidFragment.setBackgroundDrawableForDate(green, greenDate);

      //  caldroidFragment.setTextColorForDate(R.color.white, blueDate);
       // caldroidFragment.setTextColorForDate(R.color.white, greenDate);


        // caldroidFragment.setBackgroundDrawableForDate(green,date);
        caldroidFragment.setBackgroundDrawableForDate(green,new  Date(2016,3,19));

        FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar, caldroidFragment);
        t.commit();


        return view;
    }



    private void intit(View view) {


    }

    final CaldroidListener listener = new CaldroidListener() {

        @Override
        public void onSelectDate(Date date, View view) {
            Toast.makeText(getActivity(),date.toString(),
                    Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onLongClickDate(Date date, View view) {
            Toast.makeText(getActivity(),date.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    };

    @Override
    public void refresh() {

    }
};



