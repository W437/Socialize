package com.alsalam.sclzroot.Activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alsalam.sclzroot.TableManager.TestTbl;
import com.example.sclzservice.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;


import java.net.MalformedURLException;

public class HomeMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MobileServiceClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_home);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        GoogleMapOptions mapOptions=new GoogleMapOptions();
//        mapOptions.liteMode(true);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //testing userTBL
        try {

            mClient = new MobileServiceClient("https://sclzservice.azurewebsites.net",getBaseContext());
            TestTbl tbl=new TestTbl();
            MobileServiceTable<TestTbl> mtable = mClient.getTable(TestTbl.class);
            mtable.insert(tbl, new TableOperationCallback<TestTbl>() {
                @Override
                public void onCompleted(TestTbl entity, Exception exception, ServiceFilterResponse response) {
                    if(exception==null)
                    {
                        Toast.makeText(getBaseContext(),"okkkkkkk",Toast.LENGTH_LONG).show();
                        Log.d("azure","OKKKKK");
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"nooooo",Toast.LENGTH_LONG).show();
                        Log.d("azure", "nooooo");
                    }
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
