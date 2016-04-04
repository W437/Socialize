package com.alsalam.sclzroot.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
import com.alsalam.sclzroot.MyFragments.AddEventFragment;
import com.alsalam.sclzroot.MyFragments.CalendarFragment;
import com.alsalam.sclzroot.MyFragments.EventStoriesFragments;
import com.alsalam.sclzroot.MyFragments.JoinEventDialog;
import com.alsalam.sclzroot.MyFragments.MapListFragment;
import com.alsalam.sclzroot.MyFragments.MyEventsFragment;
import com.alsalam.sclzroot.MyFragments.UsersFragment;
import com.alsalam.sclzroot.TableManager.DataBaseMngr;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.GuestsToEvent;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.handlers.EventsHandler;
import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.handlers.MyHandler;
import com.alsalam.sclzroot.handlers.Refrashable;
import com.example.sclzservice.ToDoItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;


import com.google.android.gms.gcm.*;
import com.microsoft.windowsazure.messaging.*;
import com.microsoft.windowsazure.mobileservices.table.query.QueryOrder;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.net.URLEncoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import android.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class MainpageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,EventsHandler {

    ViewPager viewPager;
    Fragment[] fragments;
    MyPagerAdatpter myPagerAdatpter;
    TabLayout tabLayout;

    private String SENDER_ID = "7025779782";
    private GoogleCloudMessaging gcm;
    private NotificationHub hub;
    private String HubName = "samih_hub";
    private String HubListenConnectionString = "Endpoint=sb://samihnamespace.servicebus.windows.net/;SharedAccessKeyName=DefaultListenSharedAccessSignature;SharedAccessKey=LGmW1DkDanDORII/f3RZ8f5gpTYqXhtnUCZCYjRdTxY=";
    private static Boolean isVisible = false;

    private String HubEndpoint = null;
    private String HubSasKeyName = null;
    private String HubSasKeyValue = null;
    private String HubFullAccess = "Endpoint=sb://samihnamespace.servicebus.windows.net/;SharedAccessKeyName=DefaultFullSharedAccessSignature;SharedAccessKey=QS4g4cxA2Z9z5UzXayiO226sLz7N3OcHlMIVRGDSWlQ=";

    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<EventTbl> msEventTbl;
    private MobileServiceTable<UserTbl> msUsertTbl;
    private MobileServiceTable<GuestsToEvent> msGuestsToEvent;

//    private EventTblAdapter mEventAdapter;
//    private EventTblAdapter mEventAdapterById;
//    private UserTblAdapter mAllUserTblAdapter;

    private ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                viewPager.setCurrentItem(2);
                fab.setVisibility(View.GONE);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        viewPager= (ViewPager) findViewById(R.id.homepager);
        viewPager.setOffscreenPageLimit(8);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
        //rgLocation = (RadioGroup) findViewById(R.id.rgLocation);
        initRemoteData();
        initForPush();




        //to do
        fragments=new Fragment[6];
        int i=0;
        fragments[0]=new MapListFragment();//
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_map));

        fragments[1]=new MyEventsFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_my_event));

        fragments[2]=new AddEventFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_add_event));


        fragments[3]=new EventStoriesFragments();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_history));

        fragments[4]=new UsersFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_users));




