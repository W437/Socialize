package com.alsalam.sclzroot.TableManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.alsalam.sclzroot.MyAdapters.UserTblAdapter;
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

/**
 * Created by samih on 09/03/2016.
 */
public class DataBaseMngr
{
    public static Activity activity;


    /**
     * Mobile Service Client reference
     */
    public static MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    public static MobileServiceTable<EventTbl> msEvents;
    /**
     * Mobile Service Table used to access data
     */
    public static MobileServiceTable<UserTbl> msUsers;

     //1.
     public static MobileServiceTable<GuestsToEvent> msGuestToEvent;

    public static EventTblAdapter mAdapter;
    public static UserTblAdapter mUserAdapter;

    public static ProgressBar mProgressBar;

    public static void  initMs(Activity activity,ProgressBar mProgressBar)
    {
        DataBaseMngr.activity=activity;
        if(mClient==null) {
            try {

                mClient = new MobileServiceClient(
                        "https://sclzservice.azurewebsites.net",
                        activity).withFilter(new ProgressFilter());


                //initLocalStore().get();


                // Create an adapter to bind the items with the view


                // Load the items from the Mobile Service
                //refreshItemsFromTable();

            } catch (MalformedURLException e) {
                e.printStackTrace();

            }
        }
        if(msEvents==null)
            msEvents=mClient.getTable(EventTbl.class);
        if(msUsers==null)
            msUsers=mClient.getTable(UserTbl.class);

        if(msGuestToEvent==null)
            msGuestToEvent=mClient.getTable(GuestsToEvent.class);

        DataBaseMngr.mProgressBar=mProgressBar;

    }

    /**
     * Add an item to the Mobile Service Table
     *
     * @param item
     *            The item to Add
     */
    public static EventTbl addEventInTable(EventTbl item) throws ExecutionException, InterruptedException {
        EventTbl entity = msEvents.insert(item).get();
        return entity;
    }

     //3.
     public static GuestsToEvent JoinEventTable(String userId,String eventId) throws ExecutionException,InterruptedException{

         GuestsToEvent guestsToEvent =  new GuestsToEvent();
         guestsToEvent.setUserId(userId);
         guestsToEvent.setEventid(eventId);
         guestsToEvent.setStatus("Waiting");

         guestsToEvent = msGuestToEvent.insert(guestsToEvent).get();

        return  guestsToEvent;

     }
    /**
     * Refresh the list with the items in the Table
     */
    public UserTbl loginUsers(ListView listView,int itmLayout)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEvents==null)
            msUsers = mClient.getTable(UserTbl.class);
        if(mUserAdapter==null)
            mUserAdapter = new UserTblAdapter(activity,itmLayout);
         final List<UserTbl> results=null;

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<UserTbl> results = msUsers.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (UserTbl item : results) {
                                mUserAdapter.add(item);
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


            }
        }.execute();
        return  results!=null && results.size()>0 ? results.get(0):  null;
    }

    /**
     * Refresh the list with the items in the Table
     */
    public void refreshEventsFromTable(ListView listView,int itmLayout)
    {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        if(msEvents==null)
            msEvents = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
            mAdapter = new EventTblAdapter(activity,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEvents.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    activity.runOnUiThread(new Runnable() {
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
        if(msEvents==null)
            msEvents = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
            mAdapter = new EventTblAdapter(activity,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEvents.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    activity.runOnUiThread(new Runnable() {
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
        if(msEvents==null)
            msEvents = mClient.getTable(EventTbl.class);
        if(mAdapter==null)
            mAdapter = new EventTblAdapter(activity,itmLayout);

        listView.setAdapter(mAdapter);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<EventTbl> results = msEvents.execute().get();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    activity.runOnUiThread(new Runnable() {
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
     * Refresh the list with the items in the Mobile Service Table
     */

//    private List<EventTbl> refreshItemsFromMobileServiceTable() throws ExecutionException, InterruptedException, MobileServiceException {
////        return msEvents.where().field("complete").
////                eq(val(false)).execute().get();
//        return msEvents.execute().get();
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
        activity.runOnUiThread(new Runnable() {
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
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);

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

    public static class ProgressFilter implements ServiceFilter {

        @Override
        public ListenableFuture<ServiceFilterResponse> handleRequest(ServiceFilterRequest request, NextServiceFilterCallback nextServiceFilterCallback) {

            final SettableFuture<ServiceFilterResponse> resultFuture = SettableFuture.create();


            activity.runOnUiThread(new Runnable() {

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
                    activity.runOnUiThread(new Runnable() {

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
        msEvents.update(item).get();
    }

}
