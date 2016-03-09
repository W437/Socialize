package com.alsalam.sclzroot.MyAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.roomorama.caldroid.CaldroidGridAdapter;

import java.util.Map;

/**
 * Created by hp1 on 09/03/2016.
 */
public class CalenAdapter  extends CaldroidGridAdapter
{


    /**
     * Constructor
     *
     * @param context
     * @param month
     * @param year
     * @param caldroidData
     * @param extraData
     */
    public CalenAdapter(Context context, int month, int year, Map<String, Object> caldroidData, Map<String, Object> extraData) {
        super(context, month, year, caldroidData, extraData);
    }


  //    public  View  getView(int position, View convertView, ViewGroup parent){


    //  }


}
