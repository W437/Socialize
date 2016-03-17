package com.alsalam.sclzroot.MyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alsalam.sclzroot.Activities.MainHomeActivity;
import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.example.sclzservice.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by samih on 27/02/2016.
 */
public class MapListFragment extends Fragment implements OnMapReadyCallback {
private   MapView mapView;
    private GoogleMap mMap;
    private ListView listView;
    private TextView tvMonth;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_map_home,container,false);

       mapView= (MapView) view.findViewById(R.id.map);
        tvMonth= (TextView) view.findViewById(R.id.tvMonth);
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        tvMonth.setText(month_name);
        EventTblAdapter eventTblAdapter=new EventTblAdapter(getActivity(),R.layout.event_card_itm);
        //eventTblAdapter.add(new EventTbl("1","Danon", new Date(2000,9,2),new Date(2003,9,2),"3",5));
        //eventTblAdapter.add(new EventTbl("1","Danon", new Date(2012,9,2),new Date(2015,9,2),"3",5));
        //eventTblAdapter.add(new EventTbl("1","Danon", new Date(2010,9,2),new Date(2012,9,2),"3",5));

       // listView.setAdapter(eventTblAdapter);


        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        listView= (ListView) view.findViewById(R.id.lstvEvetnts);
        ((MainHomeActivity)getActivity()).refreshEventsFromTable(listView,R.layout.event_card_itm);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng sydney = new LatLng(32.9943511, 35.1472984);
        mMap.addMarker(new MarkerOptions().position(sydney).title("מקיף השלום -דנון"));
        LatLng sydney1 = new LatLng(33.0155026,35.1359451);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("נהריה"));
        LatLng  sydney2 = new LatLng(32.9843018,35.1031843);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("מזרעה"));
        LatLng sydney3 = new LatLng(33.0888807,35.2339193);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("קיבוץ עברון"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
    }
}
