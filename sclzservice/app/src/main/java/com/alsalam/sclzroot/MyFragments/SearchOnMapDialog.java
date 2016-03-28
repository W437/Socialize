package com.alsalam.sclzroot.MyFragments;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.handlers.EventsHandler;
import com.alsalam.sclzroot.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class SearchOnMapDialog extends DialogFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btn_find, btnSave, btnCancel;
    private String location;
    private MarkerOptions markerOptions;
    private LatLng latLng;
    private EventsHandler eventsHandler;
    private TextView tvSelectedLoc;
    private EditText etLocation;
    private EventTbl event;
    private EditText etEvntLoactioan;
    private SupportMapFragment mapFragment;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EventsHandler) {
            this.eventsHandler = (EventsHandler) context;
        }
    }

    @Override
    public void onDetach() {
        this.eventsHandler = null;
        mMap=null;
        super.onDetach();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        getFragmentManager().beginTransaction().remove(mapFragment).commit();
        super.onDismiss(dialog);
    }



    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_search_on_map, container, false);
        init(view);
        setListerners();
        return view;
    }

    private void init(View view) {
        etLocation = (EditText) view.findViewById(R.id.et_location);
        btn_find = (Button) view.findViewById(R.id.btn_find);
        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        tvSelectedLoc= (TextView) view.findViewById(R.id.tvSelectedLoc);
         mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        etLocation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    find();
                    handled = true;
                }
                return handled;
            }
        });
        // Getting reference to btn_find of the layout activity_main

    }

    private void setListerners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.setAddressLocation("");
                event.setLang(0);
                event.setLat(0);
                dismiss();
            }
        });
        View.OnClickListener findClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting reference to EditText to get the user input location

                find();

            }
            // Setting button click event listener for the find button

        };
        btn_find.setOnClickListener(findClickListener);
    }



    public void setSearch(EventTbl event, EditText etEvntLoactioan) {
        this.event=event;
        this.etEvntLoactioan=etEvntLoactioan;
        //etLocation.setText(etEvntLoactioan.getText());
    }

    private void find() {
        // Getting user input location
        location = etLocation.getText().toString();
      // getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        etLocation.clearFocus();
        hideSoftKeyboard();
        if(location!=null && !location.equals("")) {
            new GeocoderTask().execute(location);
        }
    }
    private void hideSoftKeyboard(){
        if(getActivity().getCurrentFocus()!=null && getActivity().getCurrentFocus() instanceof EditText){
            InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etLocation.getWindowToken(), 0);
        }
    }
    // An AsyncTask class for accessing the GeoCoding Web Service
    private class GeocoderTask extends AsyncTask<String, Void, List<Address>> {


        @Override
        protected List<Address> doInBackground(String... locationName) {
            // Creating an instance of Geocoder class
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> addresses = null;

            try {
                // Getting a maximum of 3 Address that matches the input text
                addresses = geocoder.getFromLocationName(locationName[0], 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return addresses;
        }


        @Override
        protected void onPostExecute(List<Address> addresses) {

            if (addresses == null || addresses.size() == 0) {
                Toast.makeText(getContext(), "No Location found", Toast.LENGTH_SHORT).show();
            }

            // Clears all the existing markers on the map

            mMap.clear();

            // Adding Markers on Google Map for each matching address
            for (int i = 0; i < addresses.size(); i++) {

                Address address = (Address) addresses.get(i);

                // Creating an instance of GeoPoint, to display in Google Map
                latLng = new LatLng(address.getLatitude(), address.getLongitude());

                String addressText = String.format("%s, %s",
                        address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                        address.getCountryName());

                markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(addressText);
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        tvSelectedLoc.setText(marker.getTitle()+marker.getPosition().toString());
                        etEvntLoactioan.setText(marker.getTitle());
                        event.setAddressLocation(marker.getTitle());
                        event.setLang(marker.getPosition().longitude);
                        event.setLat(marker.getPosition().latitude);
                        return true;
                    }
                });
                mMap.addMarker(markerOptions);

                // Locate the first location
                if (i == 0) {

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
                    tvSelectedLoc.setText(addressText);
                    etEvntLoactioan.setText(addressText);
                    event.setAddressLocation(addressText);
                    event.setLang(latLng.longitude);
                    event.setLat(latLng.latitude);
                }
            }


            /**
             * Manipulates the map once available.
             * This callback is triggered when the map is ready to be used.
             * This is where we can add markers or lines, add listeners or move the camera. In this case,
             * we just add a marker near Sydney, Australia.
             * If Google Play services is not installed on the device, the user will be prompted to install
             * it inside the SupportMapFragment. This method will only be triggered once the user has
             * installed Google Play services and returned to the app.
             */
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


                // Add a marker in Sydney and move the camera
               // LatLng sydney = new LatLng(-34, 151);
                //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
               // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        }