//        fragments[5]=new Profile2Fragment();
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_profile));



        fragments[5]=new CalendarFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_calendar));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(fragments[tab.getPosition()]instanceof Refrashable)
                {
                    ((Refrashable)fragments[tab.getPosition()]).refresh();
                }
                if(tab.getPosition()==2)
                    fab.setVisibility(View.GONE);
                else
                    fab.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        myPagerAdatpter=new MyPagerAdatpter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdatpter);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.mainpage, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Profile)
        {
           // startActivity(new Intent(getBaseContext(), Profile2Fragment.class));


            // Handle the camera action
        }

        else if (id == R.id.nav_ChangePass)
        {


        }
        else if (id == R.id.nav_logout)
        {

            DataBaseMngr.logOut(this);
            startActivity(new Intent(this, LoginActivity.class));
            //finish();


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initForPush() {
        MyHandler.mainActivity = this;
        NotificationsManager.handleNotifications(this, SENDER_ID, MyHandler.class);
        gcm = GoogleCloudMessaging.getInstance(this);
        hub = new NotificationHub(HubName, HubListenConnectionString, this);
       // if(DataBaseMngr.getPushID(this)==null)
            registerWithNotificationHubs();
    }
    @SuppressWarnings("unchecked")
    private void registerWithNotificationHubs() {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... params) {
                try {
                    final String regid = gcm.register(SENDER_ID);
//                    DataBaseMngr.savePushId(regid, getBaseContext());
//                  //  updateUserPushId(regid);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                UserTbl userTbl=msUsertTbl.where().field("id").eq(DataBaseMngr.getLogedUserId(getBaseContext())).top(1).execute().get().get(0);
//                                userTbl.setPushregId(regid);
//                                msUsertTbl.update(userTbl).get();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            } catch (ExecutionException e) {
//                                e.printStackTrace();
//                            }
////                            if (eventTbl.getStatus().equals()) {
////                                mAdapter.remove(item);
////                            }
//                        }
//                    });
                ToastNotify("Registered Successfully - RegId : " +
                        hub.register(regid).getRegistrationId());
                } catch (Exception e) {
                    ToastNotify("Registration Exception Message - " + e.getMessage());
                    return e;
                }
                return null;
            }
        }.execute(null, null, null);
    }
    /**
     * Example code from http://msdn.microsoft.com/library/azure/dn495627.aspx
     * to parse the connection string so a SaS authentication token can be
     * constructed.
     *
     * @param connectionString This must be the DefaultFullSharedAccess connection
     *                         string for this example.
     */
    private void ParseConnectionString(String connectionString)
    {
        String[] parts = connectionString.split(";");
        if (parts.length != 3)
            throw new RuntimeException("Error parsing connection string: "
                    + connectionString);

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith("Endpoint")) {
                this.HubEndpoint = "https" + parts[i].substring(11);
            } else if (parts[i].startsWith("SharedAccessKeyName")) {
                this.HubSasKeyName = parts[i].substring(20);
            } else if (parts[i].startsWith("SharedAccessKey")) {
                this.HubSasKeyValue = parts[i].substring(16);
            }
        }
    }
    /**
     * Example code from http://msdn.microsoft.com/library/azure/dn495627.aspx to
     * construct a SaS token from the access key to authenticate a request.
     *
     * @param uri The unencoded resource URI string for this operation. The resource
     *            URI is the full URI of the Service Bus resource to which access is
     *            claimed. For example,
     *            "http://<namespace>.servicebus.windows.net/<hubName>"
     */
    private String generateSasToken(String uri) {

        String targetUri;
        try {
            targetUri = URLEncoder
                    .encode(uri.toString(), "UTF-8")
                    .toLowerCase();

            long expiresOnDate = System.currentTimeMillis();
            int expiresInMins = 60; // 1 hour
            expiresOnDate += expiresInMins * 60 * 1000;
            long expires = expiresOnDate / 1000;
            String toSign = targetUri + "\n" + expires;

            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = HubSasKeyValue.getBytes("UTF-8");
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(toSign.getBytes("UTF-8"));

            // Using android.util.Base64 for Android Studio instead of
            // Apache commons codec
            String signature = URLEncoder.encode(
                    Base64.encodeToString(rawHmac, Base64.NO_WRAP).toString(), "UTF-8");

            // Construct authorization string
            String token = "SharedAccessSignature sr=" + targetUri + "&sig="
                    + signature + "&se=" + expires + "&skn=" + HubSasKeyName;
            return token;
        } catch (Exception e) {
            createAndShowDialog( e.getMessage().toString(),"Exception Generating SaS");
        }

        return null;
    }
    /**
     * Send Notification button click handler. This method parses the
     * DefaultFullSharedAccess connection string and generates a SaS token. The
     * token is added to the Authorization header on the POST request to the
     * notification hub. The text in the editTextNotificationMessage control
     * is added as the JSON body for the request to add a GCM message to the hub.
     *
     *
     */
    public void sendNotification(String toSend) {


        //EditText notificationText = (EditText) findViewById(R.id.editTextNotificationMessage);
        final String json = "{\"data\":{\"message\":\"" + toSend + "\"}}";

        new Thread()
        {
            public void run()
            {
                try
                {
                    HttpClient client = new DefaultHttpClient();

                    // Based on reference documentation...
                    // http://msdn.microsoft.com/library/azure/dn223273.aspx
                    ParseConnectionString(HubFullAccess);
                    String url = HubEndpoint + HubName + "/messages/?api-version=2015-01";
                    HttpPost post = new HttpPost(url);

                    // Authenticate the POST request with the SaS token
                    post.setHeader("Authorization", generateSasToken(url));

                    // JSON content for GCM
                    post.setHeader("Content-Type", "application/json;charset=utf-8");

                    // Notification format should be GCM
                    post.setHeader("ServiceBusNotification-Format", "gcm");
                    post.setEntity(new StringEntity(json));

                    HttpResponse response = client.execute(post);
                }
                catch(Exception e)
                {
                    createAndShowDialog( e.getMessage().toString(),"Exception");
                }
            }
        }.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

    public void ToastNotify(final String notificationMessage)
    {
        if (isVisible == true)
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getBaseContext(), notificationMessage, Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void initRemoteData() {
        mProgressBar= (ProgressBar) findViewById(R.id.progressBar);

        try {

            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    this).withFilter(new ProgressFilter());


        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void onJoinEvent(JoinEventDialog e) {
        Toast.makeText(getBaseContext(), "MainHomeactivity here calling join ", Toast.LENGTH_SHORT).show();

    }

    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsToListAndMap(final EventTblAdapter mEventAdapter, final GoogleMap mMap) {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if (msEventTbl == null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEventTbl.orderBy("date", QueryOrder.Descending).execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mEventAdapter.clear();
                            mMap.clear();
                            for (int i = 0; i < results.size(); i++) {
                                EventTbl item = results.get(i);
                                mEventAdapter.add(results.get(i));
                                LatLng loc = new LatLng(item.getLat(), item.getLang());
                                MarkerOptions markerOptions = new MarkerOptions().position(loc).title(item.getTitle());
                                mMap.addMarker(markerOptions);
                                // Locate the first location
                                if (i == 0) {

                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 13));
                                }
                            }
                        }
                    });
                } catch (final Exception e) {
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }

    private  static class MyPagerAdatpter extends FragmentPagerAdapter
    {
        Fragment[] fragments;
        public MyPagerAdatpter(FragmentManager fm,Fragment[] fragments) {
            super(fm);
            this.fragments=fragments;
        }

        @Override
        public Fragment getItem(int position) {

            return fragments[position];
        }

        @Override
        public int getCount() {
            return null==fragments ? 0:fragments.length;
        }
    }



