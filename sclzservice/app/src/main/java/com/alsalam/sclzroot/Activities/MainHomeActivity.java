package com.alsalam.sclzroot.Activities;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.MyFragments.AddEventFragment;
import com.alsalam.sclzroot.MyFragments.CalendarFragment;
import com.alsalam.sclzroot.MyFragments.EventStoriesFragments;
import com.alsalam.sclzroot.MyFragments.EventsToParticipate;
import com.alsalam.sclzroot.MyFragments.MapListFragment;
import com.alsalam.sclzroot.MyFragments.MyEventsFragment;
import com.alsalam.sclzroot.MyFragments.Profile2Fragment;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;
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
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainHomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    Fragment[] fragments;
    MyPagerAdatpter myPagerAdatpter;
    TabLayout tabLayout;




    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<EventTbl> msEnetTbl;
    private MobileServiceTable<UserTbl> msUsersTbl;

    private EventTblAdapter mAdapter;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        viewPager= (ViewPager) findViewById(R.id.homepager);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
        //rgLocation = (RadioGroup) findViewById(R.id.rgLocation);
        initRemoteData();


        //to do
        fragments=new Fragment[7];
        fragments[0]=new MapListFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_map));

        fragments[1]=new EventStoriesFragments();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_stories));

        fragments[2]=new AddEventFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_add_event));

        fragments[3]=new MyEventsFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_my_event));


        fragments[4]=new EventsToParticipate();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_event_to_go));







        fragments[5]=new Profile2Fragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_profile));



        fragments[6]=new CalendarFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_calendar));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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

    private void initRemoteData() {
        mProgressBar= (ProgressBar) findViewById(R.id.progressBar);

        try {

            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    this).withFilter(new ProgressFilter());


            //initLocalStore().get();


            // Create an adapter to bind the items with the view


            // Load the items from the Mobile Service
            //refreshItemsFromTable();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

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



    //data managing
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * Select an option from the menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
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
        EventTbl entity = msEnetTbl.insert(item).get();
        return entity;
    }
    /**
     * Refresh the list with the items in the Table
     */


    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsFromTable(ListView listView,int itmLayout)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEnetTbl==null)
        msEnetTbl = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
        mAdapter = new EventTblAdapter(this,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEnetTbl.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (EventTbl item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
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
    public void refreshWaitingEventsFromTable(ListView listView,int itmLayout) {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEnetTbl==null)
        msEnetTbl = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
        mAdapter = new EventTblAdapter(this,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEnetTbl.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (EventTbl item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
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
    public void refreshEventsAddedFromTable(ListView listView,int itmLayout) {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEnetTbl==null)
            msEnetTbl = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
            mAdapter = new EventTblAdapter(this,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEnetTbl.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (EventTbl item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
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
    public void refreshEventsParticipatedFromTable(ListView listView,int itmLayout) {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEnetTbl==null)
            msEnetTbl = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
            mAdapter = new EventTblAdapter(this,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEnetTbl.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (EventTbl item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
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
    public void userLogin(final String userName, final String userPassword) {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msUsersTbl==null)
            msUsersTbl = mClient.getTable(UserTbl.class);

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<UserTbl> results = msUsersTbl.where().field("userName").eq(userName).and().field("userPassword").eq(userPassword).execute().get();

                } catch (final Exception e){
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
     * Refresh the list with the items in the Mobile Service Table
     */

//    private List<EventTbl> refreshItemsFromMobileServiceTable() throws ExecutionException, InterruptedException, MobileServiceException {
////        return msEnetTbl.where().field("complete").
////                eq(val(false)).execute().get();
//        return msEnetTbl.execute().get();
//    }


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
    /**
     * Mark an item as completed in the Mobile Service Table
     *
     * @param item
     *            The item to mark
     */
    public void checkItemInTable(EventTbl item) throws ExecutionException, InterruptedException {
        msEnetTbl.update(item).get();
    }
}