//    //data managing
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.mainpage, menu);
//        return true;
//    }

    /**
     * Select an option from the menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            // refreshItemsFromTable();
        }

        return true;
    }


    /**
     * Add an item to the Mobile Service Table
     *
     * @param item
     *            The item to Add
     */
    public EventTbl addItemInTable(EventTbl item) throws ExecutionException, InterruptedException {
        EventTbl entity = msEventTbl.insert(item).get();
        return entity;
    }

    /**
     * Refresh the list with the items in the Table
     */
    public void refreshPastEventsFromTableOrederByDate( final EventTblAdapter mEventAdapter)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEventTbl ==null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    Calendar calendar=Calendar.getInstance();
                    calendar.roll(Calendar.DAY_OF_MONTH,-1);
                    final List<EventTbl> results = msEventTbl.where().field("date").le(calendar.getTime()).orderBy("date",QueryOrder.Descending).execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mEventAdapter.clear();

                            for (EventTbl item : results) {
                                mEventAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsFromTableOrederByDate( final EventTblAdapter mEventAdapter)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEventTbl ==null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    Calendar calendar=Calendar.getInstance();
                    final List<EventTbl> results = msEventTbl.where().field("date").ge(calendar.getTime()).orderBy("date",QueryOrder.Ascending).execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mEventAdapter.clear();

                            for (EventTbl item : results) {
                                mEventAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsFromTable( final EventTblAdapter mEventAdapter)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEventTbl ==null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEventTbl.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mEventAdapter.clear();

                            for (EventTbl item : results) {
                                mEventAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     * by filter (status event)
     */
    public void refreshEventsFromTable( final EventTblAdapter mEventAdapter, final String status)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEventTbl ==null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEventTbl.where().field("status").eq(status).execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mEventAdapter.clear();

                            for (EventTbl item : results) {
                                mEventAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     */
    public void refreshAllUsersFromTable(final UserTblAdapter mAllUserTblAdapter, final String field)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msUsertTbl==null)
            msUsertTbl = mClient.getTable(UserTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    if(field.equals("all")) {
                        final List<UserTbl> results = msUsertTbl.execute().get();

                        //Offline Sync
                        //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAllUserTblAdapter.clear();
                                mAllUserTblAdapter.addAll(results);
//                            for ( item : results) {
//                                mEventAdapter.add(item);
//                            }
                            }
                        });
                    }
                    else
                    {
                        final List<UserTbl> results = msUsertTbl.where().field("userTafkeed").eq(field).execute().get();

                        //Offline Sync
                        //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAllUserTblAdapter.clear();
                                mAllUserTblAdapter.addAll(results);
//                            for ( item : results) {
//                                mEventAdapter.add(item);
//                            }
                            }
                        });
                    }
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     */
    public void refreshAllUsersFromTableToEvent(final UserTblAdapter mAllUserTblAdapter, final String eventId)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msUsertTbl==null)
            msUsertTbl = mClient.getTable(UserTbl.class);
        if(msGuestsToEvent==null)
            msGuestsToEvent = mClient.getTable(GuestsToEvent.class);



        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                     final List<GuestsToEvent> guestsToEvents = msGuestsToEvent.where().field("eventid").eq(eventId).execute().get();



                        //Offline Sync
                        //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAllUserTblAdapter.clear();
                                for (GuestsToEvent guestsToEvent:guestsToEvents) {
                                    try {
                                        UserTbl userTbl=msUsertTbl.where().field("id").eq(guestsToEvent.getUserId()).execute().get().get(0);
                                        if(userTbl!=null)
                                        {
                                            mAllUserTblAdapter.add(userTbl);
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }


                                }
//                            for ( item : results) {
//                                mEventAdapter.add(item);
//                            }
                            }
                        });


                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }
    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsFromTableByID(final EventTblAdapter eventTblAdapter, final String id)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEventTbl ==null)
            msEventTbl = mClient.getTable(EventTbl.class);


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEventTbl.where().field("hostId").eq(id).execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            eventTblAdapter.clear();
                            eventTblAdapter.addAll(results);
//                            for (EventTbl item : results) {
//                                eventTblAdapter.add(item);
//                            }
                        }
                    });
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        };

        runAsyncTask(task);
    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception
     *            The exception to show in the dialog
     * @param title
     *            The dialog title
     */
    private void createAndShowDialogFromTask(final Exception exception, String title) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createAndShowDialog(exception, "Error");
            }
        });
    }


    /**
     * Creates a dialog and shows it
     *
     * @param exception
     *            The exception to show in the dialog
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

    /**
     *
     * @param message
     *            The dialog message
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

    /**
     * Run an ASync task on the corresponding executor
     * @param task
     * @return
     */
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

    private class ProgressFilter implements ServiceFilter {

        @Override
        public ListenableFuture<ServiceFilterResponse> handleRequest(ServiceFilterRequest request, NextServiceFilterCallback nextServiceFilterCallback) {

            final SettableFuture<ServiceFilterResponse> resultFuture = SettableFuture.create();


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.VISIBLE);
                }
            });

            ListenableFuture<ServiceFilterResponse> future = nextServiceFilterCallback.onNext(request);
//kkkk
            Futures.addCallback(future, new FutureCallback<ServiceFilterResponse>() {
                @Override
                public void onFailure(Throwable e) {
                    e.printStackTrace();
                    resultFuture.setException(e);
                }

                //ssssssssssssss  dsd
                @Override
                public void onSuccess(ServiceFilterResponse response) {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.GONE);
                        }
                    });

                    resultFuture.set(response);
                }
            });

            return resultFuture;
        }
    }

    public void updateEvent(final EventTbl eventTbl) {
        if (mClient == null) {
            return;
        }
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                msEventTbl.update(eventTbl).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
//                            if (eventTbl.getStatus().equals()) {
//                                mAdapter.remove(item);
//                            }
                        }
                    });
                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };

        runAsyncTask(task);

    }
    public void updateUser(final UserTbl userTbl) {
        if (mClient == null) {
            return;
        }

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                msUsertTbl.update(userTbl).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
//                            if (eventTbl.getStatus().equals()) {
//                                mAdapter.remove(item);
//                            }
                        }
                    });
                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };
    }
    public MobileServiceTable<EventTbl> getMsEventTbl() {
        return msEventTbl;
    }

    public MobileServiceTable<UserTbl> getMsUsertTbl() {
        return msUsertTbl;
    }

}
